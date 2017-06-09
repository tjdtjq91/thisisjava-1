package gs1.kingbbode;

import gs1.kingbbode.annotations.Command;
import gs1.kingbbode.domain.Member;
import gs1.kingbbode.enums.Position;
import gs1.kingbbode.exceptions.CommandException;
import gs1.kingbbode.exceptions.DuplicateNameException;
import gs1.kingbbode.exceptions.NotFoundMemberException;

import java.util.Scanner;

/**
 * Created by YG-MAC on 2017. 6. 6..
 */
public class Service {

    private Database database = new Database();
    private Scanner scanner = ScannerHolder.scanner;

    @Command(number = 1, name = "등록")
    public void insert(){
        String name = null;
        Position position = null;
        while (name == null || position == null){
            try {
                name = inputName(name, true, false);
                position = inputPosition(position);
            }catch (CommandException e) {
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("숫자로 입력해주세요.");
            }
        }
        database.save(new Member(name, position));
        System.out.println("등록되었습니다.");
    }

    @Command(number = 2, name = "수정")
    public void update(){
        System.out.print("수정할 사람의 ");
        Member member = database.findByName(inputName(null, false, true));
        Position position = null;
        while(position == null){
            try {
                position = inputPosition(null);
            }catch (CommandException e) {
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("숫자로 입력해주세요.");
            }
        }
        member.update(position);
        database.save(member);
        System.out.println("수정 완료");
    }

    @Command(number = 3, name = "삭제")
    public void delete(){
        System.out.print("삭제할 사람의 ");
        Member member = database.findByName(inputName(null, false, true));
        database.delete(member);
        System.out.println("삭제 완료");
    }

    @Command(number = 4, name = "조회")
    public void search(){
        database.findAll().stream().map(Member::toString).forEach(System.out::println);
    }

    private String inputName(String name, boolean isCheckDuplicate, boolean isCheckContains) {
        if(name != null){
            return name;
        }
        System.out.print("이름은? ");
        name = scanner.next();
        if(!isCheckDuplicate && !isCheckContains){
            return name;
        }
        boolean isExist = database.findByName(name)!=null;
        if(isCheckDuplicate && isExist){
            throw new DuplicateNameException();
        }
        if(isCheckContains && !isExist){
            throw new NotFoundMemberException();
        }
        return name;
    }

    private Position inputPosition(Position position) {
        if(position != null) {
            return position;
        }
        Position.print();
        System.out.print("직급은? ");
        return Position.findByNum(Integer.parseInt(scanner.next()));

    }
}

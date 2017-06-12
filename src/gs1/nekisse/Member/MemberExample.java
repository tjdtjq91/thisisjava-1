package gs1.nekisse.Member;

import java.util.ArrayList;
import java.util.Scanner;
import static gs1.nekisse.Member.Member.isNum;

/**
 * Created by Nekisse_lee on 2017. 6. 5..
 */
public class MemberExample {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> people = new ArrayList<String>();
    boolean start = true;

    public void run(){
        while (start) {
            System.out.println("----------------------------------------");
            System.out.println("1.사원생성 | 2.사원수정 | 3.사원삭제 | 4.사원조회");
            System.out.println("----------------------------------------");
            System.out.print("선택> ");



            String menuNum = scanner.nextLine();
            if(isNum(menuNum)){
                    switch (menuNum) {
                        case "1":
                            addmember();
                            break;
                        case "2":
                            modmember();
                            break;
                        case "3":
                            delmember();
                            break;
                        case "4":
                            searchmember();
                            break;
                    }
                }
        }
    }




    public void addmember() {
        String name="";
        System.out.println("직원 이름 : ex)홍길동  ");
        name = scanner.nextLine();
        people.add(name);

        System.out.println(name+ " 생성하였습니다.");
    }

    public void modmember() {
        String name = "";
        String after= "";
        System.out.println("삭제할 사원의 이름을 적어주세요");
        name = scanner.nextLine();
        System.out.println(name + "을 삭제하였습니다.");
        people.remove(name);
        System.out.println("변경될 사원의 이름을 적어주세요");
        after = scanner.nextLine();
        people.add(after);
        System.out.println(after + "를 추가했습니다");

    }


    public void searchmember() {
        System.out.println("모든 사원을 조회합니다");
        for (int i = 0; i < people.size(); i++) {
            String AllPeople = people.get(i);
            System.out.println(i+ "번째 사원 : " + AllPeople);
        }
    }


    public void delmember() {
        String name="";
        System.out.println("삭제할 직원 이름 : ex)홍길동 ");
        name = scanner.nextLine();
        people.remove(name);


    }


    }


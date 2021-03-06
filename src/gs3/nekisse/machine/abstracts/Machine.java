package gs3.nekisse.machine.abstracts;

import gs3.nekisse.machine.abstracts.machine_interface.impl.Speaker;

/**
 * Created by Nekisse_lee on 2017. 7. 5..
 */
public abstract class Machine  {
    public String brand;
    public  String type;
    public String name;

    public Machine(String brand, String type, String name){
        this.brand = brand;
        this.type= type;
        this.name = name;
    }


    public void machineUse(){
        System.out.println(this.brand+"회사의 " +"(" + this.type + ")" + this.name +" 사용을 시작합니다.");
    }


    public void powerOn(){
        System.out.println(name + "의 전원을 켭니다.");
    }

    public void powerOff(){
        System.out.println(name + "의 전원을 끕니다.");
    }

    public void volumeup(Speaker speaker){
        speaker.volumeUp();
    }
    public void volumeDown(Speaker speaker){
        speaker.volumeDown();
    }
}

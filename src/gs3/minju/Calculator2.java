package gs3.minju;
import gs3.minju.Interface.Calculatable;

class Calculator2 implements Calculatable {  //interface app
    int num1, num2;

    @Override
    public void number(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    @Override    
    public void sum() { // = multiply
        System.out.println(this.num1 * this.num2);
    }
    
    @Override
    public void avg() { // = division
        System.out.println(this.num2 / this.num1);
    }
}
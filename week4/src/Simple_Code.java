class Supper_Class {
    int age;
    public int num = 10;
    Supper_Class (int age){
        this.age = age;
    }
    public void Display (){
        System.out.println("This is the display method of Supper Class");
    }
    public void getAge (){
        System.out.println("Age is :"+ age);
    }
}
class Sub_class extends Supper_Class{
    Sub_class (int age){
        super(age);
    }
    public int num = 20;

    public void Display (){
        System.out.println("This is the display method of Sub_Class");
    }
    public void my_method(){
        Sub_class sb = new Sub_class(num);
        sb.Display();
        super.Display();
        System.out.println("Value of num in the SubClass " + sb.num);
        System.out.println("Value of num in the SubClass " + super.num);
    }
}
public class Simple_Code {
    public static void main(String[] args) {
        Sub_class sb = new Sub_class(30);
        sb.my_method();
        sb.getAge();
    }
}

public class Inner_Class {
    public static void main(String args[]) {
        Outer_Demo outer = new Outer_Demo();
        Outer_Demo.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());
    }
}
class Outer_Demo {
    private int num = 108;
    public class Inner_Demo {
        public int getNum() {
            System.out.println("This is the getNum method of the Inner class");
            return num;
        }
    }
}


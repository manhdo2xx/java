public class Student extends Person{
    private int studentNumber;
    public Student(String name, int age, int studentNumber) {
        super(name, age);
        this.studentNumber = studentNumber;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    @Override
    public void printPerson() {
        super.printPerson(); // Call the print method of the superclass (Person)
        System.out.println("Student number: " + studentNumber);
    }
    public static void main(String[] args) {
        Student Student1 = new Student("John", 35, 1337);
        Student1.printPerson();
    }
}

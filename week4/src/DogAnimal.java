interface Animal{

}

class Mammal implements Animal{

}
public class DogAnimal extends Mammal {
    public static void main(String[] args) {
        Mammal m = new Mammal();
        DogAnimal d = new DogAnimal();
        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        System.out.println(d instanceof Animal);
    }
}

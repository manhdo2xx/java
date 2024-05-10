import java.util.ArrayList;
import java.util.List;

interface Calculator {
    int add(int a, int b);
}


public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            num.add(i + 1);
        }
        num.forEach((numItem) -> System.out.println(numItem));
        Calculator calculator = (a, b) -> {
            int result = a + b;
            System.out.println("Giá trị của phép cộng là: " + result);
            return result;
        };
        int sum = calculator.add(10, 20);
    }
}

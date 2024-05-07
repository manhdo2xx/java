import java.util.Arrays;
import java.util.Scanner;

public class ARRAY_ENUMS {
    public static void main(String[] args) {
        int [] a = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 mảng số nguyên: ");
        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

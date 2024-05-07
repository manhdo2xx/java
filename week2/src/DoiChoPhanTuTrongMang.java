import java.util.Arrays;
import java.util.Scanner;

public class DoiChoPhanTuTrongMang {
    private static final int max = 10;
    public static void main(String[] args) {
        int[] a = new int[max];
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào giá trị của mảng: ");
        for (int i = 0; i < a.length; i++) {
            if (sc.hasNextInt()){
                a[i] = sc.nextInt();
            } else {
                break;
            }
        }
        Arrays.sort(a);
        System.out.println("Mảng bạn vừa nhập là: "+ Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 3){
                for (int j = i+1; j < a.length; j++) {
                    if (a[j]==4){
                        int temp = a[i+1];
                        a[i+1] = a[j];
                        a[j] = temp;
                        break; // đổi chỗ 1 lần
                    }
                }
            }
        }
        System.out.println("Mảng bạn vừa nhập là: "+ Arrays.toString(a));
    }
}

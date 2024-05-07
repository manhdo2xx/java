import java.time.Year;
import java.util.Scanner;

public class ShowDateOfMonth {
    public static void main(String[] args) {
        //tạo mảng chứa ngày trong tháng
        int[] day = new int[31];
        for (int i = 0; i < day.length; i++) {
            day[i] = i+1;
            //System.out.print(" "+day[i]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn năm:" );
        int nam = sc.nextInt();
        System.out.println("Chọn tháng: ");
        int thang = sc.nextInt();
        Year year = Year.of(nam);
        System.out.println("Bạn vừa chọn tháng " + thang + " năm "+ nam);
        System.out.println("Những ngày trong tháng " + thang+ " là:");
        if (year.isLeap()){
            for (int i = 0; i < day.length-2; i++) {
                System.out.print(" "+day[i]);
            }
        } else if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12){
            for (int i = 0; i < day.length; i++) {
                System.out.print(" "+day[i]);
            }
        } else {
            for (int i = 0; i < day.length-1; i++) {
                System.out.print(" "+day[i]);
            }
        }
    }
}

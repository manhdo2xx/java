import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class GetDate {
    public static void main(String[] args) {
        GregorianCalendar gcalendar = new GregorianCalendar();
        // Lấy giá trị ngày tháng năm, kểm tra năm có nhuận hay không;
        Date dt = new Date();
        System.out.println(dt.toString());
        SimpleDateFormat spd = new SimpleDateFormat("dd-MM-yyy");
        System.out.println("NOW: " + spd.format(dt));
        int yearNow = gcalendar.get(Calendar.YEAR);
        if(gcalendar.isLeapYear(yearNow)){
            System.out.println("Là năm nhuận");
        } else {
            System.out.println("Là năm không nhuận");
        }
        //so sánh ngày
        LocalDate lD = LocalDate.of(2024,04,30);
        LocalDate now = LocalDate.now();
        Date ldDate = java.sql.Date.valueOf(lD);
        if(lD.isBefore(now)){
            System.out.println(spd.format(ldDate)+ "  là quá khứ!");
        } else
            if (lD.isAfter(now)){
            System.out.println(spd.format(ldDate)+ " Đây là tương lai!");
        } else {
            System.out.println(spd.format(ldDate)+ " Đây là ngày hôm nay!");
        }
    }

}

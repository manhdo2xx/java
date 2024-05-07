import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTime {
    public static void main(String[] args) {
        DateTime DT = new DateTime();
        DT.LocalDate();
    }
    public void LocalDate(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formatDate = dateFormat.format(now);
        System.out.println("Hôm nay là ngày: " + formatDate);
    }

}

import java.time.*;
import java.time.format.DateTimeFormatter;

public class JavaTime {
    public static void main(String[] args) {
        LocalDate lD = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime lDT = LocalDateTime.now();
        System.out.println("Bây giờ là: "+ time + " Ngày: " +lD);
        System.out.println(lDT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateNow = formatter.format(lDT);
        System.out.println(dateNow);
        String dateString = "10/08/2001";
        LocalDate dateBirthDay = LocalDate.parse(dateString, formatter);
        System.out.println("Ngày: " + formatter.format(dateBirthDay));
    }
}

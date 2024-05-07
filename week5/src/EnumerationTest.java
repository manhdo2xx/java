import java.util.Objects;
import java.util.Properties;
import java.util.Vector;
import java.util.Enumeration;

public class EnumerationTest {

    public static void main(String args[]) {
        Enumeration<String> daysVector;
        Vector<String> dayNames = new Vector<>();

        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        daysVector = dayNames.elements();

        while (daysVector.hasMoreElements()) {
            System.out.println(daysVector.nextElement());
        }

        System.out.println("------------------------------");

        Enumeration<Object> daysProperties ;
        Properties dayName = new Properties();
        dayName.put("1","Sunday");
        dayName.put("2","Monday");
        dayName.put("3","Tuesday");
        dayName.put("4","Wednesday");
        dayName.put("5","Thursday");
        dayName.put("6","Friday");
        dayName.put("7","Saturday");
        daysProperties = dayName.keys();

        while (daysProperties.hasMoreElements()) {
            Object key  = daysProperties.nextElement();
            Object value = dayName.get(key.toString());
            System.out.println("Day " + key + ": " + value);
        }
    }
}
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 8, 4, 5, 6, 7, 9, 10);

        // forEach: In ra từng phần tử trong stream
        System.out.println("Using forEach:");
        numbers.stream()
                .forEach(System.out::println);

        // map: Nhân mỗi số trong stream với 2
        System.out.println("\nUsing map:");
        numbers.stream()
                .map(n -> n * 2)
                .forEach(System.out::println);

        // filter: Lọc các số chẵn từ stream
        System.out.println("\nUsing filter:");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // limit: Giới hạn số lượng phần tử trong stream
        System.out.println("\nUsing limit:");
        numbers.stream()
                .limit(5)
                .forEach(System.out::println);

        // sorted: Sắp xếp các số trong stream
        System.out.println("\nUsing sorted:");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        // collect: Thu thập các phần tử từ stream thành một collection
        System.out.println("\nUsing collect:");
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        // statistic: Lấy thống kê về stream
        System.out.println("\nUsing summaryStatistics:");
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Count: " + stats.getCount());
    }
}


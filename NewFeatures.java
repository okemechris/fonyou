import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class NewFeatures {

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2023, 4, 18);
        LocalDate date2 = LocalDate.of(2023, 4, 20);

        System.out.println(getLastDate(date1, date2));
        printColours();

    }

    public static LocalDate getLastDate(LocalDate date1, LocalDate date2) {
        return date1.isAfter(date2) ? date1 : date2;
    }

    public static void printColours(){
        List<String> colours = Arrays.asList("green", "red", "yellow", "white");
        colours.forEach(System.out::println);
    }

    public static void listOfStringsJava9(){
        List<String> colours = List.of("black", "white", "blue", "yellow");
        System.out.println(colours);
    }
}



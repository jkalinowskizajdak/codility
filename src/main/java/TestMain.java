import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {

    private static class Test {
        Integer age;
        Test(Integer value) {
            age = value;
        }

    }

    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        phones.forEach(System.out::println);

        Point punkt = new Point();
        punkt.x = 5;
        punkt.y = 5;

       change(punkt);

        System.out.println("Współrzędne to: "+punkt.x+" "+punkt.y);

        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();
        System.out.println(desiredString);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        String commaSeparatedNumbers = numbers.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(", "));

        System.out.println(commaSeparatedNumbers);

        List<Test> tests = Arrays.asList(new Test(17), new Test(60), new Test(29), new Test(null));

        Predicate<Integer> pre = (age) -> {
            if (age != null && age > 20) {
                return true;
            } else {
                return false;
            }};

        Stream<Integer> t1 = tests.stream().map(test -> test.age).filter(pre);

        t1.forEach(System.out::println);

        List<Integer> ages = tests.stream().map(test -> test.age).filter(pre).collect(Collectors.toList());

        ages.forEach(System.out::println);
    }

    static void change(Point point){
        point.x++;
        point.y++;
    }

    public static class Point {

        int x;
        int y;

    }

}

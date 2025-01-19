import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
// https://www.geeksforgeeks.org/stream-in-java/
// https://www.geeksforgeeks.org/java-collectors/

public class StreamAPI {

    public static void main(String args[])
    {
        System.out.println("Hello Stream!");

        List<Integer> list = Arrays.asList(1,2,3,4,5,5,6,7,7,8);
        list.stream().map(x->x*2).forEach(System.out::println);
        list.stream().filter(x->x%2==0).forEach(System.out::println);
        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        List<Integer> integerList=list.stream().map(x->x*x).collect(Collectors.toList());
        list.stream().distinct().forEach(System.out::println);
        list.stream().map(x->x*2).collect(Collectors.toSet()).forEach(System.out::println);
        list.stream().filter(x->x%2==0).collect(Collectors.toList());
        long x=list.stream().distinct().count();
        System.out.println(x);

        list.parallelStream().forEachOrdered(System.out::print); // To use multicore processing
        list.parallelStream().forEach(System.out::print);

        // Find the minimum value using stream min()
        Optional<Integer> min = list.stream()
                .min(Integer::compare);
        // Find the maximum value using stream max()
        Optional<Integer> max = list.stream()
                .max(Integer::compare);
        if (min.isPresent()) {
            System.out.println("Minimum value: " + min.get());
        } else {
            System.out.println("The list is empty.");
        }
        if (max.isPresent()) {
            System.out.println("Maximum value: " + max.get());
        } else {
            System.out.println("The list is empty.");
        }

        list.stream().limit(3).forEach(System.out::println);
        list.stream().skip(2).forEach(System.out::println);

           // findFirst
        Optional<Integer> first = list.stream()
                .findFirst();
        System.out.println(first.get());
           // findAny
        Optional<Integer> any = list.stream()
                .findAny();
        System.out.println(any.get());


        // The peek method is a handy tool for debugging and observing intermediate values within a stream pipeline without affecting the elements themselves.
        // Interfering operations within peek can lead to unexpected behavior and should be avoided.

        List<Integer> list3 =Arrays.asList(1,2,3,4,5,6);
        list3.stream()
                .peek(n -> System.out.println("Processing number: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Doubled number: " + n))
                .forEach(System.out::println);


        // Count frequency of each character in string
        String s = "geeks";

        Map<Character, Long> characterCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(characterCount);
        

    }
}

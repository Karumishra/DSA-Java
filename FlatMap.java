import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// https://www.geeksforgeeks.org/stream-flatmap-java-examples/

public class FlatMap {

    public static void main(String args[])
    {
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(5,6,7,8);

        List<List<Integer>> list3 = Arrays.asList(list1,list2);
        System.out.println(list3);

        list3.stream().flatMap(s->s.stream()).forEach(System.out::print);

        // Creating a List of Strings
        List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");

        // Using Stream flatMap(Function mapper)
        list.stream()
                .flatMap(str -> Stream.of(str.charAt(2)))
                .forEach(System.out::println);

        // In this schenario map is not used flatmap is preferred
        list.stream().map(s->Stream.of(s.charAt(2))).forEach(System.out::println);

    }
}

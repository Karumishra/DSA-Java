import java.util.Arrays;
import java.util.List;

class MathUtil{
    static void square(int n) {
        System.out.println(n * n);
    }
}

class Printer{
    void print(String msg) {
        System.out.println(msg);
    }
}

public class MethodReference {
    public static void main(String[] args) {

        // static method reference is used to refer to a static method of a class. It replaces a lambda expression that simply calls a static method
        List<Integer> list = Arrays.asList(2, 3, 4);
        list.forEach(MathUtil::square);

        // method reference refers to an instance method of a specific object. The object is already created, and its method is referenced directly
        Printer printer = new Printer();
        List<String> data = Arrays.asList("Java", "Spring", "Boot");

        data.forEach(printer::print);


        // refers to an instance method of any object of a particular class. The actual object is determined at runtime
        List<String> names = Arrays.asList("java", "spring", "microservice");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}

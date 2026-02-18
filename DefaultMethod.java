//https://www.geeksforgeeks.org/java/default-methods-java/

//Interfaces can now have both abstract and default methods.
//Default methods provide backward compatibility without breaking existing code.
//They allow API evolution and support new features like Streams and Lambdas.

interface Operation {
    void add(int a, int b);
    default void show() {
        System.out.println("Default method");
    }
}

public class DefaultMethod implements Operation {

    public static void main(String[] args) {
        System.out.println("Hello Coder");
        DefaultMethod operation = new DefaultMethod();
        operation.add(1,9);
        operation.show();
    }

    @Override
    public void add(int a, int b) {
        System.out.println("Sum is: "+(a+b));
    }
}

// https://www.geeksforgeeks.org/java/can-we-override-default-method-in-java/ Important
//https://www.geeksforgeeks.org/java/lambda-expressions-java-8/

//Functional Interface having single abstract method
interface Add {
    int add(int a, int b);
}

interface Mul {
    int mul(int x, int y);
}

public class LambdaExpression {
    public static void main(String[] args) {
        Add addition = (a, b) -> (a + b);
        System.out.println(addition.add(9,6));

        Mul mul = (x, y)-> (x * y);
        System.out.println(mul.mul(2,8));
    }
}

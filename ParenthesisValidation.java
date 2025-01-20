import java.util.Stack;

public class ParenthesisValidation {
    public static boolean isValid(String s) {
        // Stack to store opening parentheses
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // For closing brackets, check for a matching opening bracket
            else if (c == ')' && (stack.pop() != '(')) {
                return false;
            } else if (c == '}' && (stack.pop() != '{')) {
                return false;
            } else if (c == ']' && (stack.pop() != '[')) {
                return false;
            }
        }

        // If the stack is not empty, it means there are unmatched opening brackets
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "()[]{}";
        String test2 = "([{}])";
        String test3 = "(]";
        String test4 = "([)]";
        String test5 = "{[()]}";

        System.out.println(isValid(test1)); // true
        System.out.println(isValid(test2)); // true
        System.out.println(isValid(test3)); // false
        System.out.println(isValid(test4)); // false
        System.out.println(isValid(test5)); // true
    }
}

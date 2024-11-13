package strings;

import java.util.Stack;

public class SentenceValidation {
    public static void main(String[] args) {
        String input = "[{[()]}]";
        System.out.println("Is the input string valid? " + isValid(input));
    }

    public static boolean isValid(String s) {
        /**
         * creates a stack data structure specifically for storing Character objects
         *
         * Stack is a class in Java’s java.util package that represents a Last In, First Out (LIFO) stack of objects
         *
         * <Character> -> generic type parameter
         * This means the stack will only accept Character data types
         */
        Stack<Character> stack = new Stack<>();

        // convert string to character array
        for (char c : s.toCharArray()) {
            // Checking opening brackets and push into the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Checking closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                if (compareBrackets(stack.peek(), c)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * This function compares the last inserted data in stack with the character
     * @param open - last inserted on stack
     * @param close - character to compare
     * @return true if brackets are matching else return false
     */
    private static boolean compareBrackets(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}

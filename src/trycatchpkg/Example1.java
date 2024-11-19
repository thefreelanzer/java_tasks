package trycatchpkg;

public class Example1 {
    public static void main(String args[]) {
        try {
            System.out.println("Start of try block");
            throw new MyException("Error Message");
        } catch (MyException exp) {
            System.out.println("Catch Block");
            System.out.println(exp);
        }
    }
}

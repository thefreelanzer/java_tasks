package trycatchpkg;

public class SampleFinallyBlock {
    public static void main(String args[]) {
        try {
            int data = 55 / 0;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is executed");
        }
        System.out.println("remaining code");
    }
}

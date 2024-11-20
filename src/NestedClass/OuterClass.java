package NestedClass;

public class OuterClass {
    // static member
    static int outer_x = 10;

    // instance(non-static) member
    int outer_y = 20;

    // private member
    private static int outer_private = 30;

    // static nested class
    static class StaticNestedClass {
        void display() {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // outer class
            System.out.println("outer_private = "
                    + outer_private);

            // to access the non-static member
            OuterClass out = new OuterClass();
            System.out.println("outer_y = " + out.outer_y);
        }
    }

    // inner class
    class InnerClass {
        void display()
        {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can also access non-static member of outer
            // class
            System.out.println("outer_y = " + outer_y);

            // can also access a private member of the outer
            // class
            System.out.println("outer_private = "
                    + outer_private);
        }
    }
}

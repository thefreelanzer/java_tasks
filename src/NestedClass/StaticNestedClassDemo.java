package NestedClass;

public class StaticNestedClassDemo {
    public static void main(String[] args) {
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();
        nestedObject.display();

        // accessing an inner class
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerClassObj = outerObject.new InnerClass();

        innerClassObj.display();
    }
}

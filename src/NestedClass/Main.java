package NestedClass;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("101", "Java Programming", "6 weeks");

        Course.Topics topics = course.new Topics();

        topics.saveTopic(1001, "Class", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        topics.saveTopic(1002, "Nested Class", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        topics.saveTopic(1003, "Records", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        topics.displayTopics();
    }
}

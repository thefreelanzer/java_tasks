package NestedClass;

import java.util.ArrayList;
import java.util.List;

public class Course {
    String id;
    String name;
    String duration;

    public Course(String id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    class Topics {
        private List<String> topicsList = new ArrayList<>();

        // Method to add a new topic to the list
        public void saveTopic(int id, String title, String content) {
            String topic = id + ": " + title + " - " + content;
            topicsList.add(topic);
        }

        public void displayTopics() {
            System.out.println("Topics for course: " + name);
            for (String topic : topicsList) {
                System.out.println(topic);
            }
        }
    }
}

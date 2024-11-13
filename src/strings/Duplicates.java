package strings;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    public static void main(String[] arr) {
        String sentance = "This is a test sentence and this is a test example";

        /**
         * Split sentence into array of words using space as the delimiter
         */
        String words[] = sentance.split("\\s+");

        /**
         * Create a HashSet to keep track of the words we've seen
         * Set avoids duplicates
         */
        Set<String> dupArr = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String wordLower = words[i].toLowerCase();
            if (dupArr.contains(wordLower)) {
                System.out.println("Duplicate word found: " + words[i]);
            } else {
                dupArr.add(wordLower);
            }
        }
    }
}

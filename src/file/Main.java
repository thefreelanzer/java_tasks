package file;
// importing the File class

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        createFile();
        writeFile();
        readFile();
        deleteFile();
    }

    public static void createFile() {
        File file = new File("output.txt");
        try {
            boolean value = file.createNewFile();
            if (value) {
                System.out.println("The new file is created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void writeFile() {
        String data = "This is the data in the output file\nLine2\nLine3";
        try {
            // Creates a Writer using FileWriter
            FileWriter output = new FileWriter("output.txt");
            // Writes string to the file
            output.write(data);
            System.out.println("Data is written to the file.");

            // Closes the writer
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void readFile() {
        try {
            // Creates a reader using the FileReader
            /*FileReader input = new FileReader("output.txt");*/

            /**
             * Array
             * When you need to store a fixed-size buffer of characters.
             */
            /*char[] array = new char[100];
            Reads characters
            input.read(array);
            System.out.println("\nData in the file:");
            System.out.println(array);*/

            /**
             * StringBuilder
             * When you want to dynamically append characters as you read.
             */
            /*StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = input.read()) != -1) { //Read character by character
                content.append((char) ch);
            }
            System.out.println("\nData in the file:");
            System.out.println(content.toString());

            //Closes the reader
            input.close();*/

            /**
             * List<Character>
             * When you need to process/manipulate individual characters after reading.
             */
            /*List<Character> charList = new ArrayList<>();
            int ch;
            while ((ch = input.read()) != -1) {
                charList.add((char) ch);
            }
            System.out.println("\nData in the file:");
            for (char c : charList) {
                System.out.print(c);
            }*/

            /**
             * Using String
             * When you simply want to read the entire file content as a single string.
             */
            String content = Files.readString(Paths.get("output.txt"));
            System.out.println("\nData in the file:");
            System.out.println(content);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void deleteFile() {
        // creates a file object
        File file = new File("output.txt");

        // deletes the file
        boolean value = file.delete();
        if (value) {
            System.out.println("The File is deleted.");
        } else {
            System.out.println("The File is not deleted.");
        }
    }

}

package file;

import java.io.*;

public class File {

    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Writing to a file1.");
            writer.write("\nWriting to a file2.");
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            System.out.println("\nEnter the input:");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int number = Integer.parseInt(bufferedReader.readLine());
            System.out.println("output: " + number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


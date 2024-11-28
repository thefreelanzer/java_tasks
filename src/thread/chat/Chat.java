package thread.chat;

import java.io.*;

public class Chat {
    private boolean isUser1Turn = true;

    public synchronized void user1Chat(InputStream inputStream, PipedOutputStream user1Output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message = reader.readLine(); // Read the message from User 1
        System.out.println("User 1: " + message);

        isUser1Turn = false; // Switch to User 2's turn
    }

    public synchronized void user2Chat(InputStream inputStream, PipedOutputStream user2Output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message = reader.readLine(); // Read the message from User 2
        System.out.println("User 2: " + message);

        isUser1Turn = true; // Switch to User 1's turn
    }

    public boolean isUser1Turn() {
        return isUser1Turn;
    }
}

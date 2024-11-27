package thread.chat;

import java.io.*;

public class Chat {
    private boolean isUser1Turn = true;

    public synchronized void user1Chat(InputStream inputStream, OutputStream outputStream) throws IOException {
        while (!isUser1Turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message = reader.readLine();
        System.out.println("User 1: " + message);

        PrintWriter writer = new PrintWriter(outputStream, true);
        writer.println(message);

        isUser1Turn = false;
        notifyAll();
    }

    public synchronized void user2Chat(InputStream inputStream, OutputStream outputStream) throws IOException {
        while (isUser1Turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message = reader.readLine();
        System.out.println("User 2: " + message);

        PrintWriter writer = new PrintWriter(outputStream, true);
        writer.println(message);

        isUser1Turn = true;
        notifyAll();
    }
}

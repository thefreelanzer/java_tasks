package thread.chat;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) throws IOException {
        Chat chat = new Chat();
        PipedInputStream user1Input = new PipedInputStream();
        PipedOutputStream user1Output = new PipedOutputStream(user1Input);

        PipedInputStream user2Input = new PipedInputStream();
        PipedOutputStream user2Output = new PipedOutputStream(user2Input);

        Scanner scanner = new Scanner(System.in);

        Thread user1 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (chat) {
                        // Ensure it's User 1's turn
                        while (!chat.isUser1Turn()) {
                            chat.wait();
                        }

                        // Prompt User 1 for input
                        System.out.print("User 1, type your message: ");
                        String message = scanner.nextLine();

                        // Write User 1's message to the output stream
                        user1Output.write((message + "\n").getBytes());
                        user1Output.flush();

                        // Let the chat process User 1's message
                        chat.user1Chat(user1Input, user1Output);

                        // Notify User 2's thread
                        chat.notifyAll();
                    }
                }
            } catch (IOException | InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        Thread user2 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (chat) {
                        // Ensure it's User 2's turn
                        while (chat.isUser1Turn()) {
                            chat.wait();
                        }

                        // Prompt User 2 for input
                        System.out.print("User 2, type your message: ");
                        String message = scanner.nextLine();

                        // Write User 2's message to the output stream
                        user2Output.write((message + "\n").getBytes());
                        user2Output.flush();

                        // Let the chat process User 2's message
                        chat.user2Chat(user2Input, user2Output);

                        // Notify User 1's thread
                        chat.notifyAll();
                    }
                }
            } catch (IOException | InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        user1.start();
        user2.start();
    }
}

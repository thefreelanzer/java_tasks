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
                        System.out.print("User 1, type your message: ");
                        String message = scanner.nextLine();
                        user1Output.write((message + "\n").getBytes());
                    }
                    chat.user1Chat(user1Input, user2Output);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread user2 = new Thread(() -> {
            try {
                while (true) {
                    chat.user2Chat(user2Input, user1Output);
                    synchronized (chat) {
                        System.out.print("User 2, type your message: ");
                        String message = scanner.nextLine();
                        user2Output.write((message + "\n").getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        user1.start();
        user2.start();
    }
}

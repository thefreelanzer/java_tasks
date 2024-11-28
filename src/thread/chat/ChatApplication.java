package thread.chat;

import java.util.Scanner;

public class ChatApplication {
    private boolean isUser1Turn = true; // To keep track of whose turn it is

    public static void main(String[] args) {
        ChatApplication chatApp = new ChatApplication();
        Scanner scanner = new Scanner(System.in);

        // Thread for User 1
        Thread user1 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (chatApp) {
                        // User 1's turn
                        while (!chatApp.isUser1Turn) {
                            chatApp.wait();
                        }

                        System.out.print("User 1, type your message: ");
                        String message = scanner.nextLine();

                        chatApp.processChat("User 1", message);

                        /**
                         * It wakes up all the threads that are waiting on the chatApp object's monitor.
                         * This is part of Java's synchronization mechanism for thread communication.
                         */
                        chatApp.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        // Thread for User 2
        Thread user2 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (chatApp) {
                        // User 2's turn
                        while (chatApp.isUser1Turn) {
                            chatApp.wait();
                        }

                        System.out.print("User 2, type your message: ");
                        String message = scanner.nextLine();

                        chatApp.processChat("User 2", message);

                        chatApp.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });

        // Start both threads
        user1.start();
        user2.start();
    }

    private synchronized void processChat(String user, String message) {
        System.out.println(user + ": " + message);
        isUser1Turn = !isUser1Turn;
    }
}

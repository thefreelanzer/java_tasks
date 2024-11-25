package thread;

public class ThreadCounter {
    private int count = 0;

    /**
     * Increment the counter
     */
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " Incremented: " + count);
    }

    /**
     * Decrement the counter
     */
    public synchronized void decrement() {
        count--;
        System.out.println(Thread.currentThread().getName() + " Decremented: " + count);
    }

    public static void main(String[] args) {
        ThreadCounter counter = new ThreadCounter();

        // Incrementing
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "IncrementThread");

        // Decrementing
        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.decrement();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "DecrementThread");

        // Start the threads
        incrementThread.start();
        decrementThread.start();

        // Wait for threads to finish
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Count: " + counter.count);
    }
}

package locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private final Integer MAX_SIZE = 5; // Maximum capacity of the buffer
    private final Lock lock = new ReentrantLock(); // Reentrant lock to synchronize access
    private final Queue<Integer> buffer = new LinkedList<>(); // Shared buffer for producer-consumer

    // Condition to signal when the buffer is not full (used by producer)
    private final Condition bufferNotFull = lock.newCondition();
    // Condition to signal when the buffer is not empty (used by consumer)
    private final Condition bufferNotEmpty = lock.newCondition();

    /**
     * Producer method to add an item to the buffer.
     * @param item the item to produce
     */
    private void produce(int item) {
        lock.lock(); // Acquire the lock
        try {
            // If buffer is full, wait for a signal that space is available
            while (buffer.size() == MAX_SIZE) {
                bufferNotFull.await(); // Wait until buffer is not full
            }
            buffer.offer(item); // Add the item to the buffer
            System.out.println("Produced >> " + item);
            bufferNotEmpty.signal(); // Signal consumers that buffer is not empty
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Handle interruptions
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    /**
     * Consumer method to consume an item from the buffer.
     */
    private void consume() {
        lock.lock(); // Acquire the lock
        try {
            // If buffer is empty, wait for a signal that an item is available
            while (buffer.isEmpty()) {
                bufferNotEmpty.await(); // Wait until buffer is not empty
            }
            System.out.println("Consumed << " + buffer.poll()); // Remove and consume an item
            bufferNotFull.signal(); // Signal producers that buffer is not full
        } catch (InterruptedException e) {
            throw new RuntimeException(e); // Handle interruptions
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo(); // Create an instance of ConditionDemo

        // Producer thread to produce items
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) { // Produce 10 items
                    demo.produce(i); // Produce an item
                    Thread.sleep(1000); // Simulate production time
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e); // Handle interruptions
            }
        });

        // Consumer thread to consume items
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) { // Consume 10 items
                    demo.consume(); // Consume an item
                    Thread.sleep(2000); // Simulate consumption time
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e); // Handle interruptions
            }
        });

        producerThread.start(); // Start the producer thread
        consumerThread.start(); // Start the consumer thread
    }
}

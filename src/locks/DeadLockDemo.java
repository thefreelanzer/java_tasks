package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {

    private final Lock lockA = new ReentrantLock();
    private final Lock lockB = new ReentrantLock();

    public void workerOne() {
        lockA.lock();
        System.out.println("worker one acquired lockA");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockB.lock();
        System.out.println("worker one acquired lockB");
        lockA.unlock();
        lockB.unlock();
    }

    public void workerTwo() {
        lockB.lock();
        System.out.println("worker one acquired lockB");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lockA.lock();
        System.out.println("worker one acquired lockA");
        lockB.unlock();
        lockA.unlock();
    }

    public static void main(String[] args) {
        DeadLockDemo demo = new DeadLockDemo();
        new Thread(demo::workerOne, "Worker 1").start();
        new Thread(demo::workerTwo, "Worker 2").start();
    }
}

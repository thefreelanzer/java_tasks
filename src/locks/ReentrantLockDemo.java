package locks;

import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();
    private int sharedData;

    public void methodA() {
        lock.lock();
        try {
            // critical section
            sharedData++;
            System.out.println("Method A: shared = " + sharedData);

            // call methodB(), which also requires lock
            methodB();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            // critical section
            sharedData--;
            System.out.println("Method B: shared = " + sharedData);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();

        for (int i = 0; i < 5; i++) {
            new Thread(demo::methodA).start();
        }
    }
}

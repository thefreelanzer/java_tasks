package thread.cuncurrentcollection;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiStageTour {
    public static final int NUM_TOURIST = 5;
    public static final int NUM_STAGES = 3;
    public static final CyclicBarrier barrier = new CyclicBarrier(NUM_TOURIST, () -> {
        System.out.println("Tour guid start speaking!");
    });

    public static void main(String[] args) {
        for (int i = 0; i < NUM_TOURIST; i++) {
            Thread touristThread = new Thread(new Tourist(i));
            touristThread.start();
        }
    }

    static class Tourist implements Runnable {
        private final int touristId;

        public Tourist(int touristId) {
            this.touristId = touristId;
        }

        @Override
        public void run() {
            for (int i = 0; i < NUM_STAGES; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Tourist " + touristId + " arrives at Stage " + (i + 1));

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

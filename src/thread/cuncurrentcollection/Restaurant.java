package thread.cuncurrentcollection;

import java.util.concurrent.CountDownLatch;

public class Restaurant {
    public static void main(String[] args) throws InterruptedException {
        int numberOfChefs = 5;
        CountDownLatch latch = new CountDownLatch(numberOfChefs);

        new Thread(new Chef("John", "Pizza", latch)).start();
        new Thread(new Chef("James", "Burger", latch)).start();
        new Thread(new Chef("Jacob", "Sandwich", latch)).start();
        new Thread(new Chef("Jack", "Salad", latch)).start();
        new Thread(new Chef("Jose", "Pasta", latch)).start();

        latch.await();
        System.out.println("All the dishes are ready!");
    }
}

class Chef implements Runnable{
    private  String name;
    private String dish;
    private CountDownLatch latch;

    public Chef(String name, String dish, CountDownLatch latch) {
        this.name = name;
        this.dish = dish;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is preparing " + dish);
            Thread.sleep(2000);
            System.out.println(name + " has finished preparing " + dish);
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

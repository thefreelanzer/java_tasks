package thread.cuncurrentcollection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWADemo {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.simulate();
    }
}

class Simulation {
    private final List<Integer> list;

    public Simulation() {
        this.list = new CopyOnWriteArrayList<>();
        this.list.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
    }

    public void simulate()
    {
        Thread one  = new Thread(new WriteTask(list));
        Thread second  = new Thread(new WriteTask(list));
        Thread third  = new Thread(new WriteTask(list));
        Thread fourth  = new Thread(new ReadTask(list));

        one.start();
        second.start();
        third.start();
        fourth.start();
    }
}

class ReadTask implements Runnable {
    private final List<Integer> list;

    public ReadTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(list);
        }
    }
}

class WriteTask implements Runnable {
    private List<Integer> list;
    private Random random;

    public WriteTask(List<Integer> list) {
        this.list = list;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.set(random.nextInt(list.size()), random.nextInt(10));
        }
    }
}

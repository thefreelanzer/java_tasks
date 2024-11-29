package thread.cuncurrentcollection;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        Thread one = new Thread(new FirstThread(exchanger));
        Thread second = new Thread(new SecondThread(exchanger));

        one.start();
        second.start();
    }
}

class FirstThread implements Runnable {
    private final Exchanger<Integer> exchanger;

    public FirstThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int dataToSend = 10;
        System.out.println("First thread is sending data " + dataToSend);
        try {
            Integer receiveData = exchanger.exchange(dataToSend);
            System.out.println("First thread received " + receiveData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class SecondThread implements Runnable {
    private final Exchanger<Integer> exchanger;

    public SecondThread(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            int dataToSend = 20;
            System.out.println("Second thread is sending data " + dataToSend);
            Integer receiveData = exchanger.exchange(dataToSend);
            System.out.println("Second thread received " + receiveData);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
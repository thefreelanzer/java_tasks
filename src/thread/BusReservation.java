package thread;

public class BusReservation {
    public static void main(String[] args) {
        // Set Total Number of seats
        BusReservationSystem bus = new BusReservationSystem(5);

        // Create passengers as threads
        Thread passenger1 = new Thread(() -> bus.reserveSeat("Passenger 1", 3));
        Thread passenger2 = new Thread(() -> bus.reserveSeat("Passenger 2", 2));
        Thread passenger3 = new Thread(() -> bus.reserveSeat("Passenger 3", 1));

        passenger1.start();
        passenger2.start();
        passenger3.start();

        try {
            passenger1.join();
            passenger2.join();
            passenger3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

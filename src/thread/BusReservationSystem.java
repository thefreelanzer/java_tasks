package thread;

public class BusReservationSystem {
    private int numberOfSeatsAvailable;

    public BusReservationSystem(int numberOfSeatsAvailable) {
        this.numberOfSeatsAvailable = numberOfSeatsAvailable;
    }

    /**
     * Method for reserving seats
     *
     * @param passengerName - name of passenger
     * @param seatsRequested - number of seat
     */
    public synchronized void reserveSeat(String passengerName, int seatsRequested) {
        System.out.println(passengerName + " requested " + seatsRequested + " seats.");
        System.out.println("Current seats availability: " + numberOfSeatsAvailable);

        if (seatsRequested <= numberOfSeatsAvailable) {
            numberOfSeatsAvailable -= seatsRequested;
            System.out.println("Booking confirmed for " + passengerName + ". " + seatsRequested + " seat booked.");
        } else {
            System.out.println("Sorry, " + passengerName + ". Not enough seats available.");
        }

        System.out.println("Seats remaining: " + numberOfSeatsAvailable + "\n");
    }
}

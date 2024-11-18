package lms;

public class PaymentHandler {
    public static void processPayment(PaymentMethod paymentMethod, double courseFee) {
        String result = paymentMethod.processPayment(courseFee);
        System.out.println(result);
    }
}

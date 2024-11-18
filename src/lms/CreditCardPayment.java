package lms;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public String processPayment(double courseFee) {
        return "Successfully Paid Amount of " + courseFee + " through Credit card.\n";
    }
}

package lms;

public class UpiPayment implements PaymentMethod {
    @Override
    public String processPayment(double courseFee) {
        return "Successfully Paid Amount of " + courseFee + " through Upi.\n";
    }
}

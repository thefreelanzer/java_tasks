package designpatterns.creational_design_pattern.AbstractFactory;

public class HomeLoan extends Loan {
    @Override
    void getInterestRate(double rate) {
        this.rate = rate;
    }
}

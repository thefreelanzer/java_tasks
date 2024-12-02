package designpatterns.creational_design_pattern.AbstractFactory;

abstract class AbstractFactory {
    public abstract Bank getBank(String bank);

    public abstract Loan getLoan(String loan);
}

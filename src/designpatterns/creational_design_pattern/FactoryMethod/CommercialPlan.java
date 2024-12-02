package designpatterns.creational_design_pattern.FactoryMethod;

public class CommercialPlan extends Plan {
    @Override
    void getRate() {
        rate = 7.50;
    }
}

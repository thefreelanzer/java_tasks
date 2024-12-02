package designpatterns.creational_design_pattern.FactoryMethod;

public class DomesticPlan extends Plan {
    @Override
    void getRate() {
        rate = 3.50;
    }
}

package designpatterns.structural_design_pattern.DecoratorPattern;

public class VegFood implements Food {
    @Override
    public String prepareFood() {
        return "Veg Food";
    }

    @Override
    public double foodPrice() {
        return 50.0;
    }
}

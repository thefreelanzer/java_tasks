package designpatterns.creational_design_pattern.BuilderDesign;

public class Samsung extends Company {
    @Override

    public int price() {
        return 15;
    }

    @Override
    public String pack() {
        return "Samsung CD";
    }
}

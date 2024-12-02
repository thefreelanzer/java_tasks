package designpatterns.creational_design_pattern.AbstractFactory;

public class ICICI implements Bank {
    private final String BNAME;

    public ICICI() {
        BNAME = "ICICI BANK";
    }

    @Override
    public String getBankName() {
        return BNAME;
    }
}

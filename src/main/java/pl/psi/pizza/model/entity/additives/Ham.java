package pl.psi.pizza.model.entity.additives;

public class Ham implements Additive {

    private String name = "Szynka";
    private double price = 2.20;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

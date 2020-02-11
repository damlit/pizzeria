package pl.psi.pizza.model.entity.additives;

public class Artichokes implements Additive {

    private String name = "Karczochy";
    private double price = 1.70;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

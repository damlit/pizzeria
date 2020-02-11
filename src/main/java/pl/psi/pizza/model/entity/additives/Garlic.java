package pl.psi.pizza.model.entity.additives;

public class Garlic implements Additive {

    private String name = "Czosnek";
    private double price = 0.90;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

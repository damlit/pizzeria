package pl.psi.pizza.model.entity.additives;

public class Pepper implements Additive {

    private String name = "Papryka";
    private double price = 0.80;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

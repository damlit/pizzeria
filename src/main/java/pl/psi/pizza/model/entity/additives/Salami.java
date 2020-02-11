package pl.psi.pizza.model.entity.additives;

public class Salami implements Additive {

    private String name = "Salami";
    private double price = 1.60;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

package pl.psi.pizza.model.entity.additives;

public class Mushrooms implements Additive {

    private String name = "Pieczarki";
    private double price = 1.10;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

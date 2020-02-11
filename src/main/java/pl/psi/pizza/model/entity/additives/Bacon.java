package pl.psi.pizza.model.entity.additives;

public class Bacon implements Additive {

    private String name = "Bekon";
    private double price = 2.10;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

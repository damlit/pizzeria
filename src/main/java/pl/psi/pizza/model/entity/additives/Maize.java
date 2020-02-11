package pl.psi.pizza.model.entity.additives;

public class Maize implements Additive {

    private String name = "Kukurydza";
    private double price = 1.90;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

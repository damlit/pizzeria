package pl.psi.pizza.model.entity.additives;

public class Mozzarella implements Additive {

    private String name = "Mozzarella";
    private double price = 1.50;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

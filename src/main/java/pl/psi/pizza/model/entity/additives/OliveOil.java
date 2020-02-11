package pl.psi.pizza.model.entity.additives;

public class OliveOil implements Additive {

    private String name = "Oliwa z oliwek";
    private double price = 3.00;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

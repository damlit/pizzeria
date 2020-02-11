package pl.psi.pizza.model.entity.additives;

public class BlackOlives implements Additive {

    private String name = "Czarne oliwki";
    private double price = 3.20;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

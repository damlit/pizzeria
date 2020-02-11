package pl.psi.pizza.model.entity.additives;

public class GarlicSauce implements Additive {

    private String name = "Sos czosnkowy";
    private double price = 2.50;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

package pl.psi.pizza.model.entity.additives;

public class TomatoSauce implements Additive {

    private String name = "Sos pomidorowy";
    private double price = 2.00;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

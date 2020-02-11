package pl.psi.pizza.model.entity.pizza;

import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.dough.Dough;

import java.util.List;

public abstract class Pizza {

    protected Dough dough;
    protected List<Additive> additives;
    double price;

    public double calculatePrice() {
        additives.stream()
                .map(Additive::getPrice)
                .forEach(pr -> price = price + pr);

        return price + dough.getPrice();
    }
}

package pl.psi.pizza.model.entity.pizza.american;

import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.additives.Mozzarella;
import pl.psi.pizza.model.entity.additives.TomatoSauce;
import pl.psi.pizza.model.entity.dough.ThickDough;
import pl.psi.pizza.model.entity.pizza.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmericanMargerittaPizza extends Pizza {

    public AmericanMargerittaPizza(List<Additive> additives) {
        this.dough = new ThickDough();
        this.additives = new ArrayList<>(Arrays.asList(new TomatoSauce(), new Mozzarella()));
        this.additives.addAll(additives);
    }
}

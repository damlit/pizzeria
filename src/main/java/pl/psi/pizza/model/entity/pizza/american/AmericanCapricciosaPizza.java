package pl.psi.pizza.model.entity.pizza.american;

import pl.psi.pizza.model.entity.additives.*;
import pl.psi.pizza.model.entity.dough.ThickDough;
import pl.psi.pizza.model.entity.pizza.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmericanCapricciosaPizza extends Pizza {

    public AmericanCapricciosaPizza(List<Additive> additives) {
        this.dough = new ThickDough();
        this.additives = new ArrayList<>(Arrays.asList(new TomatoSauce(), new Mozzarella(), new Ham(), new Mushrooms()));
        this.additives.addAll(additives);
    }
}

package pl.psi.pizza.model.entity.pizza.american;

import pl.psi.pizza.model.entity.additives.*;
import pl.psi.pizza.model.entity.dough.ThickDough;
import pl.psi.pizza.model.entity.pizza.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmericanQuatroStagioniPizza extends Pizza {

    public AmericanQuatroStagioniPizza(List<Additive> additives) {
        this.dough = new ThickDough();
        this.additives = new ArrayList<>(Arrays.asList(new TomatoSauce(), new Mozzarella(), new Ham(), new Artichokes(), new Pepper()));
        this.additives.addAll(additives);
    }
}

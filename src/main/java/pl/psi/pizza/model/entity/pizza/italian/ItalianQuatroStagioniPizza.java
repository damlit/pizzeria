package pl.psi.pizza.model.entity.pizza.italian;

import pl.psi.pizza.model.entity.additives.*;
import pl.psi.pizza.model.entity.dough.ThinDough;
import pl.psi.pizza.model.entity.pizza.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItalianQuatroStagioniPizza extends Pizza {

    public ItalianQuatroStagioniPizza(List<Additive> additives) {
        this.dough = new ThinDough();
        this.additives = new ArrayList<>(Arrays.asList(new TomatoSauce(), new Mozzarella(), new Ham(), new Artichokes(), new Pepper()));
        this.additives.addAll(additives);
    }
}

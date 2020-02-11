package pl.psi.pizza.model.entity.pizza.italian;

import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.additives.Mozzarella;
import pl.psi.pizza.model.entity.additives.Mushrooms;
import pl.psi.pizza.model.entity.additives.TomatoSauce;
import pl.psi.pizza.model.entity.dough.ThinDough;
import pl.psi.pizza.model.entity.pizza.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItalianFunghiPizza extends Pizza {

    public ItalianFunghiPizza(List<Additive> additives) {
        this.dough = new ThinDough();
        this.additives = new ArrayList<>(Arrays.asList(new TomatoSauce(), new Mozzarella(), new Mushrooms()));
        this.additives.addAll(additives);
    }
}

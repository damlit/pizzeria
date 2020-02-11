package pl.psi.pizza.model.entity.pizza.american;

import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.additives.BlackOlives;
import pl.psi.pizza.model.entity.additives.Mozzarella;
import pl.psi.pizza.model.entity.additives.TomatoSauce;
import pl.psi.pizza.model.entity.dough.ThickDough;
import pl.psi.pizza.model.entity.pizza.Pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmericanNapoletanaPizza extends Pizza {

    public AmericanNapoletanaPizza(List<Additive> additives) {
        this.dough = new ThickDough();
        this.additives = new ArrayList<>(Arrays.asList(new TomatoSauce(), new Mozzarella(), new BlackOlives()));
        this.additives.addAll(additives);
    }
}

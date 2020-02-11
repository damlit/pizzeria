package pl.psi.pizza.model.control;

import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.pizza.Pizza;
import pl.psi.pizza.model.entity.pizza.american.*;
import pl.psi.pizza.model.entity.pizza.italian.*;

import java.util.List;

public class PizzaFabric {

    private static final String CAPRICCIOSA = "CAPRICCIOSA";
    private static final String DINAMITE = "DINAMITE";
    private static final String FUNGHI = "FUNGHI";
    private static final String HAWAII = "HAWAJSKA";
    private static final String MARGERITA = "MARGERITTA";
    private static final String MARINARA = "MARINARA";
    private static final String NAPOLETANA = "NAPOLETANA";

    public static Pizza bakePizza(String pizzaName, boolean isAmericanDough, List<Additive> additives) {
        if (isAmericanDough) {
          return bakeAmericanPizza(pizzaName, additives);
        }
        return bakeItalianPizza(pizzaName, additives);
    }

    private static Pizza bakeAmericanPizza(String pizzaName, List<Additive> additives) {
        if (CAPRICCIOSA.equals(pizzaName)) {
            return new AmericanCapricciosaPizza(additives);
        } else if (DINAMITE.equals(pizzaName)) {
            return new AmericanDinamitePizza(additives);
        } else if (FUNGHI.equals(pizzaName)) {
            return new AmericanFunghiPizza(additives);
        } else if (HAWAII.equals(pizzaName)) {
            return new AmericanHawaiiPizza(additives);
        } else if (MARGERITA.equals(pizzaName)) {
            return new AmericanMargerittaPizza(additives);
        } else if (MARINARA.equals(pizzaName)) {
            return new AmericanMarinaraPizza(additives);
        } else if (NAPOLETANA.equals(pizzaName)) {
            return new AmericanNapoletanaPizza(additives);
        } else {
            return new AmericanQuatroStagioniPizza(additives);
        }
    }

    private static Pizza bakeItalianPizza(String pizzaName, List<Additive> additives) {
        if (CAPRICCIOSA.equals(pizzaName)) {
            return new ItalianCapricciosaPizza(additives);
        } else if (DINAMITE.equals(pizzaName)) {
            return new ItalianDinamitePizza(additives);
        } else if (FUNGHI.equals(pizzaName)) {
            return new ItalianFunghiPizza(additives);
        } else if (HAWAII.equals(pizzaName)) {
            return new ItalianHawaiiPizza(additives);
        } else if (MARGERITA.equals(pizzaName)) {
            return new ItalianMargerittaPizza(additives);
        } else if (MARINARA.equals(pizzaName)) {
            return new ItalianMarinaraPizza(additives);
        } else if (NAPOLETANA.equals(pizzaName)) {
            return new ItalianNapoletanaPizza(additives);
        } else {
            return new ItalianQuatroStagioniPizza(additives);
        }
    }
}

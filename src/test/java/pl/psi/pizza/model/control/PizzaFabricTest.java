package pl.psi.pizza.model.control;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.additives.Garlic;
import pl.psi.pizza.model.entity.additives.Pepper;
import pl.psi.pizza.model.entity.pizza.Pizza;
import pl.psi.pizza.model.entity.pizza.american.AmericanHawaiiPizza;
import pl.psi.pizza.model.entity.pizza.italian.ItalianHawaiiPizza;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PizzaFabricTest {

    private static final String PIZZA_TYPE_HAWAII = "HAWAJSKA";
    private static List<Additive> additives;

    @Before
    public void prepare() {
        additives = Arrays.asList(new Pepper(), new Garlic());
    }

    @Test
    public void shouldBakeAmericanHawaiiPizzaWithoutAdditives() {
        Pizza pizza = PizzaFabric.bakePizza(PIZZA_TYPE_HAWAII, true, Collections.emptyList());

        Assert.assertTrue(pizza instanceof AmericanHawaiiPizza);
    }

    @Test
    public void shouldBakeItalianHawaiiPizzaWithoutAdditives() {
        Pizza pizza = PizzaFabric.bakePizza(PIZZA_TYPE_HAWAII, false, Collections.emptyList());

        Assert.assertTrue(pizza instanceof ItalianHawaiiPizza);
    }

    @Test
    public void shouldBakeAmericanHawaiiPizzaWithAdditives() {
        Pizza pizza = PizzaFabric.bakePizza(PIZZA_TYPE_HAWAII, true, additives);

        Assert.assertTrue(pizza instanceof AmericanHawaiiPizza);
    }

    @Test
    public void shouldBakeItalianHawaiiPizzaWithAdditives() {
        Pizza pizza = PizzaFabric.bakePizza(PIZZA_TYPE_HAWAII, false, additives);

        Assert.assertTrue(pizza instanceof ItalianHawaiiPizza);
    }
}

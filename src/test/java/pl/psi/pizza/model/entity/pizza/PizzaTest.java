package pl.psi.pizza.model.entity.pizza;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.additives.Garlic;
import pl.psi.pizza.model.entity.additives.Pepper;
import pl.psi.pizza.model.entity.pizza.american.AmericanDinamitePizza;
import pl.psi.pizza.model.entity.pizza.italian.ItalianCapricciosaPizza;

import java.util.Arrays;
import java.util.List;

public class PizzaTest {

    private static Pizza italianPizza;
    private static Pizza americanPizza;

    @Before
    public void prepare() {
        List<Additive> additives = Arrays.asList(new Garlic(), new Pepper());
        italianPizza = new ItalianCapricciosaPizza(additives);
        americanPizza = new AmericanDinamitePizza(additives);
    }

    @Test
    public void shouldCalculatePrizeForItalianPizza() {
        Assert.assertEquals(18.5, italianPizza.calculatePrice(), 0.001);
    }

    @Test
    public void shouldCalculatePrizeForAmericanPizza() {
        Assert.assertEquals(18.8, americanPizza.calculatePrice(), 0.001);
    }
}

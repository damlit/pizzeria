package pl.psi.pizza.model.boundary;

import org.junit.Assert;
import org.junit.Test;
import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.additives.Pepper;
import pl.psi.pizza.model.entity.additives.Pineapple;

import java.util.Optional;

public class AdditiveTypeTest {

    private static final String PEPPER_NAME = "Papryka";
    private static final String PINEAPPLE_NAME = "Ananas";
    private static final String INCORRECT_NAME = "Tablica";

    @Test
    public void shouldReturnAdditive() {
        Optional<Additive> pepper = AdditiveType.getAdditiveByName(PEPPER_NAME);
        Optional<Additive> pineapple = AdditiveType.getAdditiveByName(PINEAPPLE_NAME);

        Assert.assertTrue(pepper.isPresent());
        Assert.assertTrue(pepper.get() instanceof Pepper);
        Assert.assertTrue(pineapple.isPresent());
        Assert.assertTrue(pineapple.get() instanceof Pineapple);
    }

    @Test
    public void shouldNotReturnAdditive() {
        Optional<Additive> nothing = AdditiveType.getAdditiveByName(INCORRECT_NAME);

        Assert.assertTrue(nothing.isEmpty());
    }
}
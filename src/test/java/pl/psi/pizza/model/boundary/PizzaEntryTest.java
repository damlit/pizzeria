package pl.psi.pizza.model.boundary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PizzaEntryTest {

    private static PizzaEntry margeritaPizzaEntry;
    private static PizzaEntry dinamitePizzaEntry;
    private static final String MARGERITA = "MARGERITTA          15.50";
    private static final String DINAMITE = "DINAMITE            15.10";

    private static final String MARGERITA_NAME = "MARGERITTA";
    private static final Double MARGERITA_PRICE = 15.5;
    private static final String DINAMITE_NAME = "DINAMITE";
    private static final Double DINAMITE_PRICE = 15.1;

    @Before
    public void prepare() {
        margeritaPizzaEntry = new PizzaEntry(MARGERITA);
        dinamitePizzaEntry = new PizzaEntry(DINAMITE);
    }

    @Test
    public void shouldCalculateCorrectName() {

        Assert.assertEquals(margeritaPizzaEntry.getName(), MARGERITA_NAME);
        Assert.assertEquals(dinamitePizzaEntry.getName(), DINAMITE_NAME);
    }

    @Test
    public void shouldCalculateCorrectPrice() {

        Assert.assertEquals(margeritaPizzaEntry.getPrice(), MARGERITA_PRICE);
        Assert.assertEquals(dinamitePizzaEntry.getPrice(), DINAMITE_PRICE);
    }
}

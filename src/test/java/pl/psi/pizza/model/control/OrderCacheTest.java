package pl.psi.pizza.model.control;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.psi.pizza.model.boundary.Delivery;
import pl.psi.pizza.model.entity.additives.Pepper;

public class OrderCacheTest {

    private static OrderCache orderCache = OrderCache.getInstance();
    private static final String HAWAII = "HAWAJSKA";
    private static final String PEPPER = "Papryka";

    private static final String THICK_WITH_PEPPER = "17,70";
    private static final String THICK_WITH_PEPPER_WITH_STUDENT_DISCOUNT = "14,16";

    private static final String SUMMARY_ORDER = "Twoje zamówienie: \n" +
            " - HAWAJSKA (grube) dod.: Papryka\n";

    @Before
    public void prepare() {
        orderCache.clearCache();
        orderCache.clearAdditives();

        orderCache.setThickDough(true);
        orderCache.checkAdditive(new Pepper());
        orderCache.addPizza(HAWAII);

        orderCache.setStudent(false);
    }

    @Test
    public void shouldCalculateCostWithoutDeliveryAndStudent() {

        orderCache.setDeliveryPlace(Delivery.PERSONAL_PICKUP.name());

        Assert.assertEquals(THICK_WITH_PEPPER, orderCache.getSummaryCost());
    }

    @Test
    public void shouldCalculateCostWithStudentDiscount() {

        orderCache.setStudent(true);

        Assert.assertEquals(THICK_WITH_PEPPER_WITH_STUDENT_DISCOUNT, orderCache.getSummaryCost());
    }

    @Test
    public void shouldCalculateSummaryOrder() {

        Assert.assertEquals(SUMMARY_ORDER, orderCache.getSummaryOrder());
    }

    @Test
    public void shouldClearCache() {
        Assert.assertNotEquals("0,00", orderCache.getSummaryCost());

        orderCache.clearCache();

        Assert.assertEquals("0,00", orderCache.getSummaryCost());
    }

    @Test
    public void shouldClearAdditives() {
        Assert.assertTrue(orderCache.getSummaryOrder().contains(PEPPER));

        orderCache.clearCache();
        orderCache.clearAdditives();

        orderCache.setThickDough(true);
        orderCache.addPizza(HAWAII);


        Assert.assertFalse(orderCache.getSummaryOrder().contains(PEPPER));
    }
}
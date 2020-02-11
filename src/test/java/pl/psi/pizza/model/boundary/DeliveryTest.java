package pl.psi.pizza.model.boundary;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class DeliveryTest {

    private static final String GRUNDWALD = "Grunwald - 4 zl";
    private static final String JEZYCE = "Jezyce - 5 zl";
    private static final String BIELANY = "Bielany - 41 zl";

    @Test
    public void shouldReturnDelivery() {
        Optional<Delivery> grunwald = Delivery.getPlaceByName(GRUNDWALD);
        Optional<Delivery> jezyce = Delivery.getPlaceByName(JEZYCE);

        Assert.assertTrue(grunwald.isPresent());
        Assert.assertEquals(4.0, grunwald.get().getPrice(), 0.1);
        Assert.assertTrue(jezyce.isPresent());
        Assert.assertEquals(5.0, jezyce.get().getPrice(), 0.1);
    }

    @Test
    public void shouldNotReturnDelivery() {
        Optional<Delivery> badDeliveryPlace = Delivery.getPlaceByName(BIELANY);

        Assert.assertTrue(badDeliveryPlace.isEmpty());
    }
}

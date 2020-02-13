package pl.psi.pizza.model.control;

import pl.psi.pizza.logger.OrderLogger;
import pl.psi.pizza.model.boundary.Delivery;
import pl.psi.pizza.model.entity.additives.Additive;
import pl.psi.pizza.model.entity.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderCache {

    private static OrderCache singleOrderCache = null;
    private OrderLogger logger = new OrderLogger();

    private static List<Pizza> pizzas = new ArrayList<>();
    private static List<Additive> activeAdditives = new ArrayList<>();

    private static boolean thickDough = false;

    private static double summaryCost = 0;
    private static String summaryOrder = "Twoje zamówienie: \n";
    private static Delivery deliveryPlace = Delivery.PERSONAL_PICKUP;
    private static boolean student = false;

    public static OrderCache getInstance() {
        if (singleOrderCache == null) {
            singleOrderCache = new OrderCache();
        }
        return singleOrderCache;
    }

    private OrderCache() {}

    public void addPizza(String pizzaName) {
        pizzas.add(PizzaFabric.bakePizza(pizzaName, thickDough, activeAdditives));

        summaryOrder = summaryOrder + getValueToSummaryOrder(pizzaName);
    }

    public void clearAdditives() {
        activeAdditives.clear();
    }

    public void checkAdditive(Additive additive) {
        if (activeAdditives.contains(additive)) {
            activeAdditives.remove(additive);
        } else {
            activeAdditives.add(additive);
        }
    }

    public String getSummaryCost() {

        calculatePizzasCost();

        summaryCost = summaryCost + deliveryPlace.getPrice();

        if (student) {
            summaryCost = summaryCost * 0.80;
        }

        logger.getLogger().info(getLoggerMessage());

        return String.format("%1.2f", summaryCost);
    }

    public void clearCache() {
        pizzas.clear();
        summaryCost = 0;
        summaryOrder = "Twoje zamówienie: \n";
    }

    public boolean isEmptyDelivery() {
        return pizzas.isEmpty();
    }

    private String getValueToSummaryOrder(String pizzaName) {
        return " - " + pizzaName + getDoughThicknessToSummaryOrder() + getAdditivesToSummaryOrder() + "\n";
    }

    private String getDoughThicknessToSummaryOrder() {
        if (thickDough) {
            return " (grube) ";
        }
        return " (cienkie) ";
    }

    private String getAdditivesToSummaryOrder() {
        return "dod.: " + activeAdditives.stream()
                .map(Additive::getName)
                .collect(Collectors.joining(", "));
    }

    private void calculatePizzasCost() {
        pizzas.stream()
                .map(Pizza::calculatePrice)
                .forEach(pizzaCost -> summaryCost = summaryCost + pizzaCost);
    }

    private String getLoggerMessage() {
        return "Zamowienie za " + String.format("%1.2f", summaryCost) + " zł \n"
                + "miejsce dostawy - " + deliveryPlace.name() + "\n"
                + "Zamowiono: \n" + summaryOrder + "\n--------------------\n";
    }

    public String getSummaryOrder() {
        return summaryOrder;
    }

    public void setDeliveryPlace(String place) {
        deliveryPlace = Delivery.getPlaceByName(place).orElse(Delivery.PERSONAL_PICKUP);
    }

    public void setStudent(boolean studentDiscount) {
        student = studentDiscount;
    }

    public void setThickDough(boolean isThick) {
        thickDough = isThick;
    }
}
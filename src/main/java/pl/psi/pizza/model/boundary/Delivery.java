package pl.psi.pizza.model.boundary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;
import java.util.Optional;

public enum Delivery {

    PERSONAL_PICKUP("Odbior osobisty", 0.0),
    GRUNDWALD("Grunwald - 4 zl", 4.0),
    STARE_MIASTO("Stare miasto - 5 zl", 5.0),
    WILDA("Wilda - 5 zl", 5.0),
    JEZYCE("Jezyce - 5 zl", 5.0),
    NOWE_MIASTO("Nowe miasto - 6 zl", 6.0);

    private String name;
    private double price;

    Delivery(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static Optional<Delivery> getPlaceByName(String name) {
        return Arrays.stream(Delivery.values())
                .filter(deliveryPlace -> name.equals(deliveryPlace.name))
                .findFirst();
    }

    public static ObservableList<String> getPlacesList() {
        return FXCollections.observableArrayList(
                PERSONAL_PICKUP.name,
                GRUNDWALD.name,
                STARE_MIASTO.name,
                WILDA.name,
                JEZYCE.name,
                NOWE_MIASTO.name
        );
    }

    public double getPrice() {
        return price;
    }
}

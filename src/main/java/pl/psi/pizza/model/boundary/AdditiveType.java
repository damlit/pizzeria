package pl.psi.pizza.model.boundary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.psi.pizza.model.entity.additives.*;

import java.util.Arrays;
import java.util.Optional;

public enum AdditiveType {

    PEPPER(new Pepper()),
    GARLIC(new Garlic()),
    MUSHROOMS(new Mushrooms()),
    PINEAPPLE(new Pineapple()),
    MOZZARELLA(new Mozzarella()),
    SALAMI(new Salami()),
    ARTICHOKES(new Artichokes()),
    MAIZE(new Maize()),
    TOMATO_SAUCE(new TomatoSauce()),
    BACON(new Bacon()),
    HAM(new Ham()),
    GARLIC_SAUCE(new GarlicSauce()),
    OLIVE_OIL(new OliveOil()),
    BLACK_OLIVES(new BlackOlives());

    private Additive additive;

    AdditiveType(Additive additive) {
        this.additive = additive;
    }

    public static ObservableList<String> getAdditiveTypes() {
        return FXCollections.observableArrayList(
                PEPPER.additive.getName(),
                GARLIC.additive.getName(),
                MUSHROOMS.additive.getName(),
                PINEAPPLE.additive.getName(),
                MOZZARELLA.additive.getName(),
                SALAMI.additive.getName(),
                ARTICHOKES.additive.getName(),
                MAIZE.additive.getName(),
                TOMATO_SAUCE.additive.getName(),
                BACON.additive.getName(),
                HAM.additive.getName(),
                GARLIC_SAUCE.additive.getName(),
                OLIVE_OIL.additive.getName(),
                BLACK_OLIVES.additive.getName()
        );
    }

    public static Optional<Additive> getAdditiveByName(String name) {
        return Arrays.stream(AdditiveType.values())
                .filter(additive -> name.equals(additive.additive.getName()))
                .findFirst()
                .map(additiveType -> additiveType.additive);
    }
}
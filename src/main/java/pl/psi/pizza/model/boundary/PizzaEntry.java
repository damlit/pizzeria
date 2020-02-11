package pl.psi.pizza.model.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import pl.psi.pizza.model.control.OrderCache;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PizzaEntry extends HBox {

    private String name;
    private Double price;
    private Button addToOrderButton;

    private static final Pattern NAME_PATTERN = Pattern.compile("^([A-Za-z]+).*");
    private static final Pattern PRICE_PATTERN = Pattern.compile(".*(\\d\\d.\\d\\d)");

    public PizzaEntry(String aText) {
        name = calculateName(aText);
        price = calculatePrice(aText);
        getChildren().add(new Label(aText));
        addToOrderButton = new Button("+");
        addToOrderButton.addEventHandler(ActionEvent.ACTION, pizzaHandler);
        getChildren().add(addToOrderButton);
    }

    private EventHandler<ActionEvent> pizzaHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent event) {
            OrderCache.getInstance().addPizza(name);
        }
    };

    private String calculateName(String aText) {
        return matchToPattern(NAME_PATTERN, aText)
                .orElse(aText);
    }

    private Optional<String> matchToPattern(Pattern pattern, String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return Optional.of(matcher.group(1));
        }
        return Optional.empty();
    }

    private Double calculatePrice(String aText) {
        return matchToPattern(PRICE_PATTERN, aText)
                .map(Double::parseDouble)
                .orElse(0.0);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}

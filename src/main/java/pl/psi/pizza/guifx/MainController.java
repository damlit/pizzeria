package pl.psi.pizza.guifx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import pl.psi.pizza.model.boundary.AdditiveType;
import pl.psi.pizza.model.boundary.PizzaEntry;
import pl.psi.pizza.model.AmericanPiePizzaMenu;
import pl.psi.pizza.model.boundary.Delivery;
import pl.psi.pizza.model.ItalianPiePizzaMenu;
import pl.psi.pizza.model.control.OrderCache;

public class MainController {

    private OrderCache orderCache = OrderCache.getInstance();

    private static ObservableList<String> deliveryPlaces = Delivery.getPlacesList();

    @FXML
    private VBox centerBox;
    @FXML
    private Button confirmOrderButton;
    @FXML
    private Label orderPriceLabel;
    @FXML
    private ToggleGroup pieGroup;
    @FXML
    private ChoiceBox<String> delivery;
    @FXML
    private CheckBox student;
    @FXML
    private ListView<CheckBox> additions;

    @FXML
    private void initialize() {
        orderPriceLabel.setText("Tutaj pojawi się Twoje zamowienie.");
        delivery.setValue(Delivery.PERSONAL_PICKUP.name());
        pieGroup.selectedToggleProperty().addListener( (e) -> refreshMenu());
        refreshMenu();
    }

    private void refreshMenu(){
        centerBox.getChildren().clear();

        preparePizzaMenu();

        additions.setItems(getAdditives());

        student.setSelected(false);

        delivery.setItems(deliveryPlaces);

        confirmOrderButton.addEventHandler(ActionEvent.ACTION, confirmOrderHandler);

        orderCache.clearAdditives();
    }

    private void preparePizzaMenu() {
        String selectedRationText = ((RadioButton) pieGroup.getSelectedToggle()).getText();

        if ("Na cienkim".equals(selectedRationText)) {
            orderCache.setThickDough(false);
            ItalianPiePizzaMenu italianMenu = new ItalianPiePizzaMenu();
            for (String pizza: italianMenu.getPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza));
                centerBox.setSpacing(3.0);
            }
        } else if ("Na grubym".equals(selectedRationText)) {
            orderCache.setThickDough(true);
            AmericanPiePizzaMenu americanMenu = new AmericanPiePizzaMenu();
            for (String pizza: americanMenu.getPizzasList() ) {
                centerBox.getChildren().add(new PizzaEntry(pizza));
            }
        }
    }

    private ObservableList<CheckBox> getAdditives() {

        ObservableList<CheckBox> additives = FXCollections.observableArrayList();

        AdditiveType.getAdditiveTypes()
                .forEach(addType -> {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setText(addType);
                    checkBox.addEventHandler(ActionEvent.ACTION, additivesHandler);
                    additives.add(checkBox);
                });

        return additives;
    }

    private EventHandler<ActionEvent> additivesHandler = actionEvent -> {
        if (actionEvent.getSource() instanceof CheckBox) {
            CheckBox checkBox = (CheckBox) actionEvent.getSource();
            AdditiveType.getAdditiveByName(checkBox.getText())
                    .ifPresent(additive -> OrderCache.getInstance().checkAdditive(additive));
        }
    };

    private EventHandler<ActionEvent> confirmOrderHandler = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (orderCache.isEmptyDelivery()) {
                orderPriceLabel.setText("Zamowienie jest puste!");
            } else {
                orderCache.setStudent(student.isSelected());
                orderCache.setDeliveryPlace(delivery.getValue());
                orderPriceLabel.setText("KOSZT: " + orderCache.getSummaryCost() + "\n" + orderCache.getSummaryOrder());
                orderCache.clearCache();
            }
        }
    };
}
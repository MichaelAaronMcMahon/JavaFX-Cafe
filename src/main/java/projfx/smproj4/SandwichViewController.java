
package projfx.smproj4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SandwichViewController {
    @FXML
    public ComboBox<String> cmb_bread;
    @FXML
    public ComboBox<String> cmb_protein;
    @FXML
    public ComboBox<String> cmb_quantity;
    @FXML
    public ListView<String> all_addons;
    @FXML
    public TextField subTotal;
    private HelloController helloController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private ObservableList<String> breadOptionList;
    private ObservableList<String> proteinOptionList;
    private ObservableList<String> addonList;
    private ObservableList<String> qtyList;
    private Sandwich sandwich;
    private int quantity;
    private Order order;


    public void initialize() {

        breadOptionList = FXCollections.observableArrayList("Bagel", "Wheat Bread", "Sour Dough");
        qtyList = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        proteinOptionList = FXCollections.observableArrayList("Beef", "Fish", "Chicken");
        addonList = FXCollections.observableArrayList("Lettuce", "Tomato", "Onion", "Cheese");

        cmb_bread.setItems(breadOptionList);
        cmb_protein.setItems(proteinOptionList);
        cmb_quantity.setItems(qtyList);
        all_addons.setItems(addonList);

        all_addons.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.sandwich = new Sandwich();
        this.quantity = 1;
        this.sandwich.setQuantity(quantity);
        all_addons.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                ObservableList<String> selectedItems = all_addons.getSelectionModel().getSelectedItems();
                for (String s:selectedItems){
                    System.out.println("selected items: " + s);
                }

                selectAddon(selectedItems);
                System.out.println("-----");
            }
        });

    }

    public void setMainController (HelloController controller,
                                   Stage stage,
                                   Stage primaryStage,
                                   Scene primaryScene) {
        helloController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    @FXML
    public void displayMain() {
        //stage.close();
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }
    public void selectAddon(ObservableList<String> addon){
        this.sandwich.addAddon(addon);
        subTotal.setText(String.format("%.2f", this.sandwich.price()));
    }
    @FXML
    public void setBreadOptionList(){

        String breadOption = cmb_bread.getSelectionModel().getSelectedItem();

        if(breadOption.equalsIgnoreCase("Bagel")){
            this.sandwich.setBread("Bagel");
        }
        if(breadOption.equalsIgnoreCase("Wheat Bread")){
            this.sandwich.setBread("Wheat Bread");
        }
        if(breadOption.equalsIgnoreCase("Sour Dough")){
            this.sandwich.setBread("Sour Dough");
        }

        subTotal.setText(String.format("%.2f", this.sandwich.price()));
    }
    @FXML
    public void setProteinOptionList(){

        String proteinOption = cmb_protein.getSelectionModel().getSelectedItem();

        if(proteinOption.equalsIgnoreCase("Beef")){
            this.sandwich.setOption("Beef");
        }
        if(proteinOption.equalsIgnoreCase("Fish")){
            this.sandwich.setOption("Fish");
        }
        if(proteinOption.equalsIgnoreCase("Chicken")){
            this.sandwich.setOption("Chicken");
        }

        subTotal.setText(String.format("%.2f", this.sandwich.price()));
    }
    @FXML
    public void chooseQuantity(){
        String quantityStr = cmb_quantity.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(quantityStr);
        this.sandwich.setQuantity(quantity);
        this.quantity = quantity;
        subTotal.setText(String.format("%.2f", this.sandwich.price()));
    }
    @FXML
    public void addToOrder(){
        this.order.add(sandwich);
        this.sandwich = new Sandwich();
    }

}

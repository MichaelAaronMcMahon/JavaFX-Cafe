
package projfx.smproj4;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.util.Arrays;
import java.util.Collections;

public class CoffeeViewController {
    public ComboBox<String> cmb_cupSize;
    @FXML
    public TextField sub_total;
    @FXML
    public ComboBox<String> cmb_Qty;
    @FXML
    public ListView<String> all_addins;
    private ObservableList<String> cupSizeList;
    private ObservableList<String> qtyList;
    private ObservableList<String> addinList;
    private HelloController helloController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private Coffee coffee;
    private CoffeeCupSize coffeeCupSize;
    private MenuItem[] order;
    private int quantity;
    private int currIndex = 0;
    private boolean opened;
    //public void setOrder(Order order) {
    //    this.order = order;
    //}

    /**
     * Initializes the various observable arraylists and sets the list views with them.
     * Also creates the coffee object, which the user will set the specifications of through the UI.
     */
    public void initialize() {

        cupSizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        qtyList = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        addinList = FXCollections.observableArrayList("Sweet Cream", "French Vanilla", "Irish Cream", "Caramel", "Mocha");

        all_addins.setItems(addinList);
        cmb_cupSize.setItems(cupSizeList);
        cmb_Qty.setItems(qtyList);

        all_addins.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.coffee = new Coffee();
        this.quantity = 1;
        this.coffee.setQuantity(quantity);
        //setOrder();
        this.order = new MenuItem[1];
        this.opened = false;
        all_addins.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                ObservableList<String> selectedItems = all_addins.getSelectionModel().getSelectedItems();
                //for (String s:selectedItems){
                //    System.out.println("selected items: " + s);
               // }

                selectAddin(selectedItems);
            }
        });

    }

    /**
     * Sets CoffeeViewController as the main controller.
     * @param controller
     * @param stage
     * @param primaryStage
     * @param primaryScene
     */
    public void setMainController (HelloController controller,
                                   Stage stage,
                                   Stage primaryStage,
                                   Scene primaryScene) {
        helloController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Allows the user to return to the main menu.
     */
    @FXML
    public void displayMain() {
        //stage.close();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }

    /**
     * Uses the addAddin command of the coffee class to add the addins specified by the user to it.
     * Also sets the subtotal textbox with the updated price given by the coffee class's .price() command.
     * @param addin
     */
    public void selectAddin(ObservableList<String> addin){
        this.coffee.addAddin(addin);
        sub_total.setText(String.format("%.2f", this.coffee.price()));
    }

    /**
     * Sets the size of the coffee object with the size chosen by the user in the cup size combo box.
     * Also updates the subtotal textfield with the coffee object's new price.
     */
    @FXML
    public void setCupSizeList(){

        String cupSize = cmb_cupSize.getSelectionModel().getSelectedItem();

        if(cupSize.equalsIgnoreCase("Short")){
            this.coffeeCupSize = CoffeeCupSize.valueOf("SHORT");
            this.coffee.setCupSize(CoffeeCupSize.valueOf("SHORT"));
        }
        if(cupSize.equalsIgnoreCase("Tall")){
            this.coffeeCupSize = CoffeeCupSize.valueOf("TALL");
            this.coffee.setCupSize(CoffeeCupSize.valueOf("TALL"));
        }
        if(cupSize.equalsIgnoreCase("Grande")){
            this.coffeeCupSize = CoffeeCupSize.valueOf("GRANDE");
            this.coffee.setCupSize(CoffeeCupSize.valueOf("GRANDE"));
        }
        if(cupSize.equalsIgnoreCase("Venti")){
            this.coffeeCupSize = CoffeeCupSize.valueOf("VENTI");
            this.coffee.setCupSize(CoffeeCupSize.valueOf("VENTI"));
        }

        sub_total.setText(String.format("%.2f", this.coffee.price()));
    }

    /**
     * Sets the quantity of the coffee object with the quantity chosen by the user from the quantity
     * combo box and updates the subtotal textfield with the new price.
     */
    @FXML
    public void chooseQuantity(){
        String quantityStr = cmb_Qty.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(quantityStr);
        this.coffee.setQuantity(quantity);
        this.quantity = quantity;
        sub_total.setText(String.format("%.2f", this.coffee.price()));
    }

    /**
     * Adds the coffee object with the specifications selected by the user to the MenuItems array.
     */
    @FXML
    public void addToOrder(){
        if (currIndex == this.order.length){
            grow();
        }
        this.order[currIndex] = coffee;
        this.coffee = new Coffee();
        currIndex++;
    }

    /**
     * Returns the array of MenuItems stored in this controller
     * @return
     */
    public MenuItem[] getOrder(){
        if (this.currIndex == 0){
            return null;
        }
        return this.order;
    }

    /**
     * Used by HelloController to check if a specific coffee object has been added to the MenuItems
     * array.
     * @return
     */
    public boolean checkIfCoffeeAdded(){

        if (opened){
            this.opened = false;
            return true;
        }
        return opened;
    }

    /**
     * Sets the opened instance variable as true.
     */
    public void setOpened(){
        this.opened = true;
    }
    /**
     * Creates a new array with a length 1 space longer and copies the original array to it.
     * It does this when the original array is full.
     */
    private void grow(){

        MenuItem [] replacement = new MenuItem[order.length + 1];

        int i = 0;
        for(MenuItem coffee:order){
            replacement[i] = coffee;
            i ++;
        }
        order = replacement;

    } //helper method to increase the capacity by 1



}

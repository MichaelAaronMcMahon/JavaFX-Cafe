
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
    private MenuItem [] order;
    private boolean opened;
    private int currIndex = 0;

    /**
     * Sets the observable arraylists for the types of bread, protein and addons for the sandwich.
     * Also sets their respective comboboxes and list views. Also creates a sandwich object and the
     * MenuItem array order.
     */
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

        this.order = new MenuItem[1];
        this.opened = false;

        all_addons.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                ObservableList<String> selectedItems = all_addons.getSelectionModel().getSelectedItems();
                //for (String s:selectedItems){
                //}

                selectAddon(selectedItems);
            }
        });

    }

    /**
     * Sets SandwichViewController as the main controller, allowing the user to interact with
     * the objects in the view.
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
     * Takes the user back to the main menu
     */
    @FXML
    public void displayMain() {
        //stage.close();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }

    /**
     * Sets the sandwiches addon array with the addons selected by the user in the
     * multiple select addons list view. Also sets the subtotal textfield with the updated price.
     * @param addon
     */
    public void selectAddon(ObservableList<String> addon){
        this.sandwich.addAddon(addon);
        subTotal.setText(String.format("%.2f", this.sandwich.price()));
    }

    /**
     * Sets the sandwich's bread enum with the user's selection and updates the subtotal textfield with
     * the new price.
     */
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

    /**
     * Sets the sandwich's protein enum with the user's selection and updates the subtotal textfield with
     * the new price.
     */
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

    /**
     * Sets the sandwich's quantity with the user's selection and updates the subtotal textfield with
     * the new price.
     */
    @FXML
    public void chooseQuantity(){
        String quantityStr = cmb_quantity.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(quantityStr);
        this.sandwich.setQuantity(quantity);
        this.quantity = quantity;
        subTotal.setText(String.format("%.2f", this.sandwich.price()));
    }

    /**
     * Adds the sandwich to the MenuItem array, allowing it to be added to the current order being made.
     */
    @FXML
    public void addToOrder(){

        if (currIndex == this.order.length){
            grow();
        }
        this.order[currIndex] = sandwich;
        this.sandwich = new Sandwich();
        currIndex++;
    }

    /**
     * Returns the controller's MenuItem array order.
     * @return
     */
    public MenuItem[] getOrder(){
        if (this.currIndex == 0){
            return null;
        }
        return this.order;
    }

    /**
     * Checks if the sandwich object has been added to the MenuItem array orders, returning true if so.
     * @return
     */
    public boolean checkIfSandwichAdded(){

        if (opened){
            this.opened = false;
            return true;
        }
        return opened;
    }

    /**
     * Sets the opened boolean to true.
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
        for(MenuItem sandwich:order){
            replacement[i] = sandwich;
            i ++;
        }
        order = replacement;

    } //helper method to increase the capacity by 1
}

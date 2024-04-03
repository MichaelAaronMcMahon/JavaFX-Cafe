
package projfx.smproj4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static java.lang.Math.round;

public class CurrentOrderViewController {
    private HelloController helloController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private Order order;
    @FXML
    private ListView<MenuItem> lv_menuItems;
    private ObservableList<MenuItem> menuList;
    @FXML
    private TextField tf_subTotal;
    @FXML
    private TextField tf_salesTax;
    @FXML
    private TextField tf_totalAmount;
    private boolean opened;
    private Order[] orders;
    @FXML Button removeButton;

    /**
     * Runs when the controller is initialized.
     */
    public void initialize() {

    }

    /**
     * Sets the order object.
     * @param order
     */
    public void setOrder(Order order) {
        this.order = order;
        menuList = FXCollections.observableArrayList(this.order.getMenuList());
        lv_menuItems.setItems(menuList);
        //double subTotal = computeSubTotal();
        setSubTotal();
    }

    /**
     * Sets the array of orders.
     * @param orders
     */
    public void setOrders(Order[] orders){
        this.orders = orders;
    }

    /**
     * Iterates through all of the menu items in the order object's MenuItem array and computes the sum
     * of their prices. Then calculates the tax on the subtotal and sets three text fields with the oder's
     * subtotal, tax and final total.
     */
    private void setSubTotal(){
        this.order = order;
        int orderLength = this.order.getAddIndex();
        double subTotal = 0.0;
        for(int i=0; i<orderLength; i++){
            subTotal += this.order.getMenuList()[i].price();
        }
        tf_subTotal.setText(String.format("%.2f", subTotal));
        tf_salesTax.setText(String.format("%.2f", subTotal * 0.06625));
        tf_totalAmount.setText(String.format("%.2f", subTotal + subTotal * 0.06625));

    }

    /**
     * Removes a menu item selected by the user from the menu items list view from the order.
     * Then updates the menu items list view and price text fields with the new information
     */
    @FXML public void removeItem(){
        MenuItem removeItem = lv_menuItems.getSelectionModel().getSelectedItem();
        this.order.remove(removeItem);
        setOrder(this.order);

    }

    /**
     * Sets CurrentOrderViewController as the main controller, allowing the user to interact with its UI.
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
     * Returns the user to the main menu.
     */
    @FXML
    public void displayMain() {
        //stage.close();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }

    /**
     * Checks whether the current order has been placed.
     * @return
     */
    public boolean checkedIfOrderMade() {

        if (opened){
            this.opened = false;
            return true;
        }
        return opened;
    }

    /**
     * Sets the opened variable as true.
     */
    public void setOpened(){
        this.opened = true;
    }

}


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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AllOrdersViewController {
    private HelloController helloController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private Order[] orders;
    private ObservableList<Order> orderList;
    @FXML
    private ListView<Order> lv_orderNumbers;
    @FXML
    private ListView<MenuItem> lv_menuItems;
    private ObservableList<MenuItem> menuList;
    //private int orderIndex;
    private Order orderIndex;
    @FXML
    private TextField totalPrice;

    /**
     * Sets the order object orderIndex which is use to keep track of the index in which orders
     * should be inserted into the orders array
     * @param orderIndex
     */
    public void setOrderIndex(Order orderIndex) {
        this.orderIndex = orderIndex;
    }
    /*public AllOrdersViewController(ListView<Order> lvOrderNumbers) {
        lv_orderNumbers = lvOrderNumbers;
    }*/
    //@FXML ListView

    /**
     * Runs when controller is initialized
     */
    public void initialize() {

    }

    /**
     * Sets the orders array with the orders which have been previously placed by the user,
     * then sets the order number list view which the user can use to select and view an order.
     * @param orders
     */
    public void setOrders(Order[] orders){
        this.orders = orders;
        orderList = FXCollections.observableArrayList();
        for (Order order:orders){
            if(order != null)
                orderList.add(order);
            else
                break;
        }
        //lv_orderNumbers = new ListView<Order>();
        lv_orderNumbers.setItems(orderList);

    }

    /**
     * Exports each order's order number, menu items and price to a text file stored in the src directory
     * of the project.
     * @throws IOException
     */
    public void exportOrder() throws IOException {

        File expFile = new File("src/orders.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(expFile));

        for(int i = 0; i < orderIndex.getOrderNumber(); i++){
            double subtotal = 0;
            writer.write("Order "+ orders[i].toString() + ":" + "\n");
            for(int j = 0; j < orders[i].getAddIndex(); j++){
                writer.write(orders[i].getMenuList()[j].toString() + "\n");
                subtotal += orders[i].getMenuList()[j].price();
            }
            writer.write("Sub-Total: " + String.format("%.2f", subtotal) + "\n");
            writer.write("Sales Tax: " + String.format("%.2f", (subtotal * 0.06625)) + "\n");
            writer.write("Total: " + String.format("%.2f", (subtotal + (subtotal * 0.06625))) + "\n");
            writer.write("______________________________________________\n");

        }
        //writer.write(str);
        writer.close();
        //File src = new File("src/main");
        Stage nstage = new Stage();
        Scene nscene = new Scene(new Label("orders.txt saved to src"));
        nstage.setScene(nscene);
        nstage.show();
        //stage.show();
        //fileChooser.setInitialDirectory();
    }

    /**
     * Cancels an order selected in the order number list view, removing it from the orders array.
     */
    @FXML
    public void cancelOrder(){
        Order order = lv_orderNumbers.getSelectionModel().getSelectedItem();
        int removeID = order.getOrderNumber();
        for(int i = 0; i < this.orderIndex.getOrderNumber(); i++) {
            if (this.orders[i].getOrderNumber() == removeID) {
                this.orders[i] = null;
                for (int j = (i + 1); j < this.orderIndex.getOrderNumber(); j++) {
                    this.orders[j - 1] = this.orders[j];
                    this.orders[j] = null;
                }
                int OI = this.orderIndex.getOrderNumber();
                this.orderIndex.setOrderNumber(OI - 1);
            }
        }
        setOrders(this.orders);
        lv_menuItems.setItems(null);
    }

    /**
     * Displays the price and menu items of an order selected by the user in the order numbers list view
     * in the menu items list view and the total price text box.
     */
    @FXML
    public void displayOrder(){
        Order order = lv_orderNumbers.getSelectionModel().getSelectedItem();
        if (order != null) {
            menuList = FXCollections.observableArrayList(order.getMenuList());
            lv_menuItems.setItems(menuList);
            int orderLength = order.getAddIndex();
            double subTotal = 0.0;
            for(int i = 0; i < orderLength; i++){
                subTotal += order.getMenuList()[i].price();
            }

            totalPrice.setText(String.format("%.2f", subTotal + subTotal * 0.06625));
        }
    }

    /**
     * Sets AllOrdersViewController as the main controller, allowing the user to interact with
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
     * Allows the user to return to the main menu.
     */
    @FXML
    public void displayMain() {
        //stage.close();
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }


}

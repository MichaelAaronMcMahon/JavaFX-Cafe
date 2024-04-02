
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
    @FXML
    private FileChooser fileChooser;

    public void setOrderIndex(Order orderIndex) {
        this.orderIndex = orderIndex;
    }
    /*public AllOrdersViewController(ListView<Order> lvOrderNumbers) {
        lv_orderNumbers = lvOrderNumbers;
    }*/
    //@FXML ListView

    public void initialize() {

    }
    public void setOrders(Order[] orders){
        this.orders = orders;
        orderList = FXCollections.observableArrayList(this.orders);
        //lv_orderNumbers = new ListView<Order>();
        lv_orderNumbers.setItems(orderList);

    }
    public void exportOrder(){
        fileChooser.
    }
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
    @FXML
    public void displayOrder(){
        Order order = lv_orderNumbers.getSelectionModel().getSelectedItem();
        menuList = FXCollections.observableArrayList(order.getMenuList());
        lv_menuItems.setItems(menuList);
        int orderLength = order.getAddIndex();
        double subTotal = 0.0;
        for(int i=0; i<orderLength; i++){
            subTotal += order.getMenuList()[i].price();
        }

        totalPrice.setText(String.format("%.2f", subTotal + subTotal * 0.06625));
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
        primaryStage.setTitle("Main Menu");
        primaryStage.show();
    }


}


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
import java.lang.System.*;
import java.lang.Math.*;

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

    public void initialize() {
        //System.out.println(order.getMenuList()[0].price());

    }



    public void setOrder(Order order) {
        this.order = order;
        //System.out.println(this.order.getMenuList()[0].price());
        menuList = FXCollections.observableArrayList(this.order.getMenuList());
        lv_menuItems.setItems(menuList);
        //double subTotal = computeSubTotal();
        setSubTotal();



    }

    private void setSubTotal(){
        this.order = order;
        int orderLength = this.order.getAddIndex();
        double subTotal = 0.0;
        for(int i=0; i<orderLength; i++){
            subTotal += this.order.getMenuList()[i].price();
        }

        tf_subTotal.setText(String.valueOf(subTotal));
        tf_salesTax.setText(String.valueOf(subTotal * 0.06625));
        tf_totalAmount.setText(String.valueOf(subTotal + subTotal * 0.06625));

    }

    @FXML public void removeItem(){
        //MenuItem removeItem = lv_menuItems.getSelectionModel().getSelectedItem();

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


}

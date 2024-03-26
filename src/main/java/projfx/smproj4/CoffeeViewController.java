
package projfx.smproj4;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private Order order;
    private int quantity;

    public void setOrder(Order order) {
        this.order = order;
    }

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
        all_addins.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectAddin(newValue);
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
    public void selectAddin(String addin){
        this.coffee.addAddin(addin);
        sub_total.setText(String.valueOf(this.coffee.price()));
    }
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

        sub_total.setText(String.valueOf(this.coffee.price()));
    }
    @FXML
    public void chooseQuantity(){
        String quantityStr = cmb_Qty.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(quantityStr);
        this.coffee.setQuantity(quantity);
        this.quantity = quantity;
        sub_total.setText(String.valueOf(this.coffee.price()));
    }


    @FXML
    public void addToOrder(){
        //String order = this.donutTypeEnum.getDonutType() + this.donutFlavorEnum.getDonutType() + String.valueOf(this.quantity);
        //subTotal.setText(order);
        //MenuItem donut = new Donut()
        //order.add
        this.order.add(coffee);
        //System.out.println(order.getMenuList()[0].price());
    }


}

package projfx.smproj4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.System.*;

public class HelloController {
    private Stage primaryStage;
    private Scene primaryScene;
    private Order order = new Order(1);
    private Order [] orders = new Order[10];
    //private int orderIndex = 0;
    private Order orderIndex = new Order(0);

    public void setOrder(Order order) {
        this.order = order;
    }

    public void printOrders(){
        System.out.println(this.orders[0].getOrderNumber());
    }

    public void setPrimaryStage(Stage stage, Scene scene) {
        primaryStage = stage;
        primaryScene = scene;
    }

    @FXML
    protected void displayDonutView() {
        Stage view1 = new Stage();
        primaryStage.setTitle("Order Donuts");
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("donut-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            primaryStage.setScene(scene);
            DonutViewController donutViewController = loader.getController();
            view1.setTitle("Donut");
            donutViewController.setMainController(this, view1, primaryStage, primaryScene);
            donutViewController.setOrder(order);
            view1.setTitle("Donut");
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void displayCoffeeView() {
        Stage view1 = new Stage();
        primaryStage.setTitle("Order Coffee");
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("coffee-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 550, 400);
            primaryStage.setScene(scene);
            CoffeeViewController coffeeViewController = loader.getController();
            coffeeViewController.setMainController(this, view1, primaryStage, primaryScene);

            primaryStage.sceneProperty().addListener((observable, primaryScene1, scene1) -> {
                if (coffeeViewController.getOrder() != null) {
                    if (coffeeViewController.checkIfCoffeeAdded())
                        order.add(coffeeViewController.getOrder());
                }
            });

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void displaySandwichView() {
        Stage view1 = new Stage();
        primaryStage.setTitle("Order Sandwiches");
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sandwich-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            SandwichViewController sandwichViewController = loader.getController();
            sandwichViewController.setMainController(this, view1, primaryStage, primaryScene);

            primaryStage.sceneProperty().addListener((observable, primaryScene1, scene1) -> {
                if (sandwichViewController.getOrder() != null) {
                    if (sandwichViewController.checkIfSandwichAdded())
                        order.add(sandwichViewController.getOrder());
                }
            });
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void displayAllOrdersView() {
        Stage view1 = new Stage();
        primaryStage.setTitle("All Orders");
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("all-orders-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            primaryStage.setScene(scene);
            AllOrdersViewController allOrdersViewController = loader.getController();
            printOrders();
            allOrdersViewController.setOrders(orders);
            allOrdersViewController.setOrderIndex(this.orderIndex);
            allOrdersViewController.setMainController(this, view1, primaryStage, primaryScene);

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void displayCurrentOrderView() {
        Stage view1 = new Stage();
        primaryStage.setTitle("Current Order");
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("current-order-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 550, 400);
            primaryStage.setScene(scene);
            CurrentOrderViewController currentOrderViewController = loader.getController();
            currentOrderViewController.setMainController(this, view1, primaryStage, primaryScene);
            currentOrderViewController.setOrder(order);
            //currentOrderViewController.setOrders(orders);
            primaryStage.sceneProperty().addListener((observable, primaryScene1, scene1) -> {
                if (currentOrderViewController.checkedIfOrderMade()) {
                    if(orderIndex.getOrderNumber() == this.orders.length){
                        Order [] ordersRep = new Order[this.orders.length + 3];
                        int i = 0;
                        for(Order order:orders){
                            ordersRep[i] = order;
                            i ++;
                        }
                        this.orders = ordersRep;
                    }
                    orders[orderIndex.getOrderNumber()] = order;
                    System.out.println(order);
                    int OI = orderIndex.getOrderNumber();
                    orderIndex.setOrderNumber(OI + 1);
                    order = new Order(orderIndex.getOrderNumber() + 1);
                }
            });

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }
}
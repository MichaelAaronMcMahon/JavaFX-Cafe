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

public class HelloController {
    private Stage primaryStage;
    private Scene primaryScene;

    public void setPrimaryStage(Stage stage, Scene scene) {
        primaryStage = stage;
        primaryScene = scene;
    }

    @FXML
    protected void displayDonutView() {
        Stage view1 = new Stage();
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("donut-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            primaryStage.setScene(scene);
            DonutViewController donutViewController = loader.getController();
            donutViewController.setMainController(this, view1, primaryStage, primaryScene);
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
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("coffee-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            primaryStage.setScene(scene);
            CoffeeViewController coffeeViewController = loader.getController();
            coffeeViewController.setMainController(this, view1, primaryStage, primaryScene);
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
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sandwich-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            primaryStage.setScene(scene);
            SandwichViewController sandwichViewController = loader.getController();
            sandwichViewController.setMainController(this, view1, primaryStage, primaryScene);
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
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("all-orders-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            primaryStage.setScene(scene);
            AllOrdersViewController allOrdersViewController = loader.getController();
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
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("current-order-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 500, 400);
            primaryStage.setScene(scene);
            CurrentOrderViewController currentOrderViewController = loader.getController();
            currentOrderViewController.setMainController(this, view1, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }
}
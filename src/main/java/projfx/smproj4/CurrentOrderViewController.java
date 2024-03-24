
package projfx.smproj4;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.lang.System.*;

public class CurrentOrderViewController {
    private HelloController helloController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private Order order;
    @FXML
    private ListView<MenuItem> lv_menuItems;
    private ObservableList<MenuItem> menuList;

    public void initialize() {
        //System.out.println(order.getMenuList()[0].price());

    }

    public void setOrder(Order order) {
        this.order = order;
        System.out.println(this.order.getMenuList()[0].price());
        menuList = FXCollections.observableArrayList(this.order.getMenuList());
        lv_menuItems.setItems(menuList);
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

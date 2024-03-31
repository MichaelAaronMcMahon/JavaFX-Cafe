
package projfx.smproj4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import java.io.*;

public class DonutViewController {
    private HelloController helloController;
    private Stage stage;
    private Scene primaryScene;
    private Stage primaryStage;
    private ObservableList<String> typeList;
    private ObservableList<String> flavorList;
    private ObservableList<String> yeastList;
    private ObservableList<String> cakeList;
    private ObservableList<String> holeList;
    private ObservableList<String> quantityList;
    @FXML
    private ComboBox<String> cmb_type;
    @FXML
    private ComboBox<String> cmb_quantity;
    @FXML
    private ListView<String> lv_flavor;
    private DonutType donutTypeEnum;
    private DonutFlavor donutFlavorEnum;
    private int quantity;
    private Donut donut;
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    @FXML
    private ImageView donutImage;
    public void initialize() {
        typeList = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Hole");
        yeastList = FXCollections.observableArrayList("Boston Cream", "Jelly-Filled", "Powdered", "Old-Fashioned", "Chocolate", "Blueberry");
        cakeList = FXCollections.observableArrayList("Pumpkin", "Strawberry", "Red Velvet");
        holeList = FXCollections.observableArrayList("Glazed", "Raspberry", "Sprinkled");
        quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        cmb_type.setItems(typeList);
        cmb_quantity.setItems(quantityList);
        this.donut = new Donut();
        this.quantity = 1;
        //donutImage = new ImageView();
        //File yeastFile = new File("src/main/resources/projfx/smproj4/yeast.jpg");
        //Image yeastImage = new Image(yeastFile.toURI().toString());
        //donutImage.setImage(new Image("src/main/resources/projfx/smproj4/yeast.jpg"));
        //donutImage.setImage(new Image("C:\Users\Admin\IdeaProjects\SMProj4\src\main\resources\projfx\smproj4\yeast.jpg");
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


    @FXML
    public void setFlavorList(){
        //String donutType = cmb_type.getTypeSelector();
        String donutType = cmb_type.getSelectionModel().getSelectedItem();
        File yeastFile = new File("src/main/resources/projfx/smproj4/yeast.jpg");
        File cakeFile = new File("src/main/resources/projfx/smproj4/cake.jpg");
        File holesFile = new File("src/main/resources/projfx/smproj4/holes.jpg");
        Image yeastImage = new Image(yeastFile.toURI().toString());
        Image cakeImage = new Image(cakeFile.toURI().toString());
        Image holesImage = new Image(holesFile.toURI().toString());

        if(donutType.equalsIgnoreCase("Yeast Donut")){
            donutImage.setImage(yeastImage);
            lv_flavor.setItems(yeastList);
            this.donutTypeEnum = DonutType.valueOf("YEASTDONUT");
            this.donut.setDonutType(DonutType.valueOf("YEASTDONUT"));
        }
        if(donutType.equalsIgnoreCase("Cake Donut")){
            donutImage.setImage(cakeImage);
            lv_flavor.setItems(cakeList);
            this.donutTypeEnum = DonutType.valueOf("CAKEDONUT");
            this.donut.setDonutType(DonutType.valueOf("CAKEDONUT"));
        }
        if(donutType.equalsIgnoreCase("Donut Hole")){
            donutImage.setImage(holesImage);
            lv_flavor.setItems(holeList);
            this.donutTypeEnum = DonutType.valueOf("DONUTHOLE");
            this.donut.setDonutType(DonutType.valueOf("DONUTHOLE"));
        }

        subTotal.setText(String.valueOf(this.donut.price()));
    }

    @FXML public void chooseFlavor(){
        String donutFlavor = lv_flavor.getSelectionModel().getSelectedItem();
        if(donutFlavor.equalsIgnoreCase("Boston Cream")){
            this.donutFlavorEnum = DonutFlavor.valueOf("BOSTONCREAM");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("BOSTONCREAM"));
        }
        if(donutFlavor.equalsIgnoreCase("Jelly-Filled")){
            this.donutFlavorEnum = DonutFlavor.valueOf("JELLYFILLED");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("JELLYFILLED"));
        }
        if(donutFlavor.equalsIgnoreCase("Powdered")){
            this.donutFlavorEnum = DonutFlavor.valueOf("POWDERED");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("POWDERED"));
        }
        if(donutFlavor.equalsIgnoreCase("Old-Fashioned")){
            this.donutFlavorEnum = DonutFlavor.valueOf("OLDFASHIONED");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("OLDFASHIONED"));
        }
        if(donutFlavor.equalsIgnoreCase("Chocolate")){
            this.donutFlavorEnum = DonutFlavor.valueOf("CHOCOLATE");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("CHOCOLATE"));
        }
        if(donutFlavor.equalsIgnoreCase("Blueberry")){
            this.donutFlavorEnum = DonutFlavor.valueOf("BLUEBERRY");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("BLUEBERRY"));
        }
        if(donutFlavor.equalsIgnoreCase("Pumpkin")){
            this.donutFlavorEnum = DonutFlavor.valueOf("PUMPKIN");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("PUMPKIN"));
        }
        if(donutFlavor.equalsIgnoreCase("Strawberry")){
            this.donutFlavorEnum = DonutFlavor.valueOf("STRAWBERRY");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("STRAWBERRY"));
        }
        if(donutFlavor.equalsIgnoreCase("Red Velvet")){
            this.donutFlavorEnum = DonutFlavor.valueOf("REDVELVET");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("REDVELVET"));
        }
        if(donutFlavor.equalsIgnoreCase("Glazed")){
            this.donutFlavorEnum = DonutFlavor.valueOf("GLAZED");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("GLAZED"));
        }
        if(donutFlavor.equalsIgnoreCase("Raspberry")){
            this.donutFlavorEnum = DonutFlavor.valueOf("RASPBERRY");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("RASPBERRY"));
        }
        if(donutFlavor.equalsIgnoreCase("Sprinkled")){
            this.donutFlavorEnum = DonutFlavor.valueOf("SPRINKLED");
            this.donut.setDonutFlavor(DonutFlavor.valueOf("SPRINKLED"));
        }
    }

    @FXML public void chooseQuantity(){
        String quantityStr = cmb_quantity.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(quantityStr);
        this.donut.setQuantity(quantity);
        this.donut.setDonutType(this.donutTypeEnum);
        this.quantity = quantity;
        subTotal.setText(String.valueOf(this.donut.price()));
    }

    @FXML
    private TextField subTotal;
    @FXML public void addToOrder(){
        //String order = this.donutTypeEnum.getDonutType() + this.donutFlavorEnum.getDonutType() + String.valueOf(this.quantity);
        //subTotal.setText(order);
        //MenuItem donut = new Donut()
        //order.add
        this.donut.setDonutType(this.donutTypeEnum);
        this.donut.setDonutFlavor(this.donutFlavorEnum);
        this.donut.setQuantity(this.quantity);
        this.order.add(donut);
        this.donut = new Donut();
        //System.out.println(order.getMenuList()[0].price());
    }


}

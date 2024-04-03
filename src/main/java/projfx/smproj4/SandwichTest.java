package projfx.smproj4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SandwichTest {
    @Test
    public void beefOneV(){
        Sandwich s1 = new Sandwich();
        s1.setBread("Bagel");
        s1.setOption("Beef");
        ObservableList<String> addonList = FXCollections.observableArrayList("Lettuce");
        s1.addAddon(addonList);
        s1.setQuantity(1);
        assertTrue(s1.price() == 11.29);

    }
    @Test
    public void chickenTwoVOneC(){
        Sandwich s1 = new Sandwich();
        s1.setBread("Wheat Bread");
        s1.setOption("Chicken");
        ObservableList<String> addonList = FXCollections.observableArrayList("Lettuce", "Onion", "Cheese");
        s1.addAddon(addonList);
        s1.setQuantity(1);
        assertTrue(s1.price() == 10.59);
    }
    @Test
    public void threeFishThreeV(){
        Sandwich s1 = new Sandwich();
        s1.setBread("Sour Dough");
        s1.setOption("Fish");
        ObservableList<String> addonList = FXCollections.observableArrayList("Lettuce", "Onion", "Tomato");
        s1.addAddon(addonList);
        s1.setQuantity(3);
        assertTrue(s1.price() == 32.67);
    }
    @Test
    public void beefOneC(){
        Sandwich s1 = new Sandwich();
        s1.setBread("Bagel");
        s1.setOption("Beef");
        ObservableList<String> addonList = FXCollections.observableArrayList("Cheese");
        s1.addAddon(addonList);
        s1.setQuantity(1);
        assertTrue(s1.price() == 11.99);
    }
    @Test
    public void chicken(){
        Sandwich s1 = new Sandwich();
        s1.setBread("Wheat Bread");
        s1.setOption("Chicken");
        s1.setQuantity(1);
        assertTrue(s1.price() == 8.99);
    }
}

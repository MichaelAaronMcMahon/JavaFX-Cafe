package projfx.smproj4;
//import java.lang.System.*;

import javafx.scene.control.Menu;

/**
 * An enum class for donut types 'Yeast Donut', 'Cake Donut', 'Donut Hole'.
 * Includes a method to return the donut type as a String.
 * @author Steven Rodriguez
 */
public enum DonutType {

    YEASTDONUT("Yeast Donut", 1.79),
    CAKEDONUT("Cake Donut", 1.89),
    DONUTHOLE("Donut Hole", 0.39);

    private final String donutType;
    private final double typePrice;

    /**
     * Constructor which creates a DonutType object from a string
     *
     * @param donutType
     * @param typePrice
     */
    DonutType(String donutType, double typePrice) {

        this.donutType = donutType;
        this.typePrice = typePrice;
    }
    /**
     * Return donut type as a String
     * @return String
     */
    public String getDonutType(){
        return donutType;
    }
    public double getTypePrice(){
        return typePrice;
    }

    public static void main (String[] args){
        /*DonutType dt = DonutType.valueOf("YEASTDONUT");
        System.out.println(dt.getDonutType());
        System.out.println(dt.getTypePrice());*/
        Donut donut = new Donut();
        donut.setDonutType(DonutType.valueOf("CAKEDONUT"));
        MenuItem menuItems[] = new MenuItem[3];
        menuItems[0] = donut;
        //menuItems[0].price();
        System.out.println(menuItems[0].price());
    }
}



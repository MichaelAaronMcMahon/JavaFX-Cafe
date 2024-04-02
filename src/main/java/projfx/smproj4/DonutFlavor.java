package projfx.smproj4;

import javafx.collections.FXCollections;
import java.util.*;
import java.io.*;
import java.lang.System.*;


/**
 * An enum class for donut flavors 'Boston Cream', 'Jelly Filled', 'Powdered',
 * 'Old Fashioned', 'Chocolate', 'Blueberry', 'Pumpkin', 'Strawberry', 'Red Velvet',
 * 'Glazed', 'Raspberry', 'Sprinkled'.
 * Includes a method to return the donut flavor as a String.
 * @author Michael McMahon
 */
public enum DonutFlavor {

    BOSTONCREAM("Boston Cream"),
    JELLYFILLED("Jelly-Filled"),
    POWDERED("Powdered"),
    OLDFASHIONED("Old-Fashioned"),
    CHOCOLATE("Chocolate"),
    BLUEBERRY("Blueberry"),
    PUMPKIN("Pumpkin"),
    STRAWBERRY("Strawberry"),
    REDVELVET("Red Velvet"),
    GLAZED("Glazed"),
    RASPBERRY("Raspberry"),
    SPRINKLED("Sprinkled");

    private final String donutFlavor;

    /**
     * Constructor which creates a DonutFlavor object from a string
     * @param donutFlavor
     */
    DonutFlavor(String donutFlavor) {
        this.donutFlavor = donutFlavor;
    }
    /**
     * Return donut flavor as a String
     * @return String
     */
    public String getDonutFlavor(){
        return donutFlavor;
    }
    public static void main(String[] args){
        DonutFlavor df = DonutFlavor.valueOf("BOSTONCREAM");
        System.out.println(df.donutFlavor);
    }

}

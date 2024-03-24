package projfx.smproj4;

import javafx.collections.FXCollections;
import java.util.*;
import java.io.*;
import java.lang.System.*;


/**
 * An enum class for donut types 'Yeast Donut', 'Cake Donut', 'Donut Hole'.
 * Includes a method to return the donut type as a String.
 * @author Steven Rodriguez
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
     * Constructor which creates a DonutType object from a string
     * @param donutFlavor
     */
    DonutFlavor(String donutFlavor) {
        this.donutFlavor = donutFlavor;
    }
    /**
     * Return donut type as a String
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

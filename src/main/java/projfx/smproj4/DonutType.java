package projfx.smproj4;

/**
 * An enum class for donut types 'Yeast Donut', 'Cake Donut', 'Donut Hole'.
 * Includes a method to return the donut type as a String.
 * @author Steven Rodriguez
 */
public enum DonutType {

    YEASTDONUT("Yeast Donut"),
    CAKEDONUT("Cake Donut"),
    DONUTHOLE("Donut Hole");

    private final String donutType;

    /**
     * Constructor which creates a DonutType object from a string
     * @param donutType
     */
    DonutType(String donutType) {
        this.donutType = donutType;
    }
    /**
     * Return donut type as a String
     * @return String
     */
    public String getDonutType(){
        return donutType;
    }
}

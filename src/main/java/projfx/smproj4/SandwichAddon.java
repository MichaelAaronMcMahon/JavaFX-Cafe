package projfx.smproj4;

public enum SandwichAddon {

    CHEESE("Cheese"),
    LETTUCE("Lettuce"),
    TOMATO("Tomato"),
    ONION("Onion");

    private final String swAddon;

    /**
     * Constructor which creates a SandwichAddon object from a string
     * @param swAddon
     */
    SandwichAddon(String swAddon) {
        this.swAddon = swAddon;
    }
    /**
     * Return sandwich addon as a String
     * @return String
     */
    public String getSwAddon(){
        return swAddon;
    }
}

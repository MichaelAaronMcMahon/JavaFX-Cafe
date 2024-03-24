package projfx.smproj4;

public enum SandwichOption {

    CHICKEN("Chicken"),
    FISH("Fish"),
    BEEF("Beef");

    private final String swOption;

    /**
     * Constructor which creates a SandwichOption object from a string
     * @param swOption
     */
    SandwichOption(String swOption) {
        this.swOption = swOption;
    }
    /**
     * Return sandwich option as a String
     * @return String
     */
    public String getSwOption(){
        return swOption;
    }
}

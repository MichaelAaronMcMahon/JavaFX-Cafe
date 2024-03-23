package projfx.smproj4;

public enum CoffeeAddin {

    SWEETCREAM("Sweet Cream"),
    FRENCHVANILLA("French Vanilla"),
    IRISHCREAM("Irish Cream"),
    CARAMEL("Caramel"),
    MOCHA("Mocha");

    private final String coffeeAddin;

    /**
     * Constructor which creates a CoffeeAddin object from a string
     * @param coffeeAddin
     */
    CoffeeAddin(String coffeeAddin) {
        this.coffeeAddin = coffeeAddin;
    }
    /**
     * Return coffee addin as a String
     * @return String
     */
    public String getCoffeeAddin(){
        return coffeeAddin;
    }
}

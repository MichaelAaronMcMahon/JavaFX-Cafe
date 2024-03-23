package projfx.smproj4;

public enum SandwichBread {

    BAGEL("Bagel"),
    WHEATBREAD("Wheat Bread"),
    SOURDOUGH("Sour Dough");

    private final String bread;

    /**
     * Constructor which creates a SandwichBread object from a string
     * @param bread
     */
    SandwichBread(String bread) {
        this.bread = bread;
    }
    /**
     * Return sandwich bread as a String
     * @return String
     */
    public String getBread(){
        return bread;
    }
}

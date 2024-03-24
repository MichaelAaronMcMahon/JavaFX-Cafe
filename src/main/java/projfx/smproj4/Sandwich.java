package projfx.smproj4;

public class Sandwich extends MenuItem{

    private SandwichOption option;
    private SandwichBread bread;
    private SandwichAddon [] addons;
    private int quantity;
    private int index;

    public Sandwich(SandwichOption option, SandwichBread bread, int quantity){
        super();
        this.option = option;
        this.bread = bread;
        this.addons = new SandwichAddon[4];
        this.quantity = quantity;
        this.index = 0;
    }
    public boolean addAddon(SandwichAddon addon){

        if (index == 4){//I will delete the print statement later, just have it for testing
            System.out.println("addon list is full");
            return false;
        }
        for (SandwichAddon sandwichAddon:addons){
            if (sandwichAddon == addon){
                return false;
            }
        }
        addons[index] = addon;
        index++;
        return true;
    }

    @Override
    public double price() {

        double addonMultiplier = 0;

        for (SandwichAddon sandwichAddon:addons){
            if (sandwichAddon.equals(SandwichAddon.valueOf("Cheese"))){
                addonMultiplier ++;
            }
            else{
                addonMultiplier += 0.3;
            }
        }
        return (8.99 + this.option.ordinal() + addonMultiplier) * quantity;
    }
}

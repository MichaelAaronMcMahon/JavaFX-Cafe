package projfx.smproj4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.lang.Math;

public class Sandwich extends MenuItem{

    private SandwichOption option;
    private SandwichBread bread;
    private SandwichAddon [] addons;
    private int quantity;
    private int index;
    private int ID;
    private boolean containsCheese;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public Sandwich(){
        super();
//        this.option = option;
//        this.bread = bread;
//        this.addons = new SandwichAddon[4];
//        this.quantity = quantity;
//        this.index = 0;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setBread(String bread){
        bread = bread.replaceAll("\\s+", "");
        this.bread = SandwichBread.valueOf(bread.toUpperCase());
    }
    public void setOption(String option){
        option = option.replaceAll("\\s+", "");
        this.option = SandwichOption.valueOf(option.toUpperCase());
    }
    public boolean addAddon(ObservableList<String> addon){

//        if (index == 4){//I will delete the print statement later, just have it for testing
//            System.out.println("addon list is full");
//            return false;
//        }
//        for (SandwichAddon sandwichAddon:addons){
//            if (sandwichAddon == addon){
//                return false;
//            }
//        }
//        addons[index] = addon;
//        index++;
//        return true;

        this.containsCheese = false;
        this.index = 0;
        this.addons = new SandwichAddon[4];

        for (String add:addon){
            if (add.equalsIgnoreCase("Cheese")){
                containsCheese = true;
            }
            //add = add.replaceAll("\\s+", "");
            this.addons[index] = SandwichAddon.valueOf(add.toUpperCase());
            index++;
        }

        return true;
    }

    @Override
    public double price() {

        double addonMultiplier = 0;

        if (this.containsCheese){
            addonMultiplier ++;
            addonMultiplier += (index - 1) * 0.3;
        }
        else{
            addonMultiplier += index * 0.3;
        }
        if (this.option != null) {
            System.out.println(this.option.ordinal() + " " + addonMultiplier);
            double unrounded = (8.99 + this.option.ordinal() + addonMultiplier) * quantity;
            return (double)Math.round(unrounded*100)/100;
        }
        else return 0;
    }
    @Override
    public String toString(){
        String rstring = "Sandwich Bread Type: " + this.bread.getBread() + ", Sandwich Protein Option: " + this.option.getSwOption() + ", Sandwich Addons: ";

        for(int i = 0; i < this.index; i++){
            rstring += this.addons[i].getSwAddon();
            rstring += ", ";
        }
        rstring += "Quantity: " + this.quantity + ", Id #" + this.getID();
        return rstring;
        //return "Sammich";
    }

    public static void main(String[] args){
        Sandwich s1 = new Sandwich();
        s1.setBread("Bagel");
        s1.setOption("Beef");
        ObservableList<String> addonList = FXCollections.observableArrayList("Lettuce");
        s1.addAddon(addonList);
        s1.setQuantity(1);
        System.out.println(s1.price());
        System.out.println((double)Math.round(s1.price()*100)/100);
    }
}
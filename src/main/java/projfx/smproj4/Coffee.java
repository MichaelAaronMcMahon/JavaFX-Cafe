package projfx.smproj4;

import javafx.collections.ObservableList;

public class Coffee extends MenuItem{

    private CoffeeAddin [] coffeeAddins;
    private CoffeeCupSize cupSize;
    private int quantity;
    private int index;
    private int ID;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public Coffee(){
        super();
        //this.coffeeAddins = new CoffeeAddin[5];
        //this.index = 0;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setCupSize(CoffeeCupSize cupSize){
        this.cupSize = cupSize;
    }

    public boolean addAddin(ObservableList<String> addin){

        this.index = 0;
        this.coffeeAddins = new CoffeeAddin[5];

        for (String add:addin){
            add = add.replaceAll("\\s+", "");
            coffeeAddins[index] = CoffeeAddin.valueOf(add.toUpperCase());
            index++;
        }

        return true;
    }

    @Override
    public String toString(){
        String rstring = "Coffee: " + this.cupSize.getCupSize() + ", ";
        for(int i = 0; i < this.index; i++){
            rstring += this.coffeeAddins[i].getCoffeeAddin();
            rstring += ", ";
        }
        rstring += this.quantity;
        return rstring;
    }
    @Override
    public double price() {

        double cupPriceMultiplier = this.cupSize.ordinal() * 0.50;
        double addinMultiplier = this.index * 0.30;

        double unrounded = (cupPriceMultiplier + addinMultiplier + 1.99) * quantity;
        return (double)Math.round(unrounded*100)/100;
    }
}
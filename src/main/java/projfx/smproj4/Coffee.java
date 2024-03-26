package projfx.smproj4;

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
        this.coffeeAddins = new CoffeeAddin[5];
        this.index = 0;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setCupSize(CoffeeCupSize cupSize){
        this.cupSize = cupSize;
    }

    public boolean addAddin(String addin){

        if (index == 5){//I will delete the print statement later, just have it for testing
            System.out.println("addin list is full");
            return false;
        }
        for (CoffeeAddin coffeeAddin:coffeeAddins){
            if (coffeeAddin == CoffeeAddin.valueOf(addin.toUpperCase())){
                return false;
            }
        }
        coffeeAddins[index] = CoffeeAddin.valueOf(addin.toUpperCase());
        index++;
        return true;
    }

    @Override
    public String toString(){
        String rstring =this.cupSize.getCupSize() + ", ";
        for(int i=0; i<this.coffeeAddins.length; i++){
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

        return (cupPriceMultiplier + addinMultiplier + 1.99) * quantity;
    }
}
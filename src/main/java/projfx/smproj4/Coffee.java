package projfx.smproj4;

public class Coffee extends MenuItem{

    private CoffeeAddin [] coffeeAddins;
    private CoffeeCupSize cupSize;
    private int quantity;
    private int index;

    public Coffee(CoffeeCupSize cupSize, int quantity){
        super();
        this.coffeeAddins = new CoffeeAddin[5];
        this.cupSize = cupSize;
        this.quantity = quantity;
        this.index = 0;
    }

    public boolean addAddin(CoffeeAddin addin){

        if (index == 5){//I will delete the print statement later, just have it for testing
            System.out.println("addin list is full");
            return false;
        }
        for (CoffeeAddin coffeeAddin:coffeeAddins){
            if (coffeeAddin == addin){
                return false;
            }
        }
        coffeeAddins[index] = addin;
        index++;
        return true;
    }
    @Override
    public double price() {

        double cupPriceMultiplier = this.cupSize.ordinal() * 0.50;
        double addinMultiplier = this.index * 0.30;

        return (cupPriceMultiplier + addinMultiplier + 1.99) * quantity;
    }
}

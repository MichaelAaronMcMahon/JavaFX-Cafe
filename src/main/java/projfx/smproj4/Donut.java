package projfx.smproj4;


public class Donut extends MenuItem{
    private DonutFlavor donutFlavor;
    private DonutType donutType;
    private int quantity = 1;
    private int ID;

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public double price() {
        double unrounded = this.quantity * this.donutType.getTypePrice();
        return (double)Math.round(unrounded*100)/100;
    }
    @Override
    public String toString(){
        String rstring = "Donut Type: " + this.donutType.getDonutType() + " | Donut Flavor: " + this.donutFlavor.getDonutFlavor() + " | Quantity: " + String.valueOf(this.quantity)+ " | Id #" + String.valueOf(this.ID);
        return rstring;
    }

    public DonutFlavor getDonutFlavor() {
        return donutFlavor;
    }

    public DonutType getDonutType() {
        return donutType;
    }

    public void setDonutFlavor(DonutFlavor donutFlavor) {
        this.donutFlavor = donutFlavor;
    }

    public void setDonutType(DonutType donutType) {
        this.donutType = donutType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

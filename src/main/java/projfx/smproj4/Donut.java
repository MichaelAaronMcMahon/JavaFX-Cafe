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
        return this.quantity * this.donutType.getTypePrice();
    }
    @Override
    public String toString(){
        String rstring = this.donutType.getDonutType() + ", " + this.donutFlavor.getDonutFlavor() + ", " + String.valueOf(this.quantity);
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

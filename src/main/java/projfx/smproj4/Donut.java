package projfx.smproj4;


public class Donut extends MenuItem{
    private DonutFlavor donutFlavor;
    private DonutType donutType;
    private int quantity = 1;
    @Override
    public double price() {
        return this.quantity * this.donutType.getTypePrice();
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

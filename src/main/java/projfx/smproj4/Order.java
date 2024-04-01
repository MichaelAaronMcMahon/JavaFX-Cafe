package projfx.smproj4;

public class Order {

    private int orderNumber;
    private MenuItem [] menuList;
    private int addIndex = 0;
    //an int which is assigned to each added menuitem, increasing with each addition
    //st each menu item has a unique ID
    private int menuItemId = 0;

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        this.menuList = new MenuItem[1];
    }

    public int getAddIndex() {
        return addIndex;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public MenuItem[] getMenuList() {
        return menuList;
    }

    public void add(MenuItem menuItem){
        /*if(this.addIndex == this.menuList.length){
            System.out.println("menulist grow");
            MenuItem menuGrow[] = new MenuItem[addIndex + 10];
            for (int i=0; i< menuList.length; i++){
                menuGrow[i] = this.menuList[i];
            }
            this.menuList = menuGrow;
        }*/
        if (this.addIndex == this.menuList.length){
            grow();
        }
        menuItem.setID(this.menuItemId);
        this.menuItemId ++;
        menuList[this.addIndex] = menuItem;
        this.addIndex ++;
        //printMenuList();
        //System.out.println("\n");

    }
    public void add(MenuItem[] menuItems){
        for (MenuItem menuItem:menuItems)
            add(menuItem);
    }

    public void remove(MenuItem menuItem){

        int removeID = menuItem.getID();

        for(int i = 0; i < this.addIndex; i++){

            if (this.menuList[i].getID() == removeID){
                this.menuList[i] = null;

                for(int j = (i + 1); j < this.addIndex; j ++){
                    this.menuList[j - 1] = this.menuList[j];
                    this.menuList[j] = null;
                }

                this.addIndex --;

            }

        }
    }
    /**
     * Creates a new array with a length 1 space longer and copies the original array to it.
     * It does this when the original array is full.
     */
    private void grow(){

        MenuItem [] replacement = new MenuItem[menuList.length + 1];

        int i = 0;
        for(MenuItem item:menuList){
            replacement[i] = item;
            i ++;
        }
        this.menuList = replacement;

    } //helper method to increase the capacity by 1
    public void printMenuList(){
        for (int i=0; i<this.addIndex; i++){
            System.out.println(this.menuList[i].toString());
        }
        System.out.println("end of order");
    }

}

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
        this.menuList = new MenuItem[10];
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
        if(this.addIndex == this.menuList.length){
            MenuItem menuGrow[] = new MenuItem[addIndex + 10];
            for (int i=0; i< menuList.length; i++){
                menuGrow[i] = this.menuList[i];
            }
            this.menuList = menuGrow;
        }
        //menuItem.setID(this.menuItemId);
        //this.menuItemId ++;
        menuList[this.addIndex] = menuItem;
        this.addIndex ++;
        printMenuList();
        System.out.println("\n");
    }

    public void printMenuList(){
        for (int i=0; i<this.addIndex; i++){
            System.out.println(this.menuList[i].toString());
        }
    }

}

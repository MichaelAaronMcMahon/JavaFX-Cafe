package projfx.smproj4;

public class Order {

    private int orderNumber;
    private MenuItem [] menuList;
    private int addIndex = 0;

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        this.menuList = new MenuItem[10];
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
        menuList[this.addIndex] = menuItem;
        this.addIndex ++;
    }

}

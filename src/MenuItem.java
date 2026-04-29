public class MenuItem {
    private int menuItemID;
    private String itemName;
    private double itemPrice;
    private String itemCategory;
    private int cookTime;
    private boolean isAvailable;


    public MenuItem(int menuItemID, String itemName, double itemPrice, String itemCategory, int cookTime, boolean isAvailable){
        this.menuItemID = menuItemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.cookTime = cookTime;
        this.isAvailable = isAvailable;

    }

    public void updatePrice(double newPrice){
        this.itemPrice = newPrice;
    }

    public void setAvailability(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public int getMenuItemID(){
        return menuItemID;
    }

    public String getItemName(){
        return itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public String getItemCategory(){
        return itemCategory;
    }

    public int getCookTime(){
        return cookTime;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public String toString(){
        return itemName + " $" + String.format("%.2f", itemPrice);
    }
}

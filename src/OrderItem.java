public class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    private String sideOne;
    private String sideTwo;
    private String addOn;
    private String comments;


    public OrderItem(MenuItem menuItem, int quantity){
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.sideOne = "";
        this.sideTwo = "";
        this.addOn = "";
        this.comments = "";
    }

    public OrderItem(MenuItem menuItem, int quantity, String sideOne, String sideTwo, String addOn, String comments){
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.addOn = addOn;
        this.comments = comments;
    }

    public double calculateSubtotal(){
        return menuItem.getItemPrice() * quantity;
    }

    public MenuItem getMenuItem(){
        return menuItem;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getSideOne(){
        return sideOne;
    }

    public String getSideTwo(){
        return sideTwo;
    }

    public String getAddOn(){
        return addOn;
    }

    public String getComments(){
        return comments;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setSideOne(String sideOne){
        this.sideOne = sideOne;
    }

    public void setSideTwo(String sideTwo){
        this.sideTwo = sideTwo;
    }

    public void setAddOn(String addOn){
        this.addOn = addOn;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public String toString(){
        return menuItem.getItemName() + " x" + quantity + " $" + String.format("%.2f", calculateSubtotal());
    }

}

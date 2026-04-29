public class Order {
    private int orderID;
    public static int nextID = 1;
    private String tableID;
    private int prepTime;
    private String orderStatus;
    private double orderTotal;

    public Order(String tableID, int prepTime, String orderStatus, double orderTotal){
        this.orderID = nextID;
        nextID++;
        this.tableID = tableID;
        this.prepTime = prepTime;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
    }

    public int getOrderID(){
        return orderID;
    }
    public String getTableID(){
        return tableID;
    }
    public void setTableID(String tableID){
        this.tableID = tableID;
    }

    public int getPrepTime(){
        return prepTime;
    }
    public void setPrepTime(int prepTime){
        this.prepTime = prepTime;
    }

    public String getOrderStatus(){
        return orderStatus;
    }
    public void setOrderStatus(String status){
        this.orderStatus = status;
    }

    public double getOrderTotal(){
        return orderTotal;
    }
    public void addToOrderTotal(double addAmount){
        this.orderTotal += addAmount;
    }
    public void subtractFromOrderTotal(double subtractAmount){
        this.orderTotal -= subtractAmount;
    }
}

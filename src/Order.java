import java.time.LocalDateTime;
import java.util.ArrayList;


public class Order {
    private int orderID;
    private int prepTime;
    private String orderStatus;
    private double orderTotal;
    private Table table;
    private ArrayList<OrderItem> orderItems;


    public Order(int orderID, Table table){
        this.orderID = orderID;
        this.table = table;
        this.prepTime = 0;
        this.orderStatus = "ACTIVE";
        this.orderTotal = 0.0;
        this.orderItems = new ArrayList<>();
    }

    public Order(int orderID, Table table, String orderStatus){
        this.orderID = orderID;
        this.table = table;
        this.prepTime = 0;
        this.orderStatus = orderStatus;
        this.orderTotal = 0.0;
        this.orderItems = new ArrayList<>();

    }

    public void addItem(MenuItem menuItem, int quantity){
        OrderItem newItem = new OrderItem(menuItem, quantity);
        orderItems.add(newItem);
        orderTotal = calculateTotal();
    }

    public void addItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderTotal = calculateTotal();
    }

    public void removeItem(MenuItem menuItem){
        for(int i = 0; i < orderItems.size(); i++) {
            if(orderItems.get(i).getMenuItem() == menuItem) {
                orderItems.remove(i);
                break;
            }
        }

        orderTotal = calculateTotal();
    }

    public void removeItem(int index){
        if (index >= 0 && index < orderItems.size()){
            orderItems.remove(index);
        }

        orderTotal = calculateTotal();
    }

    public void updateStatus(String status){
        this.orderStatus = status;
    }

    public double calculateTotal(){
        double total = 0.0;

        for(OrderItem item : orderItems){
            total += item.calculateSubtotal();
        }

        return total;
    }

    public int calculatePrepTime(){
        int prepTime = 0;

        for(OrderItem item: orderItems){
            int itemCookTime = item.getMenuItem().getCookTime();

            if(itemCookTime > prepTime){
                prepTime = itemCookTime;
            }
        }

        return prepTime;
    }

    public int getPrepTime(){
        return this.prepTime;
    }

    public  void setPrepTime(int prepTime){
        this.prepTime = prepTime;
    }

    public int getTotalItems(){
        int totalItems = 0;

        for(OrderItem item : orderItems){
            totalItems += item.getQuantity();
        }

        return totalItems;
    }

    public void clearOrder(){
        orderItems.clear();
        orderTotal = 0.0;
    }

    public int getOrderID(){
        return orderID;
    }


    public String getOrderStatus(){
        return orderStatus;
    }

    public void setOrderStatus(String status){
        this.orderStatus = status;
    }

    public double getOrderTotal(){
        orderTotal = calculateTotal();
        return orderTotal;
    }

    public Table getTable(){
        return table;
    }

    public String getTableID(){
        if(table != null){
            return table.getTableID();
        }

        return "";
    }


    public ArrayList<OrderItem> getOrderItems(){
        return orderItems;
    }
}


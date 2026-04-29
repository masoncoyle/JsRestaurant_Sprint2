import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class OrderData {
    public static ArrayList<MenuItem> menuItems = new ArrayList<>();
    public static ArrayList<Order> activeOrders = new ArrayList<>();
    public static Queue<Order> orderQueue = new LinkedList<>();


    public static void addMenuItems(){
        if(!menuItems.isEmpty()){
            return;
        }

        menuItems.add(new MenuItem(1, "Chips & Dip (Pick 2)", 8.00, "Appetizers", 5, true));
        menuItems.add(new MenuItem(2, "Buffalo Blue Chips", 6.00, "Appetizers", 7, true));
        menuItems.add(new MenuItem(3, "Chicken Nachos", 8.50, "Appetizers", 10, true));
        menuItems.add(new MenuItem(4, "Pork Nachos", 8.50, "Appetizers", 10, true));
        menuItems.add(new MenuItem(5, "Pork or Chicken Sliders", 5.00, "Appetizers", 8, true));
        menuItems.add(new MenuItem(6, "Catfish Bites", 6.50, "Appetizers", 10, true));
        menuItems.add(new MenuItem(7, "Fried Veggies", 6.50, "Appetizers", 8, true));
        menuItems.add(new MenuItem(8, "Fried Cheese", 7.50, "Appetizers", 8, true));
        menuItems.add(new MenuItem(9, "Cheesestick Trio", 14.00, "Appetizers", 10, true));
        menuItems.add(new MenuItem(10, "Chicken Quesadilla", 7.50, "Appetizers", 9, true));
        menuItems.add(new MenuItem(11, "Cast Iron Skillet Meatballs", 12.00, "Appetizers", 12, true));
        menuItems.add(new MenuItem(12, "Wings 6 Count", 8.25, "Appetizers", 14, true));
        menuItems.add(new MenuItem(13, "Wings 12 Count", 15.00, "Appetizers", 16, true));

        menuItems.add(new MenuItem(14, "House Salad Side", 5.00, "Salads", 5, true));
        menuItems.add(new MenuItem(15, "House Salad Main", 7.50, "Salads", 5, true));
        menuItems.add(new MenuItem(16, "Wedge Salad", 7.50, "Salads", 5, true));
        menuItems.add(new MenuItem(17, "Caesar Salad Side", 5.00, "Salads", 5, true));
        menuItems.add(new MenuItem(18, "Caesar Salad Main", 7.50, "Salads", 5, true));
        menuItems.add(new MenuItem(19, "Sweet Potato Chicken Salad", 11.50, "Salads", 8, true));


        menuItems.add(new MenuItem(28, "Shrimp & Grits", 13.50, "Entrees", 15, true));
        menuItems.add(new MenuItem(29, "Sweet Tea Fried Chicken", 11.50, "Entrees", 15, true));
        menuItems.add(new MenuItem(30, "Caribbean Chicken", 11.50, "Entrees", 15, true));
        menuItems.add(new MenuItem(31, "Grilled Pork Chops", 11.00, "Entrees", 15, true));
        menuItems.add(new MenuItem(32, "12 oz New York Strip Steak", 17.00, "Entrees", 20, true));
        menuItems.add(new MenuItem(33, "Seared Tuna", 15.00, "Entrees", 15, true));
        menuItems.add(new MenuItem(34, "Captain Crunch Chicken Tenders", 11.50, "Entrees", 12, true));
        menuItems.add(new MenuItem(35, "Shock Top Grouper Fingers", 11.50, "Entrees", 12, true));
        menuItems.add(new MenuItem(36, "Mac & Cheese Bar", 8.50, "Entrees", 10, true));

        menuItems.add(new MenuItem(37, "Curly Fries", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(38, "Wing Chips", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(39, "Sweet Potato Fries", 4.00, "Sides", 5, true));
        menuItems.add(new MenuItem(40, "Creamy Cabbage Slaw", 2.50, "Sides", 3, true));
        menuItems.add(new MenuItem(41, "Adluh Cheese Grits", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(42, "Mashed Potatoes", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(43, "Mac & Cheese", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(44, "Spicy Mac & Cheese", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(45, "Bacon Mac & Cheese", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(46, "Broccoli", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(47, "Seasonal Vegetables", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(48, "Baked Beans", 2.50, "Sides", 5, true));
        menuItems.add(new MenuItem(49, "Fried Okra", 4.00, "Sides", 5, true));
        menuItems.add(new MenuItem(50, "Sub Soup or Side Salad", 2.50, "Sides", 3, true));

        menuItems.add(new MenuItem(51, "Grilled Cheese", 5.50, "Sandwiches", 8, true));
        menuItems.add(new MenuItem(52, "100% Beef Hot Dog", 5.50, "Sandwiches", 8, true));
        menuItems.add(new MenuItem(53, "Chicken BLT&A", 10.00, "Sandwiches", 12, true));
        menuItems.add(new MenuItem(54, "Cordon Bleu", 11.00, "Sandwiches", 12, true));
        menuItems.add(new MenuItem(55, "Philly", 13.50, "Sandwiches", 14, true));
        menuItems.add(new MenuItem(56, "Pulled Pork", 9.50, "Sandwiches", 10, true));
        menuItems.add(new MenuItem(57, "Club", 10.00, "Sandwiches", 10, true));
        menuItems.add(new MenuItem(58, "Meatball Sub", 10.00, "Sandwiches", 12, true));
        menuItems.add(new MenuItem(59, "Po Boy", 11.50, "Sandwiches", 13, true));

        menuItems.add(new MenuItem(60, "Club Wrap", 10.00, "Wraps", 8, true));
        menuItems.add(new MenuItem(61, "Chicken BLT&A Wrap", 10.00, "Wraps", 8, true));
        menuItems.add(new MenuItem(62, "Veggie Wrap", 10.00, "Wraps", 7, true));
        menuItems.add(new MenuItem(63, "Chicken Caesar Wrap", 10.00, "Wraps", 8, true));

        menuItems.add(new MenuItem(64, "J's Burger", 10.00, "Burgers", 12, true));
        menuItems.add(new MenuItem(65, "Bacon Cheeseburger", 11.00, "Burgers", 13, true));
        menuItems.add(new MenuItem(66, "Mushroom Swiss Burger", 11.00, "Burgers", 13, true));
        menuItems.add(new MenuItem(67, "Carolina Burger", 11.00, "Burgers", 13, true));
        menuItems.add(new MenuItem(68, "Portobello Burger", 8.50, "Burgers", 10, true));
        menuItems.add(new MenuItem(69, "Vegan Boca Burger", 10.50, "Burgers", 10, true));

        menuItems.add(new MenuItem(70, "Coffee", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(71, "Sweet Tea", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(72, "Unsweet Tea", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(73, "Coke", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(74, "Diet Coke", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(75, "Sprite", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(76, "Mr. Pibb", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(77, "Ginger Ale", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(78, "Barq's Root Beer", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(79, "Bottled Water", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(80, "Lemonade", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(81, "Milk", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(82, "Chocolate Milk", 2.75, "Beverages", 1, true));
        menuItems.add(new MenuItem(83, "Orange Juice", 2.75, "Beverages", 1, true));
    }



    public static ArrayList<MenuItem> getItemsByCategory(String category){
        ArrayList<MenuItem> itemsInCategory = new ArrayList<>();

        for(MenuItem item : menuItems){
            if(item.getItemCategory().equals(category) && item.getIsAvailable()){
                itemsInCategory.add(item);
            }
        }

        return itemsInCategory;
    }

    public static void addActiveOrder(Order order){
        activeOrders.add(order);
    }

    public static void submitOrder(Order order){
        order.updateStatus("SUBMITTED");
        orderQueue.add(order);

        System.out.println("Order sent to queue.");
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Table: " + order.getTable().getTableID());
        System.out.println("Items: " +order.getTotalItems());
        System.out.println("Total: $" + String.format("%.2f", order.getOrderTotal()));
        System.out.println("Estimated Time:" + order.calculatePrepTime() + "minutes");

        displayOrderQueue();
    }

    public static Order getNextOrder(){
        return orderQueue.poll();
    }

    public static void displayOrderQueue(){
        System.out.println();
        System.out.println("Order Queue: ");

        if (orderQueue.isEmpty()){
            System.out.println("No orders in queue.");
        }

        for(Order order : orderQueue){
            System.out.println("Order #" + order.getOrderID()
                    + " | Table " + order.getTable().getTableID()
                    + " | Items: " + order.getTotalItems()
                    + " | Total: $" + String.format("%.2f", order.getOrderTotal())
                    + " | Estimated Time: " + order.calculatePrepTime() + " minutes");
        }

        System.out.println();
    }
}


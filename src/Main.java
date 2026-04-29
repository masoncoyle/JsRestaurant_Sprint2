import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeInitializer.addEmployees();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Temporary admin account (Username: admin, Password 1)
        Waiter admin = new Waiter(0,"admin","1", "admin", "1", "", 0);
        EmployeeInitializer.employees.add(admin);

        //Order testOrder = new Order("1A", 15, "ACTIVE", 32.00);
        //OrderData.orderQueue.add(testOrder);

        JFrame screen = new JFrame("Restaurant Manager");
        screen.setSize(1280, 800);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);
        screen.add(mainPanel);
        mainPanel.setBackground(ScreenColors.LIGHTBLUE);
        LoginPanel loginPanel = new LoginPanel(cardLayout, mainPanel);
        TableViewPanel tableViewPanel = new TableViewPanel(cardLayout, mainPanel);
        OrderPanel orderPanel = new OrderPanel(cardLayout, mainPanel);
        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(tableViewPanel, "TABLE_VIEW");
        mainPanel.add(orderPanel, "ORDER");
        cardLayout.show(mainPanel, "LOGIN");
        screen.setVisible(true);
        OrderData.addMenuItems();
    }
}
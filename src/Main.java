import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        //Employee log ins



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


    }
}
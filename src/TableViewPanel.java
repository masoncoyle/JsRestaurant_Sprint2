import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TableViewPanel extends JPanel {
    private TableGridPanel tableGridPanel;
    private JLabel usernameText = new JLabel();
    private RoundedRectangle dynamicDisplay = new RoundedRectangle(250,300,20);
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private OrderPanel orderPanel;

    TableViewPanel(CardLayout cardLayout, JPanel mainPanel, OrderPanel orderPanel){
        tableGridPanel = new TableGridPanel(this);
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.orderPanel = orderPanel;

        Employee currentUser = EmployeeInitializer.currentUser;

        setBackground(ScreenColors.LIGHTBLUE);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        RoundedRectangle sidebar = new RoundedRectangle(300, 600, 20);
        sidebar.setLayout(new BoxLayout(sidebar,BoxLayout.Y_AXIS));
        sidebar.setBackground(ScreenColors.MEDBLUE);
        sidebar.add(Box.createVerticalStrut(5));

        JPanel topBar = new JPanel();
        topBar.setMaximumSize(new Dimension(300, 40));
        topBar.setOpaque(false);
        topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));
        topBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Home Button
        JButton homeButton = new JButton("☰");
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homeButton.setFocusPainted(false);
        homeButton.setForeground(Color.WHITE);
        homeButton.setFont(new Font("Dialog", Font.PLAIN, 30));
        homeButton.setBackground(new Color(0,0,0,0));
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Return to default home screen state / deselect table
            }
        });
        topBar.add(homeButton);
        topBar.add(Box.createHorizontalStrut(30));

        //Dislays role and username
        usernameText = new JLabel();
        usernameText.setForeground(Color.WHITE);
        usernameText.setFont(new Font("Calibri", Font.PLAIN, 14));
        usernameText.setAlignmentX(Component.CENTER_ALIGNMENT);
        topBar.add(usernameText);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (EmployeeInitializer.currentUser != null){
                    updateUsernameText();
                }
                tableGridPanel.createTableGrid();
            }
        });

        sidebar.add(topBar);

        sidebar.add(Box.createVerticalStrut(40));

        dynamicDisplay.setBackground(Color.WHITE);
        dynamicDisplay.setMaximumSize(new Dimension(250,500));
        dynamicDisplay.setPreferredSize(new Dimension(250,500));
        dynamicDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        dynamicDisplay.setLayout(new BoxLayout(dynamicDisplay, BoxLayout.Y_AXIS));
        dynamicDisplay.setOpaque(false);
        sidebar.add(dynamicDisplay);
        dynamicDisplay.add(Box.createVerticalStrut(20));

        JLabel selectTableText = new JLabel("Select a Table");
        selectTableText.setForeground(ScreenColors.BLUETEXT);
        selectTableText.setFont(new Font("Calibri", Font.PLAIN, 24));
        selectTableText.setAlignmentX(Component.CENTER_ALIGNMENT);
        dynamicDisplay.add(selectTableText);


        sidebar.add(Box.createVerticalGlue());

        JPanel clockInClockOut = new JPanel();
        clockInClockOut.setMaximumSize(new Dimension(250, 40));
        clockInClockOut.setOpaque(false);
        clockInClockOut.setLayout(new BoxLayout(clockInClockOut, BoxLayout.X_AXIS));
        clockInClockOut.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Clock in --- Needs changed to button
        clockInClockOut.add(Box.createHorizontalGlue());
        RoundedRectangle clockInBox = new RoundedRectangle(120, 40, 10);
        clockInBox.setPreferredSize(new Dimension(120, 40));
        clockInBox.setMaximumSize(new Dimension(120,50));
        clockInBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        clockInBox.setBackground(ScreenColors.LIGHTBLUE);
        clockInBox.add(Box.createVerticalStrut(40));
        JLabel clockInText = new JLabel("Clock In");
        clockInText.setFont(new Font("Calibri", Font.PLAIN,20));
        clockInText.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        clockInBox.add(clockInText);

        clockInClockOut.add(clockInBox);

        clockInClockOut.add(Box.createHorizontalStrut(10));

        // Clock out --- Needs changed to button
        RoundedRectangle clockOutBox = new RoundedRectangle(120, 40, 10);
        clockOutBox.setPreferredSize(new Dimension(120, 40));
        clockOutBox.setMaximumSize(new Dimension(120, 40));
        clockOutBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        clockOutBox.setBackground(ScreenColors.LIGHTBLUE);
        clockOutBox.add(Box.createVerticalStrut(40));
        JLabel clockOutText = new JLabel("Clock Out");
        clockOutText.setFont(new Font("Calibri", Font.PLAIN,20));
        clockOutText.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
        clockOutBox.add(clockOutText);
        clockInClockOut.add(clockOutBox);
        clockInClockOut.add(Box.createHorizontalGlue());

        sidebar.add(clockInClockOut);
        sidebar.add(Box.createVerticalStrut(10));

        //Logout Button
        RoundedButton logOutButton = new RoundedButton("Log Out", 250, 40, 10);
        logOutButton.setPreferredSize(new Dimension(250,40));
        logOutButton.setMaximumSize(new Dimension(250,40));
        logOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logOutButton.setBackground(ScreenColors.LIGHTBLUE);
        logOutButton.setFont(new Font("Calibri", Font.PLAIN,20));
        logOutButton.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeInitializer.currentUser = null;

                cardLayout.show(mainPanel, "LOGIN");
            }
        });

        sidebar.add(logOutButton);
        sidebar.add(Box.createVerticalStrut(10));
        add(sidebar, BorderLayout.WEST);

        //add(tableGrid, BorderLayout.CENTER);
        add(tableGridPanel, BorderLayout.CENTER);

    }
    public void updateUsernameText(){
        usernameText.setText("Logged in as " + EmployeeInitializer.currentUser.getClass().getSimpleName() + " " + EmployeeInitializer.currentUser.firstName + " " + EmployeeInitializer.currentUser.lastName);
    }
    public void updateSideBar(Table table, Order order){
        dynamicDisplay.removeAll();

        JLabel tableIdLabel = new JLabel("Table " + table.getTableID());
        tableIdLabel.setForeground(ScreenColors.BLUETEXT);
        tableIdLabel.setFont(new Font("Calibri", Font.PLAIN, 32));
        tableIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dynamicDisplay.add(Box.createVerticalStrut(20));
        dynamicDisplay.add(tableIdLabel);

        if (order == null){
            RoundedButton takeOrderButton = new RoundedButton("Take Order",200,40,10);
            takeOrderButton.setBackground(ScreenColors.MEDBLUE);
            takeOrderButton.setForeground(Color.WHITE);
            takeOrderButton.setFont(new Font("Calibri", Font.PLAIN,20));
            takeOrderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            takeOrderButton.setMaximumSize(new Dimension(200,40));
            takeOrderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    orderPanel.setCurrentTableAndOrder(table, order);
                    cardLayout.show(mainPanel, "ORDER");
                }
            });

            dynamicDisplay.add(Box.createVerticalStrut(10));
            dynamicDisplay.add(takeOrderButton);

            RoundedButton markTableDirtyButton = new RoundedButton("Mark Table as Dirty",200,40,10);
            markTableDirtyButton.setBackground(ScreenColors.MEDBLUE);
            markTableDirtyButton.setForeground(Color.WHITE);
            markTableDirtyButton.setFont(new Font("Calibri", Font.PLAIN,20));
            markTableDirtyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            markTableDirtyButton.setMaximumSize(new Dimension(200,40));
            markTableDirtyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    table.markDirty();
                    tableGridPanel.createTableGrid();
                    resetDynamicDisplay();
                }
            });

            dynamicDisplay.add(Box.createVerticalStrut(320));
            dynamicDisplay.add(markTableDirtyButton);
        } else if (order.getOrderStatus().equals("ACTIVE")) {
            JLabel prepTimeLabel = new JLabel("Prep Time\n" + order.getPrepTime());
            prepTimeLabel.setForeground(ScreenColors.BLUETEXT);
            prepTimeLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
            prepTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            dynamicDisplay.add(Box.createVerticalStrut(20));
            dynamicDisplay.add(prepTimeLabel);

            RoundedButton markDeliveredButton = new RoundedButton("Order Delivered",200,40,10);
            markDeliveredButton.setBackground(ScreenColors.MEDBLUE);
            markDeliveredButton.setForeground(Color.WHITE);
            markDeliveredButton.setFont(new Font("Calibri", Font.PLAIN,20));
            markDeliveredButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            markDeliveredButton.setMaximumSize(new Dimension(200,40));
            markDeliveredButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    order.setOrderStatus("COMPLETE");
                }
            });

        } else if (order.getOrderStatus().equals("COMPLETE")){
            RoundedButton takeOrderButton = new RoundedButton("Take Order",200,40,10);
            takeOrderButton.setBackground(ScreenColors.MEDBLUE);
            takeOrderButton.setForeground(Color.WHITE);
            takeOrderButton.setFont(new Font("Calibri", Font.PLAIN,20));
            takeOrderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            takeOrderButton.setMaximumSize(new Dimension(200,40));
            takeOrderButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    orderPanel.setCurrentTableAndOrder(table, order);
                    cardLayout.show(mainPanel, "ORDER");
                }
            });

            RoundedButton takePaymentButton = new RoundedButton("Take Payment",200,40,10);
            takePaymentButton.setBackground(ScreenColors.MEDBLUE);
            takePaymentButton.setForeground(Color.WHITE);
            takePaymentButton.setFont(new Font("Calibri", Font.PLAIN,20));
            takePaymentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            takePaymentButton.setMaximumSize(new Dimension(200,40));
            takePaymentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });



        }
        dynamicDisplay.revalidate();
        dynamicDisplay.repaint();
    }
    public void resetDynamicDisplay(){
        dynamicDisplay.removeAll();
        JLabel selectTableText = new JLabel("Select a Table");
        selectTableText.setForeground(ScreenColors.BLUETEXT);
        selectTableText.setFont(new Font("Calibri", Font.PLAIN, 24));
        selectTableText.setAlignmentX(Component.CENTER_ALIGNMENT);
        dynamicDisplay.add(Box.createVerticalStrut(20));
        dynamicDisplay.add(selectTableText);
        dynamicDisplay.revalidate();
        dynamicDisplay.repaint();
    }
}

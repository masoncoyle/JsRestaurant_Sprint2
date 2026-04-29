import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrderPanel extends JPanel {
  private CardLayout cardLayout;
  private JPanel mainPanel;

  private Order currentOrder;
  private Table currentTable;

  private JLabel tableLabel;
  private JLabel categoryLabel;
  private JPanel itemButtonPanel;
  private JPanel orderListPanel;
  private JLabel totalItemsLabel;
  private JLabel subtotalLabel;
  private JLabel estimatedTimeLabel;

  private int nextOrderID = 1;

  private static final String FONT = "Calibri";

  public OrderPanel(CardLayout cardLayout, JPanel mainPanel){
      this.cardLayout = cardLayout;
      this.mainPanel = mainPanel;

      setLayout(null);
      setBackground(ScreenColors.LIGHTBLUE);

      buildScreen();
      updateOrderDisplay();
  }

  public void setCurrentTableAndOrder(Table table, Order order){
      this.currentTable = table;

      if(order == null){
          this.currentOrder = new Order(nextOrderID, table);
          OrderData.addActiveOrder(this.currentOrder);
          nextOrderID++;
      }else{
          this.currentOrder = order;
      }

      tableLabel.setText("Table " + currentTable.getTableID());
      updateOrderDisplay();
  }

  private void buildScreen(){
      RoundedRectangle background = new RoundedRectangle(1210, 710, 30);
      background.setBounds(30, 25, 1210, 710);
      background.setBackground(ScreenColors.MEDBLUE);
      background.setLayout(null);
      add(background);

      JLabel menuButton = new JLabel("=");
      menuButton.setForeground(Color.WHITE);
      menuButton.setFont(new Font(FONT, Font.PLAIN, 24));
      menuButton.setBounds(20, 15, 50, 40);
      background.add(menuButton);

      tableLabel = new JLabel("Table", SwingConstants.LEFT);
      tableLabel.setForeground(Color.WHITE);
      tableLabel.setBounds(100, 20, 150, 30);
      tableLabel.setFont(new Font(FONT, Font.BOLD, 14));
      tableLabel.setBounds(100, 20, 150, 30);
      background.add(tableLabel);

      JLabel title = new JLabel("Order Food", SwingConstants.CENTER);
      title.setForeground(Color.WHITE);
      title.setFont(new Font(FONT, Font.BOLD, 44));
      title.setBounds(380, 25, 400, 60);
      background.add(title);

      categoryLabel = new JLabel("", SwingConstants.CENTER);
      categoryLabel.setForeground(Color.WHITE);
      categoryLabel.setFont(new Font(FONT, Font.BOLD, 16));
      categoryLabel.setBounds(480, 105, 200, 30);
      background.add(categoryLabel);

      JTextField searchBar = new JTextField("   Search");
      searchBar.setBounds(30, 90, 150, 35);
      searchBar.setFont(new Font(FONT, Font.PLAIN, 14));
      searchBar.setBackground(ScreenColors.LIGHTBLUE);
      searchBar.setForeground(Color.GRAY);
      searchBar.setBorder(BorderFactory.createLineBorder(ScreenColors.BLUETEXT));
      background.add(searchBar);

      RoundedRectangle menuPanel = new RoundedRectangle(150, 520, 10);
      menuPanel.setLayout(null);
      menuPanel.setBackground(ScreenColors.LIGHTBLUE);
      menuPanel.setBounds(30, 150, 150, 520);
      background.add(menuPanel);

      JLabel menuTitle = new JLabel("Menu", SwingConstants.CENTER);
      menuTitle.setFont(new Font(FONT, Font.BOLD, 18));
      menuTitle.setForeground(ScreenColors.BLUETEXT);
      menuTitle.setBounds(0, 15, 150, 30);
      menuPanel.add(menuTitle);

      addCategoryButton(menuPanel, "Appetizers", 60);
      addCategoryButton(menuPanel, "Salads", 105);
      addCategoryButton(menuPanel, "Entrees", 150);
      addCategoryButton(menuPanel, "Sides", 195);
      addCategoryButton(menuPanel, "Sandwiches", 240);
      addCategoryButton(menuPanel, "Wraps", 285);
      addCategoryButton(menuPanel, "Burgers", 330);
      addCategoryButton(menuPanel, "Beverages", 375);

      itemButtonPanel = new JPanel();
      itemButtonPanel.setLayout(null);
      itemButtonPanel.setOpaque(false);
      itemButtonPanel.setBounds(220, 145, 670, 430);
      background.add(itemButtonPanel);

      RoundedButton editButton = new RoundedButton("Edit order items", 130, 30, 8);
      editButton.setBounds(820, 585, 130, 30);
      editButton.setFont(new Font(FONT, Font.PLAIN, 12));
      editButton.setBackground(ScreenColors.LIGHTBLUE);
      editButton.setForeground(ScreenColors.BLUETEXT);
      editButton.addActionListener(e -> showEditOrderWindow());
      background.add(editButton);

      RoundedButton cancelButton = new RoundedButton("Cancel all items", 130, 30, 8);
      cancelButton.setBounds(820, 630, 130, 30);
      cancelButton.setFont(new Font(FONT, Font.PLAIN, 12));
      cancelButton.setForeground(Color.RED);
      cancelButton.setBackground(ScreenColors.LIGHTBLUE);
      cancelButton.addActionListener(e -> {
          if (currentOrder != null) {
              currentOrder.clearOrder();
              updateOrderDisplay();
          }
      });
      background.add(cancelButton);

      RoundedRectangle rightPanel = new RoundedRectangle(210, 630, 10);
      rightPanel.setLayout(null);
      rightPanel.setBackground(ScreenColors.LIGHTBLUE);
      rightPanel.setBounds(970, 20, 210, 630);
      background.add(rightPanel);

      JLabel orderTitle = new JLabel("Items in order:", SwingConstants.CENTER);
      orderTitle.setFont(new Font(FONT, Font.BOLD, 18));
      orderTitle.setForeground(ScreenColors.BLUETEXT);
      orderTitle.setBounds(10, 20, 190, 30);
      rightPanel.add(orderTitle);

      orderListPanel = new JPanel();
      orderListPanel.setLayout(new BoxLayout(orderListPanel, BoxLayout.Y_AXIS));
      orderListPanel.setBackground(ScreenColors.LIGHTBLUE);

      JScrollPane scrollPane = new JScrollPane(orderListPanel);
      scrollPane.setBounds(15, 70, 180, 355);
      scrollPane.setBorder(null);
      scrollPane.getViewport().setBackground(ScreenColors.LIGHTBLUE);
      rightPanel.add(scrollPane);

      totalItemsLabel = new JLabel("Total items: 0");
      totalItemsLabel.setFont(new Font(FONT, Font.PLAIN, 14));
      totalItemsLabel.setForeground(ScreenColors.BLUETEXT);
      totalItemsLabel.setBounds(25, 455, 160, 25);
      rightPanel.add(totalItemsLabel);

      subtotalLabel = new JLabel("Subtotal: $0.00");
      subtotalLabel.setFont(new Font(FONT, Font.PLAIN, 14));
      subtotalLabel.setForeground(ScreenColors.BLUETEXT);
      subtotalLabel.setBounds(25, 485, 160, 25);
      rightPanel.add(subtotalLabel);

//      estimatedTimeLabel = new JLabel("Estimated time: 0 min");
//      estimatedTimeLabel.setFont(new Font(FONT, Font.PLAIN, 14));
//      estimatedTimeLabel.setForeground(ScreenColors.BLUETEXT);
//      estimatedTimeLabel.setBounds(25, 515, 170, 25);
//      rightPanel.add(estimatedTimeLabel);

      RoundedButton submitButton = new RoundedButton("Submit Order", 160, 40, 10);
      submitButton.setBounds(25, 555, 160, 40);
      submitButton.setBackground(ScreenColors.GREEN);
      submitButton.setForeground(ScreenColors.BLUETEXT);
      submitButton.setFont(new Font(FONT, Font.BOLD, 16));
      submitButton.addActionListener(e -> submitOrder());
      rightPanel.add(submitButton);

  }

    private void addCategoryButton(JPanel menuPanel, String category, int y) {
        RoundedButton button = new RoundedButton(category, 120, 28, 5);
        button.setBounds(15, y, 120, 28);
        button.setFont(new Font(FONT, Font.PLAIN, 12));
        button.setBackground(ScreenColors.LIGHTBLUE);
        button.setForeground(ScreenColors.BLUETEXT);
        button.addActionListener(e -> showCategory(category));
        menuPanel.add(button);
    }

    private void showCategory(String category) {
        categoryLabel.setText(category + ":");
        itemButtonPanel.removeAll();

        ArrayList<MenuItem> items = OrderData.getItemsByCategory(category);

        int x = 30;
        int y = 40;
        int count = 0;

        for (MenuItem item : items) {
            RoundedButton itemButton = new RoundedButton("", 160, 65, 12);

            itemButton.setText("<html><center>" + item.getItemName()
                    + "<br>$" + String.format("%.2f", item.getItemPrice())
                    + "</center></html>");

            itemButton.setBounds(x, y, 160, 65);
            itemButton.setFont(new Font(FONT, Font.PLAIN, 15));
            itemButton.setBackground(ScreenColors.LIGHTBLUE);
            itemButton.setForeground(ScreenColors.BLUETEXT);
            itemButton.addActionListener(e -> showAddItemWindow(item));

            itemButtonPanel.add(itemButton);

            count++;
            x += 215;

            if (count % 3 == 0) {
                x = 30;
                y += 110;
            }
        }

        itemButtonPanel.revalidate();
        itemButtonPanel.repaint();
    }

    private void showAddItemWindow(MenuItem menuItem) {
        if (currentTable == null || currentOrder == null) {
            JOptionPane.showMessageDialog(this, "Please select a table first.");
            return;
        }

        JDialog dialog = new JDialog((Frame) null, "Add Item", true);
        dialog.setSize(390, 350);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setBackground(Color.WHITE);

        JLabel itemLabel = new JLabel("Item selected: " + menuItem.getItemName(), SwingConstants.CENTER);
        itemLabel.setFont(new Font(FONT, Font.BOLD, 16));
        itemLabel.setForeground(ScreenColors.BLUETEXT);
        itemLabel.setBounds(20, 20, 340, 30);
        dialog.add(itemLabel);

        JLabel sideOneLabel = new JLabel("Side 1:");
        sideOneLabel.setFont(new Font(FONT, Font.PLAIN, 14));
        sideOneLabel.setBounds(50, 70, 100, 25);
        dialog.add(sideOneLabel);

        JComboBox<String> sideOneBox = new JComboBox<>(new String[]{
                "", "Sweet Potato Fries", "Broccoli", "French Fries", "Mac & Cheese"
        });
        sideOneBox.setFont(new Font(FONT, Font.PLAIN, 14));
        sideOneBox.setBounds(160, 70, 160, 28);
        dialog.add(sideOneBox);

        JLabel sideTwoLabel = new JLabel("Side 2:");
        sideTwoLabel.setFont(new Font(FONT, Font.PLAIN, 14));
        sideTwoLabel.setBounds(50, 110, 100, 25);
        dialog.add(sideTwoLabel);

        JComboBox<String> sideTwoBox = new JComboBox<>(new String[]{
                "", "Sweet Potato Fries", "Broccoli", "French Fries", "Mac & Cheese"
        });
        sideTwoBox.setFont(new Font(FONT, Font.PLAIN, 14));
        sideTwoBox.setBounds(160, 110, 160, 28);
        dialog.add(sideTwoBox);

        JLabel addOnLabel = new JLabel("Add On:");
        addOnLabel.setFont(new Font(FONT, Font.PLAIN, 14));
        addOnLabel.setBounds(50, 150, 100, 25);
        dialog.add(addOnLabel);

        JComboBox<String> addOnBox = new JComboBox<>(new String[]{
                "", "Extra Sauce", "Extra Cheese", "No Onion", "No Tomato"
        });
        addOnBox.setFont(new Font(FONT, Font.PLAIN, 14));
        addOnBox.setBounds(160, 150, 160, 28);
        dialog.add(addOnBox);

        JLabel commentLabel = new JLabel("Comments:");
        commentLabel.setFont(new Font(FONT, Font.PLAIN, 14));
        commentLabel.setBounds(50, 190, 100, 25);
        dialog.add(commentLabel);

        JTextField commentField = new JTextField();
        commentField.setFont(new Font(FONT, Font.PLAIN, 14));
        commentField.setBounds(160, 190, 160, 28);
        dialog.add(commentField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(new Font(FONT, Font.PLAIN, 14));
        quantityLabel.setBounds(50, 230, 100, 25);
        dialog.add(quantityLabel);

        JTextField quantityField = new JTextField("1");
        quantityField.setFont(new Font(FONT, Font.PLAIN, 14));
        quantityField.setBounds(160, 230, 60, 28);
        dialog.add(quantityField);

        RoundedButton addButton = new RoundedButton("Add Item", 130, 35, 10);
        addButton.setBounds(125, 280, 130, 35);
        addButton.setFont(new Font(FONT, Font.BOLD, 14));
        addButton.setBackground(ScreenColors.GREEN);
        addButton.setForeground(ScreenColors.BLUETEXT);

        addButton.addActionListener(e -> {
            int quantity = 1;

            try {
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException ex) {
                quantity = 1;
            }

            if (quantity < 1) {
                quantity = 1;
            }

            OrderItem orderItem = new OrderItem(menuItem, quantity);
            orderItem.setSideOne((String) sideOneBox.getSelectedItem());
            orderItem.setSideTwo((String) sideTwoBox.getSelectedItem());
            orderItem.setAddOn((String) addOnBox.getSelectedItem());
            orderItem.setComments(commentField.getText());

            currentOrder.addItem(orderItem);
            currentTable.markOccupied();
            updateOrderDisplay();

            dialog.dispose();
        });

        dialog.add(addButton);
        dialog.setVisible(true);
    }

    private void updateOrderDisplay() {
        orderListPanel.removeAll();

        if (currentOrder == null) {
            totalItemsLabel.setText("Total items: 0");
            subtotalLabel.setText("Subtotal: $0.00");
            //estimatedTimeLabel.setText("Estimated time: 0 min");
            orderListPanel.revalidate();
            orderListPanel.repaint();
            return;
        }

        for (OrderItem item : currentOrder.getOrderItems()) {
            JLabel itemLabel = new JLabel(item.getMenuItem().getItemName()
                    + " x" + item.getQuantity()
                    + "   $" + String.format("%.2f", item.calculateSubtotal()));

            itemLabel.setFont(new Font(FONT, Font.BOLD, 13));
            itemLabel.setForeground(ScreenColors.BLUETEXT);
            itemLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            orderListPanel.add(itemLabel);

            if (!item.getSideOne().equals("")) {
                JLabel sideOne = new JLabel("   " + item.getSideOne());
                sideOne.setFont(new Font(FONT, Font.PLAIN, 12));
                sideOne.setForeground(ScreenColors.BLUETEXT);
                sideOne.setAlignmentX(Component.LEFT_ALIGNMENT);
                orderListPanel.add(sideOne);
            }

            if (!item.getSideTwo().equals("")) {
                JLabel sideTwo = new JLabel("   " + item.getSideTwo());
                sideTwo.setFont(new Font(FONT, Font.PLAIN, 12));
                sideTwo.setForeground(ScreenColors.BLUETEXT);
                sideTwo.setAlignmentX(Component.LEFT_ALIGNMENT);
                orderListPanel.add(sideTwo);
            }

            if (!item.getAddOn().equals("")) {
                JLabel addOn = new JLabel("   " + item.getAddOn());
                addOn.setFont(new Font(FONT, Font.PLAIN, 12));
                addOn.setForeground(ScreenColors.BLUETEXT);
                addOn.setAlignmentX(Component.LEFT_ALIGNMENT);
                orderListPanel.add(addOn);
            }

            if (!item.getComments().equals("")) {
                JLabel comment = new JLabel("   Note: " + item.getComments());
                comment.setFont(new Font(FONT, Font.ITALIC, 12));
                comment.setForeground(ScreenColors.BLUETEXT);
                comment.setAlignmentX(Component.LEFT_ALIGNMENT);
                orderListPanel.add(comment);
            }

            orderListPanel.add(Box.createVerticalStrut(10));
        }

        totalItemsLabel.setText("Total items: " + currentOrder.getTotalItems());
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", currentOrder.getOrderTotal()));
        //estimatedTimeLabel.setText("Estimated time: " + currentOrder.calculatePrepTime() + " min");

        orderListPanel.revalidate();
        orderListPanel.repaint();
    }

    private void showEditOrderWindow() {
        if (currentOrder == null) {
            JOptionPane.showMessageDialog(this, "Please select a table first.");
            return;
        }

        JDialog dialog = new JDialog((Frame) null, "Edit Order Items", true);
        dialog.setSize(420, 400);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("Edit Order Items", SwingConstants.CENTER);
        title.setBounds(90, 20, 220, 30);
        title.setFont(new Font(FONT, Font.BOLD, 18));
        title.setForeground(ScreenColors.BLUETEXT);
        dialog.add(title);

        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (OrderItem item : currentOrder.getOrderItems()) {
            listModel.addElement(item.toString());
        }

        JList<String> itemList = new JList<>(listModel);
        itemList.setFont(new Font(FONT, Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setBounds(50, 70, 310, 180);
        dialog.add(scrollPane);

        RoundedButton removeButton = new RoundedButton("Remove Selected", 140, 35, 10);
        removeButton.setBounds(55, 280, 140, 35);
        removeButton.setFont(new Font(FONT, Font.PLAIN, 13));
        removeButton.setBackground(ScreenColors.LIGHTBLUE);
        removeButton.setForeground(Color.RED);

        removeButton.addActionListener(e -> {
            int index = itemList.getSelectedIndex();

            if (index >= 0) {
                currentOrder.removeItem(index);
                listModel.remove(index);
                updateOrderDisplay();
            }
        });

        dialog.add(removeButton);

        RoundedButton confirmButton = new RoundedButton("Confirm", 120, 35, 10);
        confirmButton.setBounds(220, 280, 120, 35);
        confirmButton.setFont(new Font(FONT, Font.BOLD, 14));
        confirmButton.setBackground(ScreenColors.GREEN);
        confirmButton.setForeground(ScreenColors.BLUETEXT);
        confirmButton.addActionListener(e -> dialog.dispose());
        dialog.add(confirmButton);

        dialog.setVisible(true);
    }

    private void submitOrder() {
        if (currentOrder == null || currentTable == null) {
            JOptionPane.showMessageDialog(this, "Please select a table first.");
            return;
        }

        if (currentOrder.getOrderItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no items to submit.");
            return;
        }


        OrderData.submitOrder(currentOrder);

        JOptionPane.showMessageDialog(this,
                "Order submitted to kitchen queue.\nCheck the console to see the queue.");

        updateOrderDisplay();
    }

  }



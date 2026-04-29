import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableGridPanel extends JPanel {
    private TableViewPanel tableViewPanel;
    TableGridPanel(TableViewPanel tableViewPanel){
        this.tableViewPanel = tableViewPanel;
        setLayout(new GridBagLayout());
        setBackground(ScreenColors.LIGHTBLUE);
    }
    public void createTableGrid(){
        removeAll();

        GridBagConstraints tableGbc = new GridBagConstraints();

        tableGbc.insets = new Insets(20,20,20,20);
        String[] columns = {"A", "B", "C", "D", "E", "F"};
        for (int row = 0; row < 6; row++){
            for (int column = 0; column < 6; column++) {
                if ((column == 2 || column == 3) && row <= 3) {
                    continue;
                }
                String tableID = (row + 1) + columns[column];
                RoundedButton tableButton = new RoundedButton(tableID, 100, 80, 10);

                for (Table table : TableData.tables){
                    if (table.getTableID().equals(tableID)){
                        tableButton.putClientProperty("table", table);
                    }
                }

                tableButton.setFont(new Font("Calibri", Font.PLAIN, 26));
                tableGbc.gridx = column;
                tableGbc.gridy = row;

                //Table Button status color and enabling or disabling
                Table connectedTable = (Table) tableButton.getClientProperty("table");
                if (connectedTable != null){
                    if (EmployeeInitializer.currentUser instanceof Waiter) {
                        boolean adminLogin = EmployeeInitializer.currentUser.username.equals("admin");
                        if (adminLogin || ((Waiter) EmployeeInitializer.currentUser).section == connectedTable.getSection()){
                            switch (connectedTable.getTableStatus()){
                                case "CLEAN":
                                    tableButton.setEnabled(false);
                                    tableButton.setBackground(ScreenColors.GREEN);
                                    break;
                                case "OCCUPIED":
                                    tableButton.setBackground(ScreenColors.YELLOW);
                                    break;
                                case "DIRTY":
                                    tableButton.setEnabled(false);
                                    tableButton.setBackground(ScreenColors.RED);
                                    break;
                                case "BAR":
                                    tableButton.setBackground(ScreenColors.LIGHTORANGE);
                                    break;
                            }
                        } else {
                            tableButton.setEnabled(false);
                            tableButton.setBackground(Color.WHITE);
                        }
                    }

                }
                tableButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Table connectedTable = (Table) tableButton.getClientProperty("table");
                        Order currentOrder = null;
                        for (Order order : OrderData.orderQueue){
                            if (order.getTableID().equals(connectedTable.getTableID())){
                                currentOrder = order;
                                break;
                            }
                        }
                        tableViewPanel.updateSideBar(connectedTable, currentOrder);
                    }
                });
                add(tableButton, tableGbc);
            }
        }

        GridBagConstraints barGbc = new GridBagConstraints();
        barGbc.gridx = 2;
        barGbc.gridy = 0;
        barGbc.gridwidth = 2;
        barGbc.gridheight = 4;
        barGbc.insets = new Insets(5,5,5,5);
        barGbc.fill = GridBagConstraints.NONE;
        RoundedButton barButton = new RoundedButton("Bar", 100, 80,10);
        barButton.setPreferredSize(new Dimension(200, 400));
        barButton.setForeground(Color.BLACK);
        barButton.setFont(new Font("Calibri", Font.PLAIN, 36));

        for (Table table : TableData.tables){
            if (table.getTableID().equals("BAR")){
                barButton.putClientProperty("table", table);
                break;
            }
        }
        Table connectedTable = (Table) barButton.getClientProperty("table");
        boolean adminLogin = EmployeeInitializer.currentUser.username.equals("admin");
        if (adminLogin || ((Waiter) EmployeeInitializer.currentUser).section == connectedTable.getSection()){
            barButton.setBackground(ScreenColors.LIGHTORANGE);
        } else {
            barButton.setBackground(Color.WHITE);
            barButton.setEnabled(false);
        }
        add(barButton, barGbc);

        revalidate();
        repaint();
    }
}

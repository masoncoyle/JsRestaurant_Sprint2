import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableViewPanel extends JPanel {
    TableViewPanel(CardLayout cardLayout, JPanel mainPanel){
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
        topBar.add(Box.createHorizontalStrut(50));

        JLabel usernameText = new JLabel("Logged in as [role] [username]");
        usernameText.setForeground(Color.WHITE);
        usernameText.setFont(new Font("Calibri", Font.PLAIN, 14));
        usernameText.setAlignmentX(Component.CENTER_ALIGNMENT);
        topBar.add(usernameText);

        sidebar.add(topBar);

        sidebar.add(Box.createVerticalStrut(40));

        RoundedRectangle selectTableBox = new RoundedRectangle(250, 50, 10);
        selectTableBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectTableBox.setBackground(Color.WHITE);
        selectTableBox.setMaximumSize(new Dimension(250,50));
        selectTableBox.add(Box.createVerticalStrut(50));
        JLabel selectTableText = new JLabel("Select a Table");
        selectTableText.setForeground(ScreenColors.BLUETEXT);
        selectTableText.setFont(new Font("Calibri", Font.PLAIN, 24));
        selectTableBox.add(selectTableText);
        sidebar.add(selectTableBox);

        sidebar.add(Box.createVerticalGlue());

        JPanel clockInClockOut = new JPanel();
        clockInClockOut.setMaximumSize(new Dimension(250, 40));
        clockInClockOut.setOpaque(false);
        clockInClockOut.setLayout(new BoxLayout(clockInClockOut, BoxLayout.X_AXIS));
        clockInClockOut.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        RoundedButton logOutButton = new RoundedButton("Log Out", 250, 40, 10);
        logOutButton.setPreferredSize(new Dimension(250,40));
        logOutButton.setMaximumSize(new Dimension(250,40));
        logOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logOutButton.setBackground(ScreenColors.LIGHTBLUE);
        logOutButton.setFont(new Font("Calibri", Font.PLAIN,20));
        logOutButton.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        sidebar.add(logOutButton);
        sidebar.add(Box.createVerticalStrut(10));

        add(sidebar, BorderLayout.WEST);
    }
}

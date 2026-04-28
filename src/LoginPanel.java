import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    LoginPanel(CardLayout cardLayout, JPanel mainPanel){
        setBackground(ScreenColors.LIGHTBLUE);
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        RoundedRectangle screenFrame = new RoundedRectangle(1220, 720, 50);
        screenFrame.setBackground(ScreenColors.MEDBLUE);
        screenFrame.setLayout(new BoxLayout(screenFrame, BoxLayout.Y_AXIS));
        add(screenFrame, gridBagConstraints);

        JLabel title = new JLabel("Restaurant Management System");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Calibri", Font.PLAIN, 54));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        screenFrame.add(Box.createVerticalStrut(100));
        screenFrame.add(title);

        RoundedRectangle loginBox = new RoundedRectangle(400,400,20);
        loginBox.setMaximumSize(loginBox.getPreferredSize());
        loginBox.setBackground(ScreenColors.LIGHTBLUE);
        screenFrame.add(Box.createVerticalStrut(50));
        loginBox.setLayout(new BoxLayout(loginBox, BoxLayout.Y_AXIS));
        loginBox.add(Box.createVerticalStrut(40));

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginLabel.setFont(new Font("Calibri", Font.PLAIN, 26));
        loginLabel.setForeground(ScreenColors.BLUETEXT);
        loginBox.add(loginLabel);
        loginBox.add(Box.createVerticalStrut(40));

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        usernameLabel.setForeground(ScreenColors.BLUETEXT);
        loginBox.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(300, 40));
        usernameField.setFont(new Font("Calibri", Font.PLAIN, 24));
        usernameField.setBorder(BorderFactory.createEmptyBorder(10,5,5,5));
        loginBox.add(usernameField);
        loginBox.add(Box.createVerticalStrut(30));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordLabel.setForeground(ScreenColors.BLUETEXT);
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
        loginBox.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(300, 40));
        passwordField.setFont(new Font("Calibri", Font.PLAIN, 24));
        passwordField.setBorder(BorderFactory.createEmptyBorder(10,5,5,5));
        loginBox.add(passwordField);
        loginBox.add(Box.createVerticalStrut(50));

        RoundedButton loginButton = new RoundedButton("Login", 300,40,10);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setMaximumSize(new Dimension(300, 40));
        loginButton.setBackground(ScreenColors.MEDBLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Calibri", Font.PLAIN, 24));
        loginButton.setBorder(BorderFactory.createEmptyBorder(10,5,5,5));
        loginBox.add(loginButton);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setAlignmentX(CENTER_ALIGNMENT);
        loginBox.add(errorLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                //Check Credentials

                //If correct
                cardLayout.show(mainPanel, "TABLE_VIEW");

                //If incorrect
                errorLabel.setText("Incorrect username or password.");
            }
        });


        screenFrame.add(loginBox);
    }
}

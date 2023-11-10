import java.awt.*;
import java.awt.event.*;

public class LoginWindow {
    public static void main(String[] args) {
        Frame frame = new Frame("Login Window");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Panel panel = new Panel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // Add some padding

        Label userLabel = new Label("Username:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(userLabel, constraints);

        TextField userTextField = new TextField(20);
		constraints.gridy = 0;
        constraints.gridx = 1;
        panel.add(userTextField, constraints);

        Label passLabel = new Label("Password:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passLabel, constraints);

        TextField passTextField = new TextField(20);
        constraints.gridx = 1;
        panel.add(passTextField, constraints);

        passTextField.setEchoChar('*');

        Button loginButton = new Button("Login");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.EAST; // Align to the right
        panel.add(loginButton, constraints);

        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText();
                String password = passTextField.getText();

                // You can add login logic here
                if (username.equals("your_username") && password.equals("your_password")) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Login failed. Please check your credentials.");
                }
            }
        });

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}

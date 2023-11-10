import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        // Create GridBagLayout constraints
        GridBagConstraints gbc = new GridBagConstraints();

        // Create a TextField with multiple lines
        TextArea textArea = new TextArea("", 5, 30); // 5 rows, 30 columns
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // span 2 columns
        gbc.gridheight = 2; // span 2 rows
        gbc.fill = GridBagConstraints.BOTH; // Allow both horizontal and vertical expansion
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
        panel.add(textArea, gbc);

        // Create a Button
        Button button = new Button("Submit");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // reset gridwidth to 1
        gbc.gridheight = 1; // reset gridheight to 1
        gbc.fill = GridBagConstraints.NONE; // Don't allow expansion
        panel.add(button, gbc);

        frame.setVisible(true);
    }
}

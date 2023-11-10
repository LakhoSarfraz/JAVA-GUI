import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        Frame frame = new Frame("GridBagLayout Example");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();

        Label label = new Label("This is a label");

        // Increase the font size
        Font labelFont = label.getFont();
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, 20)); // Adjust the font size as needed

        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;

        layout.setConstraints(label, constraints);
        frame.add(label);

        frame.pack();
        frame.setVisible(true);
    }
}

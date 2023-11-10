import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MaximizeFrameExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Maximized Frame");

        // Add a window listener to handle the frame's close event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Get the default screen device
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        // Set the frame to be undecorated (remove title bar and borders)
        frame.setUndecorated(true);

        // Set the frame to full screen mode
        gd.setFullScreenWindow(frame);

        // Make the frame visible
        frame.setVisible(true);
    }
}

import java.awt.Frame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;

public class FrameCenter {
    public static void main(String[] args) {
        Frame frame = new Frame("Centered Frame Example");
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("Closing the frame...");
				frame.dispose();
			}
			
		});
		
        // Set the size of the frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = 400;
        int frameHeight = 300;
        frame.setSize(frameWidth, frameHeight);

        // Center the frame on the screen
        int x = (screenSize.width - frameWidth) / 2;
        int y = (screenSize.height - frameHeight) / 2;
        frame.setLocation(x, y);

        // Set the frame visibility to true
        frame.setVisible(true);
    }
}

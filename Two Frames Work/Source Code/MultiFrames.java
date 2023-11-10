import java.awt.*;
import java.awt.event.*;

public class MultiFrames{
	
	
	

	public static void main(String[] args){
		
		SecFrame secFrameObj=new SecFrame();
		secFrameObj.addFrame();
		
		
		
		Frame mainFrame=new Frame("Main Frame");
		mainFrame.setLocation(400, 200);
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setSize(600,400);
		mainFrame.setVisible(true);



		
		Button btn1=new Button("Show Other Frame");
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			secFrameObj.show();
				
			}			
		});

		mainFrame.add(btn1);

		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
				
			}
			
			
		});
	
		
		
		



		
		

		
	}

	
	
	
	
	
}
import java.awt.*;
import java.awt.event.*;

public class SecFrame{
	
	Frame secFrame;
	

	public void addFrame(){
		
		secFrame=new Frame("Second Frame");
		secFrame.setLocation(600, 300);
		secFrame.setLayout(new FlowLayout());
		secFrame.setSize(300,200);
		secFrame.setVisible(true);

		
		Button btn1=new Button("Hide Me");
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				System.out.println("hiding self");
				hide();
				
				
			}			
		});
		
		secFrame.add(btn1);

		secFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				hide();
				
			}
			
			
		});
	
		
	}


	public void hide(){
		secFrame.setVisible(false);
	}
	public void show(){
		secFrame.setVisible(true);
	}
	
	
	
}
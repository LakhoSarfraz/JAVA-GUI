import java.awt.*;
import java.awt.event.*;

public class MultipleButtons implements ActionListener{
	public void doStart(){
		Frame mainFrame=new Frame("First frame");
		mainFrame.setLayout(new GridLayout(1,1));
		mainFrame.setSize(400,300);
		mainFrame.setLocation(500,300);
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.print("Closing the mainFrame");
				mainFrame.dispose();
			}

		});
		
		
		Panel panel=new Panel();
		panel.setLayout(new GridLayout(3,3,5,5));
		
		Button[] btnArr=new Button[9];
		
		// initialization tons using loop
		for(int i=0; i<btnArr.length; i++){
			btnArr[i] = new Button(Integer.toString(i));
			panel.add(btnArr[i]);
			btnArr[i].addActionListener(this);
		}
		
		
		mainFrame.add(panel);
		mainFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		String name=e.getActionCommand();
		System.out.println("You pressed button " + name);
		
	}
	
	
	public static void main(String[] args){
		MultipleButtons m=new MultipleButtons();
		m.doStart();
	}
	

	
}
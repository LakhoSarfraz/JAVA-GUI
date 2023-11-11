import java.awt.*;
import java.awt.event.*;

public class TextToLabel{
	Frame mainFrame;
	Label label;
	TextField textField;
	Button button;
	public void start(){
		mainFrame=new Frame("Main Frame");
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.setSize(400,350);
		mainFrame.setLocation(600,300);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("Exiting...");
				System.exit(0);
			}
			
		});
		
		label=new Label("Type something an press button");
		textField=new TextField("");
		button=new Button("Button 1");
		
		mainFrame.add(label);
		mainFrame.add(textField);
		mainFrame.add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				label.setText(textField.getText());
				
			}
		});
		
		
		
	}
	
	public static void main(String[] args){
		TextToLabel obj=new TextToLabel();
		obj.start();
		
	}
	
	
}
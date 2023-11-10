import java.awt.*;
import java.awt.event.*;

public class PanelWork{
	
	
	public static void main(String[] args){
		Frame mainFrame=new Frame("Main frame");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(800,300);
		mainFrame.setLocation(500,300);
		mainFrame.setVisible(true);
		//mainFrame.setResizable(false);
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		
		
		
		
		Panel panel=new Panel();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints=new GridBagConstraints();
		
		constraints.gridx=0;
		constraints.gridy=0;
		//constraints.gridwidth=1;
		TextField label=new TextField("This is a label Hello world kese ho bhai jan");
		panel.add(label,constraints);
		
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.anchor=GridBagConstraints.WEST;
		Button btn1=new Button("Button 1");
		panel.add(btn1, constraints);
		
		/*
		Button btn2=new Button("Button 2");
		Button btn3=new Button("Button 3");
		Button btn4=new Button("Button 4");

		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		*/
		
		mainFrame.add(panel,BorderLayout.NORTH);
		
		
		Button btn5=new Button("Button 4");
		Panel pPanel=new Panel(new FlowLayout());
		pPanel.add(btn5);
		mainFrame.add(pPanel,BorderLayout.SOUTH);
		
		
		Panel panelLeft=new Panel();
		panelLeft.setLayout(new FlowLayout());
		panelLeft.add(new Button("left"));
		panelLeft.add(new Button("left 2"));
		mainFrame.add(panelLeft,BorderLayout.WEST);
		panelLeft.setBackground(Color.RED);
	}
	
	
}
import java.awt.*;
import java.awt.event.*;

public class IdiotMain{
	public static void main(String[] args){
		Frame mainFrame=new Frame("Idiot Man");
		mainFrame.setLayout(new BorderLayout());
		
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
		mainFrame.setUndecorated(true);
		gd.setFullScreenWindow(mainFrame);
		
		Panel panel=new Panel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;

		gbc.gridwidth=2;
		Label label=new Label("Are You an IDIOT ?");
		

		panel.add(label,gbc);
		
		
		
		
		
		gbc.gridy=1;
		gbc.gridwidth=1;
		Button noBtn=new Button("No");
		panel.add(noBtn,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		Button yesBtn=new Button("Yes");
		panel.add(yesBtn,gbc);
		
		boolean response=false;
		
		yesBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				System.exit(0);
			}
			
		});
		
		
		mainFrame.add(panel,BorderLayout.CENTER);
		
		
		mainFrame.setVisible(true);
		
		while(!response){
			try{
				Thread.sleep(3000);
				mainFrame.setVisible(false);
				
				mainFrame.setVisible(true);
				//mainFrame.toFront();
				
				
				 //mainFrame.setAlwaysOnTop(true);

				// Request focus for the frame
				//mainFrame.requestFocus();
			}
			catch(InterruptedException e){
			}
			
			
		}
		
		
		
	}




}
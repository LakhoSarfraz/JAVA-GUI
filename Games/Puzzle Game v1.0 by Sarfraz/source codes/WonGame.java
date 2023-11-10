package gamefiles;

import java.awt.*;
import java.awt.event.*;

public class WonGame{
	public static void startFrame(){
		Frame wonGameFrame=new Frame("Congrutulations !! You Won");
		wonGameFrame.setLayout(new FlowLayout());
		wonGameFrame.setSize(400,170);
		wonGameFrame.setLocation(400,300);
		wonGameFrame.setResizable(false);
		wonGameFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				wonGameFrame.dispose();
			}	
			
		});
		
		Font normalFont=new Font("SansSerif", Font.PLAIN, 30);
		
		Label congLabel=new Label("CONGRATULATIONS !!!");
		congLabel.setFont(normalFont);

		wonGameFrame.add(congLabel);
		
		
		Label wonLabel=new Label("YOU WON");
		Font wonFont=new Font("SansSerif", Font.PLAIN, 50);
		wonLabel.setFont(wonFont);
		wonGameFrame.add(wonLabel);
		
		
		
		wonGameFrame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		WonGame wg=new WonGame();
		wg.startFrame();
	}
}
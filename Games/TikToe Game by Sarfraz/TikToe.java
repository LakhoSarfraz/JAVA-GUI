import java.awt.*;
import java.awt.event.*;



public class TikToe{
	Frame mainFrame;
	Panel panelCenter;
	Panel panelButtom;
	static boolean xTurn;
	static int xWins;
	static int oWins;
	Button[] btn;
	Label xWinLabel;
	Label oWinLabel;
	Label turnLabel;
	public void startGame(){
		
		
		mainFrame=new Frame();
		mainFrame.setTitle("TikToe Game by Sarfraz");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(400,400);
		mainFrame.setLocation(400,200);
		mainFrame.setResizable(false);
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}	
		});
		
		panelCenter=new Panel();
		panelCenter.setLayout(new GridLayout(3,3,5,5));

		btn=new Button[9]; //Button array for 9 button
		Font  btnFont=new Font("SansSerif", Font.PLAIN, 30);
		// loop to initialize each button
		for(int i=0; i<9; i++){
			btn[i]=new Button();
			btn[i].setFont(btnFont);
		}

		// loop that add each button to panel	
		for(int i=0; i<9; i++){
			panelCenter.add(btn[i]);
		}
		
		// loop that give ActionListener to each button
		for (int i=0; i<9; i++){
			final int buttonIndex=i;
			
			btn[buttonIndex].addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent e){
					if(TikToe.xTurn){
						btn[buttonIndex].setLabel("X");
						TikToe.xTurn=false;
						btn[buttonIndex].setBackground(Color.PINK);
					}
					else {
						btn[buttonIndex].setLabel("O");
						TikToe.xTurn=true;
						btn[buttonIndex].setBackground(Color.YELLOW);
					}
					
					checkWin();
					btn[buttonIndex].setEnabled(false);
					
				}
				
			});
			
		}
		
		panelButtom=new Panel();
		panelButtom.setLayout(new FlowLayout());
		panelButtom.setBackground(Color.GREEN);
		
		Button resetBtn=new Button("Reset");
		resetBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				reset();
			}
		});
		
		Button playAgainBtn=new Button("Play Again");
		playAgainBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				playAgain();
			}
		});
		
		xWinLabel=new Label("X-Wins : ("+xWins+")");
		oWinLabel=new Label("O-Wins : ("+oWins+")");
		
		turnLabel=new Label("Now Turn : " + "O");
		
		panelButtom.add(turnLabel);
		panelButtom.add(resetBtn);
		panelButtom.add(playAgainBtn);
		panelButtom.add(xWinLabel);
		panelButtom.add(oWinLabel);
		
		
		mainFrame.add(panelCenter,BorderLayout.CENTER);
		mainFrame.add(panelButtom,BorderLayout.SOUTH);
		mainFrame.setVisible(true);
	}
	//....................below are methods
	static String winSym;
	
	public void checkWin(){
		winSym="O";
		
		if(turnLabel.getText().contains("O")){
			turnLabel.setText("Now Turn : " + "X");
		} else{
			turnLabel.setText("Now Turn : " + "O");
		}
		
		
		
		
		
		String[] strArr=new String[9];
		
		boolean isFull=true;
		for(int i=0; i<9; i++){
			strArr[i]=btn[i].getLabel();
			if(strArr[i]==""){
				isFull=false;
			}
		}			
		
		
		
		
		for(int j=0; j<2; j++){
			if(strArr[0]==winSym && strArr[1]==winSym && strArr[2]==winSym ||
			strArr[0]==winSym && strArr[3]==winSym && strArr[6]==winSym ||
			strArr[0]==winSym && strArr[4]==winSym && strArr[8]==winSym ||
			
			strArr[4]==winSym && strArr[2]==winSym && strArr[6]==winSym ||
			strArr[4]==winSym && strArr[1]==winSym && strArr[7]==winSym ||
			strArr[4]==winSym && strArr[3]==winSym && strArr[5]==winSym ||
			
			strArr[8]==winSym && strArr[5]==winSym && strArr[2]==winSym ||
			strArr[8]==winSym && strArr[7]==winSym && strArr[6]==winSym 

			){
				
				if(winSym=="X"){
					xWins++;
				}
				else{
					oWins++;
				}
				update();
				
				System.out.println(winSym + " won");
				panelCenter.setEnabled(false);
				
				
			}
		winSym="X";
		
		}
		
		// when draw match also when all boxes are full
		if(isFull){
			
			
			
		}
		

		
	}
	
	
	public void playAgain(){
		panelCenter.setEnabled(true);
		for(int i=0; i<9; i++){
			btn[i].setBackground(new Button().getBackground());
			btn[i].setLabel("");
			btn[i].setEnabled(true);
		}

	}
	
	public void reset(){
		playAgain();
		xWins=0;
		oWins=0;
		update();
	}
	public void update(){
		xWinLabel.setText("X-Wins : ("+xWins+")");
		oWinLabel.setText("O-Wins : ("+oWins+")");
		
		
	}
	
	public static void main(String[] args){
		TikToe tikToe=new TikToe();
		tikToe.startGame();
		
	}
	
	
}
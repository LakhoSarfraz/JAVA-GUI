import java.awt.*;
import java.awt.event.*;



public class TikToe{
	Frame mainFrame; //main frame that show when opens the game
	Panel panelCenter; // a panel that will be shown in the center of frame because frame has border layout
	Panel panelButtom; // it is a panel used for buttom menus and options
	static boolean xTurn; // it will catch who's turn is now
	static int xWins; // it will store number of wins for X-Player
	static int oWins; // also will store number of wins for O-Player
	Button[] btn; // number of buttons that will be used for X and O (game area)
	Label xWinLabel; // just label for X win
	Label oWinLabel;// just label for O win
	Label turnLabel; // this label will show the turn of player
	public void startGame(){
		
		
		mainFrame=new Frame(); // intializing frame
		mainFrame.setTitle("TikToe Game by Sarfraz"); // name of a frame
		mainFrame.setLayout(new BorderLayout()); // frame layout 
		mainFrame.setSize(400,400); // size of game window
		mainFrame.setLocation(400,200); // location on screen for game window
		mainFrame.setResizable(false); // lock the game window size
		// below is the event when click on the frame close button, it just close the program
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}	
		});
		
		panelCenter=new Panel(); // the game area panel is initialized
		panelCenter.setLayout(new GridLayout(3,3,5,5)); // game area layout

		btn=new Button[9]; //Button array for 9 button
		Font  btnFont=new Font("SansSerif", Font.PLAIN, 30); // font for showing x and o text (on button)
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
					//the below code will check which player's turn
					if(TikToe.xTurn){  //for X player
						btn[buttonIndex].setLabel("X");  // change the button label to X
						TikToe.xTurn=false; // give turn to O
						btn[buttonIndex].setBackground(Color.PINK); // changing button color to pink for X
					}
					else { // for O player
						btn[buttonIndex].setLabel("O"); // change the button label to O
						TikToe.xTurn=true; // give turn to X
						btn[buttonIndex].setBackground(Color.YELLOW); // changing button color to yellow for O
					}
					
					checkWin(); // check whether 3 (O or X) is made
					btn[buttonIndex].setEnabled(false); // disable the button that is clicked
					
				}
				
			});
			
		}
		
		panelButtom=new Panel(); // panel for buttom buttons and status 
		panelButtom.setLayout(new FlowLayout()); // Flow Layout for panel
		panelButtom.setBackground(Color.GREEN); // buttom layout background color to Green
		
		Button resetBtn=new Button("Reset"); // Reset button is created here
		resetBtn.addActionListener(new ActionListener(){ //listener(when clicked) for reset button
			public void actionPerformed(ActionEvent e){
				reset(); // when reset is clicked this functin will be called
			}
		});
		
		Button playAgainBtn=new Button("Play Again"); // play again button created
		playAgainBtn.addActionListener(new ActionListener(){ // action listener for play again button
			public void actionPerformed(ActionEvent e){
				playAgain(); // call this functin when play again button is clicked
			}
		});
		
		xWinLabel=new Label("X-Wins : ("+xWins+")"); // this  will show x wins in buttom panel
		oWinLabel=new Label("O-Wins : ("+oWins+")"); // ....show o wins....
		
		turnLabel=new Label("Now Turn : " + "O"); // will show turn
		
		panelButtom.add(turnLabel); // adding all elements to buttom panel
		panelButtom.add(resetBtn);
		panelButtom.add(playAgainBtn);
		panelButtom.add(xWinLabel);
		panelButtom.add(oWinLabel);
		
		
		mainFrame.add(panelCenter,BorderLayout.CENTER); // adding all panels to mainFrame
		mainFrame.add(panelButtom,BorderLayout.SOUTH);
		mainFrame.setVisible(true); // Main Frame to be visible or not
	}
	//....................below are methods
	static String winSym; // the turn label will show this string symbol
	
	public void checkWin(){ 

		
		if(turnLabel.getText().contains("O")){ // if the button O is clicked then , turn label will change to X
			turnLabel.setText("Now Turn : " + "X");
		} else{
			turnLabel.setText("Now Turn : " + "O"); // if not then turn label will change to O
		}
		
		
		
		
		
		String[] strArr=new String[9]; // array for  storing each button's label
		
		boolean isFull=true; // boolean to check whether all buttons have been clicked
		boolean winnerFound=false;

		// loop to check all buttons are full, if any button is empty "" then boolean will become false
		for(int i=0; i<9; i++){
			strArr[i]=btn[i].getLabel();
			if(strArr[i]==""){
				isFull=false;
			}
		}			
		
		winSym="O"; // it is used to check for Win, the first O will be checkd in below loop after
		// winSym value will be change to X then X will be checked for win
		
		
		// this loop will check from every angle for a winner
		// this loop will use buttons label to check winner
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
				// if three are founds(a win) then these lines of code will run
				
				if(winSym=="X"){ // if X wins then 
					xWins++; // this block of code runs
				}
				else{
					oWins++; // if O wins this block of code runs
				}
				winnerFound=true;
				update(); // Number of wins will be updated
				
				System.out.println(winSym + " won"); // printing winner
				panelCenter.setEnabled(false); // center panel will be disable after win to avoid extra clicking
				
				
			}
			
			
			
		winSym="X"; 
		
		}
		
		// when draw match also when all boxes are full
		if(isFull && !winnerFound){

			// this block will run when it is draw
				
			System.out.println("Draw game");
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
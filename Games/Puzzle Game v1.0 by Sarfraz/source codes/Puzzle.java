/*
this is the Puzzle game frame

*/
package gamefiles;
import java.awt.*;
import java.awt.event.*;

public class Puzzle{
	Frame mainFrame;
	
	public  int gameColumns; //width of game(per cells)
	public  int gameRows; // height of game (per cells)
	public int totalCells; // it will store total number of cells
	
	public void startGame(){ //overloading method for no argument
		startGame(4,4); // 4 col,4 row
	}
	public void startGame(int gC, int gR){
		gameColumns=gC; 
		gameRows=gR;
		totalCells=gameColumns*gameRows;
		//........... variables 
		
		//mainFrame variables
		String gameTitle="Puzzle Game by Sarfraz";
		int xLocation=400;
		int yLocation=200;
		int fHeight=gameRows*100;
		int fWidth=gameColumns*100;
		if(fHeight>500) fHeight=600;
		if(fWidth>500) fWidth=800;
		
		//main Frame some setting 
		mainFrame=new Frame();
		mainFrame.setTitle(gameTitle);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setLocation(xLocation,yLocation);
		mainFrame.setSize(fWidth,fHeight);
		mainFrame.setResizable(false);
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
					mainFrame.dispose();
			}
		});
		
		//....... mainFrame setting ended here
		
		Panel centerPanel=new Panel(); // panel to put it in the middle of frame.
		centerPanel.setLayout(new GridLayout(gameRows,gameColumns,5,5)); // gridlayout rows, and columns
		
		
		Button[] btn=new Button[totalCells]; //Button arrays
		//loop that initialize each button
		for(int i=0; i<btn.length ;i++){ //
			btn[i]=new Button();
			centerPanel.add(btn[i]);
		}
		
		Font btnFont=new Font("SansSerif",Font.PLAIN, 50-(gameColumns+gameRows));
		// actionListener for each Button , also color
		for(int i=0; i<btn.length; i++){
			final int iFinal=i; // clicked button number for using in argument
			btn[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					cellClicked(btn, iFinal); // when clicked , all buttons will
				}
				
			});
			
			btn[i].setBackground(Color.ORANGE); // backcolor for each button
			btn[i].setFont(btnFont); // font for each button(cell)
		}
		
		btn[btn.length-1].setBackground(Color.YELLOW); // last cell to yellow color
		
		centerPanel.setBackground(Color.YELLOW);
		mainFrame.add(centerPanel,BorderLayout.CENTER);
		
		setValuesToButtons(btn);
		
		
		
		
		
		
		
		
		mainFrame.setVisible(true);
	}
	//ending of frame method
	
	private void cellClicked(Button[] btnArr, int btnNumber){
		
	
		
		
		
		
		/*
		Exception is used here ,if a clicked-cell is near the wall 
		that will produce exception or it will work abnormal
		1. the first and last cell will produce error ,
		2. the left most button will exchange its label to its top-right most cell;
		3. the right most button will exchange its label to its button-left most cell;
		to avoid these all problems the below code is used for each click
		*/
	
	
			//checking top cell(Button) , if it is empty label
		try{
			if(btnArr[btnNumber-gameColumns].getLabel()==""){
				//chaning labels
				btnArr[btnNumber-gameColumns].setLabel(btnArr[btnNumber].getLabel());
				btnArr[btnNumber].setLabel("");
				
				
			}
		}catch(Exception e1){}
		
		
		// buttom cell
		try{
		if(btnArr[btnNumber+gameColumns].getLabel()==""){
			//changing button labels
			btnArr[btnNumber+gameColumns].setLabel(btnArr[btnNumber].getLabel());
			btnArr[btnNumber].setLabel("");
			
		}
		}catch(Exception e4){}
			
		//Right cell (will check right)
		try{
		if(!((btnNumber+1)%gameColumns==0)){
			if(btnArr[btnNumber+1].getLabel()==""){
				//changing button labels
				btnArr[btnNumber+1].setLabel(btnArr[btnNumber].getLabel());
				btnArr[btnNumber].setLabel("");
				
				
			}
		}
		}catch(Exception e2){}
		
		
		//left cell
		try{
		if(!(btnNumber%gameColumns==0)){
			if(btnArr[btnNumber-1].getLabel()==""){
				//changing button labels
				btnArr[btnNumber-1].setLabel(btnArr[btnNumber].getLabel());
				btnArr[btnNumber].setLabel("");
				
				
			}
		}
		}catch(Exception e3){}
					
					
		didWon(btnArr); // after click of cell , and exchaning of value , it will check either win or not
		emptyCellColor(btnArr);

	}

	private void didWon(Button[] btnArr){
		boolean won=true; // default won is true
		
		/* the below code will check if the label of cell and cell-Number are equal are not;
		 > if any of labels are not equal to its cell values, the condition will become false and the NOT "!" operator
		   will change it to true , the over-all if condtion will become true, and changes the Won to false; 
		 > if all of labels are equal to cell values , it means WON, so
		*/
		
		for(int i=0; i<btnArr.length-1; i++){
			String btnLabel=btnArr[i].getLabel();
			String btnPlace=String.valueOf(i+1);
			boolean isMatched=btnLabel.equals(btnPlace);
			
			if(!isMatched){
				won=false;
			}
		}
		
		
		if(won){
			WonGame.startFrame();
			mainFrame.dispose();
		
		}
		
	}


	
	
	
	
	private void setValuesToButtons(Button[] btn){

		
		int[] ranNum=Random.genJungledList(1,totalCells);
		
		//int[] ranNum={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		for(int i=0; i<btn.length-1; i++){
			btn[i].setLabel(String.valueOf(ranNum[i]));
		}
		
	}
	

	
	public void setColRow(int col, int row){
		gameColumns=col;
		gameRows=row;
	}
	
	public void emptyCellColor(Button[] btnArr){
		
		for(int i=0; i<btnArr.length; i++){
			
			if(btnArr[i].getLabel().equals("")){
				btnArr[i].setBackground(Color.YELLOW);
			}
			else{
				btnArr[i].setBackground(Color.ORANGE);
			}
		}
	}

	
	public static void main(String[] args){
		Puzzle puzzle=new Puzzle();
		puzzle.startGame(10,10);
	}
}
package gamefiles;
import java.awt.*;
import java.awt.event.*;

public class GameMenu{
	Frame menuFrame;
	public void startMenu(){
		menuFrame=new Frame();
		menuFrame.setTitle("Puzzle Game Menu");
		menuFrame.setLayout(new BorderLayout());
		menuFrame.setSize(600,300);
		menuFrame.setLocation(400,300);
		menuFrame.setResizable(false);
		menuFrame.setBackground(Color.PINK);
		menuFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		Panel topPanel=new Panel();
		topPanel.setLayout(new FlowLayout());

		Label gameNameLabel=new Label("PUzZLE GAME v1.0");
		Font labelFont=new Font("SansSerif", Font.BOLD, 55);
		gameNameLabel.setFont(labelFont);
		topPanel.add(gameNameLabel);
		
		
		
		Font normalFont=new Font("SansSerif", Font.BOLD, 20); // Normal font for center panel(body)
		
		Panel centerPanel=new Panel();
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		
		
		
		Label nameLabel=new Label("Player Name: ");
		nameLabel.setFont(normalFont);
		gbc.gridx=0;
		gbc.gridy=0;
		centerPanel.add(nameLabel,gbc);
		
		TextField nameField=new TextField("Player 1");
		nameField.setFont(normalFont);
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		centerPanel.add(nameField,gbc);
		
		Label rowLabel=new Label("Rows: ");
		rowLabel.setFont(normalFont);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=1;
		gbc.weightx=0.0;
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.WEST;
		centerPanel.add(rowLabel,gbc);
		
		TextField rowField=new TextField("4");
		rowField.setFont(normalFont);
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		centerPanel.add(rowField,gbc);
		
		
		Label colLabel=new Label("Cols: ");
		colLabel.setFont(normalFont);
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=1;
		gbc.weightx=0.0;
		centerPanel.add(colLabel,gbc);
		
		TextField colField=new TextField("4");
		colField.setFont(normalFont);
		gbc.gridx=1;
		gbc.gridy=2;
		centerPanel.add(colField,gbc);
		
		
		Button playBtn=new Button("PLAY NOW");
		playBtn.setFont(normalFont);
		playBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				playBtnClicked(nameField, rowField, colField);
				
			}
			
		});
		
		
		
		Panel buttomPanel=new Panel();
		buttomPanel.setLayout(new FlowLayout());
		
		buttomPanel.add(playBtn);
		
		menuFrame.add(new Panel(),BorderLayout.EAST);
		menuFrame.add(buttomPanel,BorderLayout.SOUTH);
		menuFrame.add(topPanel, BorderLayout.NORTH);
		menuFrame.add(centerPanel,BorderLayout.CENTER);
		
		menuFrame.setVisible(true);
	}
	
	
	
	public void playBtnClicked(TextField nameField, TextField rowField, TextField colField){
		final int max=20;
		final int min=4;
		
		String row=rowField.getText();
		String col=colField.getText();
		int rowInt=0;
		int colInt=0;
		
		try{
			rowInt=Integer.parseInt(row);
			colInt=Integer.parseInt(col);
		}
		
		catch(Exception e){
			rowField.setText("4");
			colField.setText("4");
		}
		
		if(rowInt<min){
			rowInt=min;
			rowField.setText(String.valueOf(min));;
		}
		else if(rowInt>max){
			rowInt=max;
			rowField.setText(String.valueOf(max));
		}
		
		if(colInt<min){
			colInt=min;
			colField.setText(String.valueOf(min));
		}
		else if(colInt>max){
			colInt=max;
			colField.setText(String.valueOf(max));
		}
		
		
		String playerName=nameField.getText();
		if(playerName.equals("")){
			nameField.setText("Player 1");
		}

		Puzzle gameObj=new Puzzle();
		gameObj.startGame(colInt,rowInt);
		
	}
	
	public static void main(String[] args){
		GameMenu gm=new GameMenu();
		gm.startMenu();
		
	}
}
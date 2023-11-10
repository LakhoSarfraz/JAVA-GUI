import java.awt.*;
import java.awt.event.*;

public class SWE23Data{
	Frame mainFrame;
	TextArea resultArea;
	TextField fieldSearchWord;
	public void doStart(){
		
		
		mainFrame=new Frame();
		mainFrame.setTitle("Software Engineering 2K23 -  Database");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setSize(500,600);
		mainFrame.setLocation(300,100);
		
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}

		});
		
		Panel topPanel=new Panel();
		topPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		
		
		Label headLabel=new Label("You Can Search any of your friend's data");
		
		Font labelFont = new Font("SansSerif", Font.PLAIN, 16);
		headLabel.setFont(labelFont);
		topPanel.add(headLabel,gbc);
		
		//topPanel.pack();
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=2;
		Label labelSearchWord=new Label("Enter any word to search:");
		labelSearchWord.setFont(labelFont);
		topPanel.add(labelSearchWord,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		fieldSearchWord=new TextField("");
		topPanel.add(fieldSearchWord,gbc);
		
		
		gbc.gridx=4;
		gbc.gridy=2;
		gbc.gridwidth=1;
			
		Button searchBtn=new Button("Search");
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				searchData();
			}
		});
		
		
		topPanel.add(searchBtn,gbc);
		
		
		mainFrame.add(topPanel,BorderLayout.NORTH);
		
		
		
		
		
		Panel centerPanel=new Panel();
		centerPanel.setLayout(new GridBagLayout());
		
		resultArea=new TextArea();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		centerPanel.add(resultArea,gbc);
		mainFrame.add(centerPanel,BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		


		mainFrame.setVisible(true);
	}		
	
	public void searchData(){
		DataSeparator sepObj=new DataSeparator();
		String sWord=fieldSearchWord.getText();
		String fileName="student_data.txt";
		
		
		resultArea.setText("");
		try{
			String[][] strArr=sepObj.doSeparation(fileName,sWord);
			for(int i=0; i<strArr.length;i++){
				resultArea.append ("RESULT NO: "+(i+1)+"\n");
				resultArea.append("Roll: " + strArr[i][15] + "\n");
				resultArea.append("Name: " + strArr[i][2] + "\n");
				resultArea.append("Father: " + strArr[i][3] + "\n");
				resultArea.append("Caste: " + strArr[i][4] + "\n");
				resultArea.append("District: " + strArr[i][5] + "\n");
				resultArea.append("University: " + strArr[i][6] + "\n");
				resultArea.append("Degree: " + strArr[i][9] + "\n");
				resultArea.append("Shift: " + strArr[i][10] + "\n");
				resultArea.append("Quota: " + strArr[i][11] + "\n");
				
				
				resultArea.append("\n\n");
			}
		}
		catch(Exception e){
			resultArea.setText("NOT FOUND !! \n");
			System.out.println("Error OR FOUND");
		}
	}
	
	
	public static void main(String[] args){
		SWE23Data dataObj=new SWE23Data();
		dataObj.doStart();
		
	}
	
	
}
// this class is used to convert, a comma(or any other symbol) separated data to 2D array
// this will return a 2d string dataType array;
// some methods of the class are given below:
// classObj.doSeparation(fileName,SearchWord,Splitter); all inputs must be in string dataType
// classObj.doSeparation(fileName,searchWord); can be used and the default splitter "comma" will be put here

// for example you you have a file called myFile.txt, and in that file you have data that are separated by comma (or anyother symbol) .
// you can use this class to fetch each line data separated in arrays.
// using example
// int[] receivedArray=classObj.doSeparation(fileName,searchword,splitter);

import java.io.*;
public class DataSeparator{
	public String[][] doSeparation(String fileName, String searchWord, String splitter){
		String[][] resultData;
		int foundNumber=-1; // number of search found in a file
		int colPerElement=0; // per line how many columns are there
		searchWord=searchWord.toUpperCase();
		boolean found=false;
		
		try{			
			File inputFile=new File(fileName);
			
			//.......
			//these lines are written to check the number of (founds result) in a file
			// and then intialize the array
			BufferedReader reader2=new BufferedReader(new FileReader(inputFile));
			int maxCol=0;
			String line;
			while((line=reader2.readLine()) != null){
				if(line.toUpperCase().contains(searchWord)){
					colPerElement=line.split(splitter).length;
					if(colPerElement<maxCol) {
						colPerElement=maxCol;
					}
					else maxCol=colPerElement;
					
					foundNumber++;
				}
			}
			resultData=new String[foundNumber+1][colPerElement]; // these arr(return array) are intilizaed here
			//......
			
			foundNumber=-1;
			BufferedReader reader=new BufferedReader(new FileReader(inputFile));
			
			
			// the below code will find the search words and put it in the result Array
			while((line=reader.readLine()) != null){
				if(line.toUpperCase().contains(searchWord)){
					foundNumber++;
					found=true;
					String[] lineData=line.split(splitter);
					resultData[foundNumber]=lineData;
				}

			}
			// when the all results are set into array then the result will be returned
			if(foundNumber>-1){
				return resultData;
			}
			
			
			//optional: if not found the "not found" will be printed
			if(!found){
				System.out.println("Not found in record\nPlease try with different name\n");
				
			}

			
			reader.close();

		}
		catch (IOException e){
			e.printStackTrace();
		}


		resultData=new String[1][0];
		return resultData;	
	}
	
	
	public String[][] doSeparation(String fileName, String searchWord){
		return this.doSeparation(fileName,searchWord,",");
	}
	
	
	
	public static void main(String[] args){
		/*

		//Example for using of this class
		DataSeparator obj=new DataSeparator();
		String[][] strArr=obj.doSeparation("file.txt","nhi");
		for(int i=0; i<strArr.length; i++){	
			System.out.println(strArr[i][2]);
		}
		*/
		
		
	}
	
	
	
}
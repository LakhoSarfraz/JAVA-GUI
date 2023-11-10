/*
This class is used to generate random numbers with different return results
1. In the genJungledList method , you give two arguments,one for initialization and one for ending
  in return it will create an array of shuffled numbers.
   Example: 
   Class.genJungledList(3,9); it will generate result something like this {4,3,7,6,5,8};
   it will also sure that all the numbers are included in the return array.


*/
package gamefiles;
public class Random{

	public static int[] genJungledList(int initialize, int end){
		
		// the below condition will ensure that initialize number must not greater then end number.
		if(initialize>end){
			System.out.println("End Value is Smaller than Initialize Value");
			return new int[0];
		}
		
		int numberBetween=end-initialize; // it will count numbers between initialization and Ending
		
		
		int[] jungledArr=new int[numberBetween]; // array created 
		
		// create all "between values" and put it to jungledArr
		for (int i=0; i<jungledArr.length; i++){
				jungledArr[i]=initialize++;
		}
		
		
		
		
		// the loop will shuffle the jungledArr
		for(int i=0; i<jungledArr.length; i++){
			
			int randNum=(int)(Math.random()*numberBetween); //it will generate a number that will be used for shuffling
			
			// the below code will exchange the value of array-elements;
			int tempNumber=jungledArr[i]; 
			jungledArr[i]=jungledArr[randNum];
			jungledArr[randNum]=tempNumber;
		
		}
		
		return jungledArr; // returning of Array with shuffled values
		
		
	}	
	public static int[] genJungledList(int end){
		return genJungledList(0,end);	
	}
	

	
	
	public static void main(String[] args){
		// optional: example
		int[] arr=genJungledList(4,10);
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
			
		}
		
	}
	
}
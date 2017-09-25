package searching;

import java.util.stream.IntStream;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{10,1,6,7,9,4,3,2,8,5};
		int searchNumber = 2;
		
		linearSearch(array, searchNumber);
	}
	
	static void linearSearch(int[] array, int number){
		if(!IntStream.of(array).anyMatch(x -> x == number)){
			printResult(false, number, 0);
			System.exit(0);
		}
		for(int i=0; i < array.length-1; i++){
			if(array[i] == number){
				printResult(true, number, i);
			}
		}
	}
	
	static void printResult(boolean result, int number, int position){
		if (result == false){
			System.out.println("Number id not in the array");
		} else {
			System.out.println("Number "+ number +" is at "+position+" position.");
		}
	}

}

package shuffling;

import java.util.Random;

public class FischerYatesShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		
		for(int i=array.length-1; i>=0; i--){
			int pick = new Random().nextInt(i);
			swap(array, i, pick);
		}
	}
	
	static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}

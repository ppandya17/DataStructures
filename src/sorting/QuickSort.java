package sorting;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int array[] = new int[]{10,5,3,4,9,2};
		int array[] = new int[]{5, 4, 4, 4, 4, 1};
		//int[] array = new int[10];
		
		//generateRandomArray(array);
		
		quickSort(array, 0, array.length-1);
		
		printArray(array);		
	}

	static void quickSort(int[] array, int left, int right){
		
		if(right - left < 1){
			return;
		}
		int pivot = (array[left] + array[right])/2;
		int i = left, j = right;
		
		while(i<j){
			while(i <= j && array[i] <= pivot){
				i++;
				if(i==right)
					break;
			}
			while(i <= j && array[j] > pivot){
 				j--;
 				if(j==left) 
 					break;
			}
			if(i<j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		quickSort(array,left,i-1);
		quickSort(array,i,right);
	}
	
	static void printArray(int[] array){
		System.out.println(" ");
		for(int i=0; i<array.length; i++){
			if(i > 0){
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
	}
	
	static Random r = new Random();
	static void generateRandomArray(int[] array){
        for(int i = 0; i <  array.length; i++) {
        	array[i] = r.nextInt(100);
        	
            System.out.print(array[i] + ", ");
        }
      
	}
}

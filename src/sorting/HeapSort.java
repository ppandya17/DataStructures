package sorting;

import java.util.Random;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[]{10,5,3,4,9,2};
		//int array[] = new int[]{10,65,3,98,1,5,7,3,4,9,2,8,1,4,9,5,3,1,7,8,33};
		//int[] array = new int[10];
		
		//generateRandomArray(array);
		
		heapsort(array);
		printArray(array);		
	}

	static void heapsort(int[] array){
		int n = array.length;
				
		for(int i= n / 2 - 1; i>=0; i--){
			heapify(array, n, i);
		}
		
		for(int i = n-1; i>=0; i--){
			swap(array, 0, i);
			heapify(array, i, 0);
		}
	}
	
	static void heapify(int[] array, int n, int i){
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l<n && array[l] > array[largest]){
			largest = l;
		}
		
		if(r<n && array[r] > array[largest]){
			largest = r;
		}
		
		if(largest != i){
			swap(array, i , largest);
			heapify(array, n, largest);
		}
	}
	
	static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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
	
	static Random r = new Random(0);
	static void generateRandomArray(int[] array){
        for(int i = 0; i <  array.length; i++) {
        	array[i] = r.nextInt(100);
        	
            System.out.print(array[i] + ", ");
        }
      
	}
	
}

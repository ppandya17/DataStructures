package sorting;

public class SelectionSort {

	static void selectionSort(int[] array){
		for(int i = array.length-1; i > 0; i--){
			int pos = 0;
			for(int j = 1; j <= i ; j++){
				if(array[j] > array[pos]){
					pos = j;
				}
				int temp = array[i];
				array[i] = array[pos];
				array[pos] = temp;
			}
		}
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
	
	static void generateRandomArray(int[] array){
        for(int i = 0; i <  array.length; i++) {
        	array[i] = (int) (Math.random() * 1000);
            System.out.print(array[i] + ", ");
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int array[] = new int[]{10,65,3,98,1,5,7,3,4,9,2,8,1,4,9,5,3,1,7,8,33};
		
		int[] array = new int[1000];
		generateRandomArray(array);
		selectionSort(array);
		printArray(array);
		
		
		
	}

}

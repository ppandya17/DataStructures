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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[]{10,5,3,4,9,2};
		selectionSort(array);
		
		for(int i=0; i<array.length; i++){
			if(i > 0){
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
	}

}

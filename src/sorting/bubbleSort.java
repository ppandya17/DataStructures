package sorting;

public class bubbleSort {


	static void bubbleSort(int[] array){
		for(int i=0; i<array.length-1; i++){
			for(int j=0; j< array.length-1-i; j++){
				if(array[j] > array[j+1]){
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;					
				}			

			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = new int[]{10,65,3,98,1,5,7,3,4,9,2,8,1,4,9,5,3,1,7,8,33};
		bubbleSort(array);
		
		for(int i=0; i<array.length; i++){
			if(i > 0){
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
	}

}

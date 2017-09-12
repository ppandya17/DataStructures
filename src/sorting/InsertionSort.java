package sorting;

public class InsertionSort {

	static void insertionSort(int[] array){
		for(int i=1; i < array.length; i++){
			boolean flag = false;
			int temp = array[i];
			for(int j = i-1; j>=0; j--){
				if(array[j] > temp){
					array[j+1] = array[j];
				} else{
					array[j+1] = temp;
					flag = true;
					break;
				}
			}
			if (flag == false){
				array[0]= temp;	
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
		insertionSort(array);
		printArray(array);
		
	}

}

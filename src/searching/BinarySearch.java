package searching;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int searchNumber = 8;
		
		int target = binarySearch(array, searchNumber);
		if(target != -1){
			printResult(true, searchNumber, target);	
		} else {
			printResult(false, searchNumber, target);
		}
		
	}

	static int binarySearch(int[] array, int number){
		
		int left = 0;
		int right = array.length-1;
		if(number < array[left] || number > array[right]){
			printResult(false, number, -1);
			System.exit(0);
		}
		
		while(left <= right){
			int middle = (left + right)/2;
			if(number < array[middle]){
				right = middle-1;
			} else if(number > array[middle]){
				left = middle+1;
			} else	{
				return middle;
			}
		}
		return -1;
	}
	
	static void printResult(boolean result, int number, int position){
		if (result == false){
			System.out.println("Number id not in the array");
		} else {
			System.out.println("Number "+ number +" is at "+position+" position.");
		}
	}
}

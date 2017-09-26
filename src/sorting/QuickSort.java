package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//int array[] = new int[]{10,5,3,4,9,2};
		//int[] array = new int[10];
		
		//generateRandomArray(array);
		
		readFromInputFile();
		
		
		//quickSort(array, 0, array.length-1);
		
		//printArray(array);		
	}
	
	static void readFromInputFile(){
		try
        {
            File inputFile = new File("src/inputTests/hw2a.dat");
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            int noOfTestCases = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < noOfTestCases; i++)
            {
                int arraySize = Integer.parseInt(br.readLine());
            
                String a = br.readLine();
                
                String[] array = a.split(" ");
                int[] myData = new int[arraySize];
                for(int j = 0; j < arraySize; j++)
                {
                    myData[j] = Integer.parseInt(array[j]);
                }
                
                System.out.println();
            
                quickSort(myData,0,arraySize - 1);
                for(int j = 0; j < arraySize; j++)
                {
                    System.out.print(myData[j]+" ");
                }
                System.out.println();
            }
            br.close();
        }
        catch(IOException ex)
        {
            System.out.print(ex.toString());
        }
	
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

package growArrayExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//
// Grow Array
//
//
//Created by PARTH PANDYA on 10/17/17.
//Copyright © 2017 Parth Pandya. All rights reserved.


public class LongList {

	private static int[] data;
	private static int size;
	private int increment;

	public LongList(final int capacity) {
		data = new int[capacity];
		increment = capacity;
	}

	private void ensureCapacity(final int c) {
		if (data.length <= c) {
			final int[] newData = new int[Math.max(data.length + increment, c + 10)];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	public void add_Front(final int start, final int step, final int end) {
		for(int i = start; i<= end; i = i+ step){
			add(i, true);
		}
	}
	
	public void add_End(final int start, final int step, final int end) {
		for(int i = start; i<= end; i = i+ step){
			add(i, false);
		}
	}
	
	private void add(final int value, boolean flag){
		ensureCapacity(size);
		if(flag){
			for (int i = size; i >= 0; i--) {                
			    data[i+1] = data[i];
			}
			data[0] = value;
			size += 1;			
		} else {
			data[size] = value;
			size += 1;	
		}
		
	}

	public void remove_Front(final int number){
		if(number > size){
			System.out.println("Not possible. Array only has "+ size +" variables.");
			return;
		}
		for(int i=number, j = 0; i< data.length; i++, j++){
			data[j] = data[i];
		}
		size -= number;
		for(int i = size; i< data.length; i++){
			data[i] = 0;
		}
	}
	
	public void remove_Back(final int number){
		if(number > size){
			System.out.println("Not possible. Array only has "+ size +" variables.");
			return;
		}
		for(int i = size-1; i >= (size-number); i--){
			data[i] = 0;
		}
		size -= number;
	}
	
	public static void printArray(){
		StringBuilder s = new StringBuilder();
		if(size == 0){
			System.out.println("No element in Array");
			return;
		}
		for(int i = 0; i< size; i++){
			s.append(data[i] + ", ");
		}
		s.setLength(s.length() - 2);
		System.out.println(s.toString());
	}
	
	public static void main(String[] args){
		try {
			LongList list = new LongList(0);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(LongList.class.getResourceAsStream("HW4a.txt"), "UTF-8"));
			
			String line;
			String[] values;
			while ((line = bufferedReader.readLine()) != null) {
				String[] splited = line.split("\\s+");
				switch(splited[0]){
					case "ADD_FRONT":
						values = splited[1].split(":");
						list.add_Front(Integer.parseInt(values[0]) ,Integer.parseInt(values[1]),Integer.parseInt(values[2]));
						break;
					case "ADD_BACK":
						values = splited[1].split(":");
						list.add_End(Integer.parseInt(values[0]) ,Integer.parseInt(values[1]),Integer.parseInt(values[2]));
						break;
					case "REMOVE_FRONT":
						list.remove_Front(Integer.parseInt(splited[1]));
						break;
					case "REMOVE_BACK":
						list.remove_Back(Integer.parseInt(splited[1]));
						break;
					case "OUTPUT":
						printArray();
						break;
				}
					
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

package structure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapLinearProbing {
	
	class DataItem { 
		  private int data; 

		  public DataItem(int d) {
		    data = d;
		  }

		  public int getKey() {
		    return data;
		  }
	}

	private DataItem[] hashArray; 
	private int arraySize;
	private DataItem bufItem; // for deleted items
	private Map<Integer,Integer> hist = new HashMap<Integer,Integer>();
	
	public HashMapLinearProbing(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		bufItem = new DataItem(-1); // deleted item key is -1
	}

	public int hashFunction(int key) {
		return key % arraySize; 
	}

	public void insert(DataItem item){
		int key = item.getKey(); 
		int hashVal = hashFunction(key); // hash the key
    // until empty cell or -1,
		int count = 1;
		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
			count++;
		}
		hashArray[hashVal] = item; // insert item
    
		if(hist.get(count) == null){
			hist.put(count, 1);	
		} else {
			hist.put(count, hist.get(count) + 1);	
		}
    
	}

	public DataItem delete(int key) {
		int hashVal = hashFunction(key); 

		while (hashArray[hashVal] != null) // until empty cell,
		{ 
			if (hashArray[hashVal].getKey() == key) {
				DataItem temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = bufItem; // delete item
				return temp;
			}
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can't find item
	}

	public DataItem find(int key) {
		int hashVal = hashFunction(key); // hash the key

		while (hashArray[hashVal] != null) // until empty cell,
		{ 
			if (hashArray[hashVal].getKey() == key)
				return hashArray[hashVal]; // found, return item
			++hashVal; // go to next cell
			hashVal %= arraySize; // wraparound if necessary
		}
		return null; // can't find item
	}

	public static void main(String[] args) throws IOException {
		DataItem aDataItem;
		int aKey, size, initSize, keysPerCell;

		size = 150;
		initSize = 100;
		keysPerCell = 10;
		HashMapLinearProbing theHashTable = new HashMapLinearProbing(size);

		for (int j = 0; j <= initSize; j++){
			aKey = (int) (java.lang.Math.random() * keysPerCell * size);
      //	aKey = j;
			aDataItem = theHashTable.new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}	
    

		//theHashTable.displayTable();
		theHashTable.displayHist();
	}
	
	public void displayTable() {
		System.out.println("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.println(hashArray[j].getKey() + " ");
			else
				System.out.println("#");
		}
		System.out.println("");
	}
  
	public void displayHist(){
		System.out.println("Histogram: ");
		int count = 0;
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] == null)
				count++;
		} 
		hist.put(0, count);
		for (Entry<Integer, Integer> entry : hist.entrySet()) {
			String key = entry.getKey().toString();
		    Integer value = entry.getValue();
		    System.out.println(key + "\t " + value);
		}
	}
}
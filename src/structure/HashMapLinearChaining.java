package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

// Class to represent entire hash table
public class HashMapLinearChaining<K, V> {

	// A node of chains
	class HashNode<K, V> {
		K key;
		V value;

		HashNode<K, V> next;

		public HashNode(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	private ArrayList<HashNode<K, V>> bucketArray;

	private int numBuckets;
	
	private int size;
	
	public HashMapLinearChaining()	{
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		for (int i = 0; i < numBuckets; i++)
			bucketArray.add(null);
		}

		public int size() { 
			return size; 
		}
		
		public boolean isEmpty() { 
			return size() == 0; 
		}

		// This implements hash function to find index for a key
		private int getBucketIndex(K key) {
			double hashCode = hashCode(key);
			int index = (int) (hashCode % numBuckets);
			return index;
		}
		
		public double hashCode(K key){
			double hash = 7;
			for (int i = 0; i < key.toString().length(); i++) {
			    hash = hash*31 + key.toString().charAt(i);
			}
			return hash;
		}
		

		// Method to remove a given key
		public V remove(K key) {
			// Apply hash function to find index for given key
			int bucketIndex = getBucketIndex(key);

			// Get head of chain
			HashNode<K, V> head = bucketArray.get(bucketIndex);

			// Search for key in its chain
			HashNode<K, V> prev = null;
			while (head != null)
			{
				// If Key found
				if (head.key.equals(key))
					break;

				// Else keep moving in chain
				prev = head;
				head = head.next;
			}

			// If key was not there
			if (head == null)
				return null;

			// Reduce size
			size--;

			// Remove key
			if (prev != null)
				prev.next = head.next;
			else
				bucketArray.set(bucketIndex, head.next);

			return head.value;
		}

		// Returns value for a key
		public V get(K key) {
			// Find head of chain for given key
			int bucketIndex = getBucketIndex(key);
			HashNode<K, V> head = bucketArray.get(bucketIndex);

			// Search key in chain
			while (head != null)
			{
				if (head.key.equals(key))
					return head.value;
				head = head.next;
			}

			// If key not found
			return null;
		}

		// Adds a key value pair to hash
		public void add(K key, V value) {
			// Find head of chain for given key
			int bucketIndex = getBucketIndex(key);
			HashNode<K, V> head = bucketArray.get(bucketIndex);

			// Check if key is already present
			while (head != null)
			{
				if (head.key.equals(key))
				{
					head.value = value;
					return;
				}
				head = head.next;
			}

			// Insert key in chain
			size++;
			head = bucketArray.get(bucketIndex);
			HashNode<K, V> newNode = new HashNode<K, V>(key, value);
			newNode.next = head;
			bucketArray.set(bucketIndex, newNode);

			// If load factor goes beyond threshold, then
			// double hash table size
			if ((1.0*size)/numBuckets >= 0.7)
			{
				ArrayList<HashNode<K, V>> temp = bucketArray;
				bucketArray = new ArrayList<>();
				numBuckets = 2 * numBuckets;
				size = 0;
				for (int i = 0; i < numBuckets; i++)
					bucketArray.add(null);

				for (HashNode<K, V> headNode : temp)
				{
					while (headNode != null)
					{
						add(headNode.key, headNode.value);
						headNode = headNode.next;
					}
				}
			}
		}
		
		public void printHist(){
			System.out.println("Counts in Every Bucket");
			HashNode<K, V> head;
			int count = 0;
			for(int i =0; i< this.numBuckets; i++){
				count = 0;
				head = bucketArray.get(i);
				if(head == null){
					continue;
				}
				while(head != null){
					count++;
					head = head.next;
				}
				System.out.println(i +"\t"+ count);
			}
			
		}
		

		// Driver method to test Map class
		public static void main(String[] args) throws Exception {
			HashMapLinearChaining<String, Integer>map = new HashMapLinearChaining<>();
//			map.add("this",1 );
//			map.add("coder",2 );
//			map.add("this",4 );
//			map.add("hi",5 );
			System.out.println(map.size());
//			System.out.println(map.remove("this"));
//			System.out.println(map.remove("this"));
			System.out.println(map.isEmpty());
			
			
	    	try{
	    		int k = 0;
	    		StreamTokenizer tokenizer= new StreamTokenizer(new BufferedReader(new InputStreamReader(DoubleLinkedList.class.getResourceAsStream("dict.txt"), "UTF-8")));
	    		tokenizer.lowerCaseMode(true); 
	    		while(tokenizer.nextToken()!=tokenizer.TT_EOF)  {
	    			k++;
	    			if(tokenizer.ttype==tokenizer.TT_WORD) {
	    				String word=tokenizer.sval; // get the next word
	    				map.add(word, k);
	    			}
	    		}
	    		} catch(IOException e) {
	    			System.out.println(e);             
	    			System.exit(1);                    
	    		}	
	    	System.out.println(map.size());
			map.printHist();
	    	
	    	Scanner sc = new Scanner( new BufferedReader(new InputStreamReader(DoubleLinkedList.class.getResourceAsStream("hw8.dat"), "UTF-8")));
	    	sc.nextLine();
	    	while(sc.hasNext()){
	    		String lookup = sc.nextLine().trim().replaceAll("\\s+","");
	    		if(map.get(lookup) != null){
	    			System.out.println("True");
	    		} else {
	    			System.out.println("False");
	    		}
	    	}
	    	
		}
	}
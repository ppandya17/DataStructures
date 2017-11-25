// AUTHOR: Parth Pandya
// ref: http://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java


package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

// Class to represent entire hash table
public class HashMapLinearChaining<K, V> {
	
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
			int bucketIndex = getBucketIndex(key);

			HashNode<K, V> head = bucketArray.get(bucketIndex);

			HashNode<K, V> prev = null;
			while (head != null)
			{
				if (head.key.equals(key)){
					break;
				}
				prev = head;
				head = head.next;
			}

			// If key was not there
			if (head == null)
				return null;
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
			int bucketIndex = getBucketIndex(key);
			HashNode<K, V> head = bucketArray.get(bucketIndex);

			while (head != null)
			{
				if (head.key.equals(key))
					return head.value;
				head = head.next;
			}
			return null;
		}

		// Adds a key value pair to hash
		public void add(K key, V value) {
			int bucketIndex = getBucketIndex(key);
			HashNode<K, V> head = bucketArray.get(bucketIndex);
			while (head != null)
			{
				if (head.key.equals(key))
				{
					head.value = value;
					return;
				}
				head = head.next;
			}
			size++;
			head = bucketArray.get(bucketIndex);
			HashNode<K, V> newNode = new HashNode<K, V>(key, value);
			newNode.next = head;
			bucketArray.set(bucketIndex, newNode);

			// If load factor goes beyond threshold, then double hash table size
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
		
		public static void main(String[] args) throws Exception {
			HashMapLinearChaining<String, Integer>map = new HashMapLinearChaining<>();

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
	    	//System.out.println(map.size());
	    	System.out.println("Histogram according to the buckets");
			map.printHist();
	    	System.out.println("");
	    	System.out.println("check values frlom file");
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
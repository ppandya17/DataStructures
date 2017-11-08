package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DoubleLinkedList {
	
	Node head;
	Node tail;
	int size;

	class Node{
		int data;
		Node nextNode;
		Node prevNode;
		
		public Node(int data, Node nextNode, Node prevNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
			this.prevNode = prevNode;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DoubleLinkedList list = new DoubleLinkedList();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(DoubleLinkedList.class.getResourceAsStream("HW4b.txt"), "UTF-8"));
			
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
						list.removeStart(Integer.parseInt(splited[1]));
						break;
					case "REMOVE_BACK":
						list.removeEnd(Integer.parseInt(splited[1]));
						break;
					case "OUTPUT":
						list.printList();
						break;
				}
					
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DoubleLinkedList() {
		super();
		this.head = new Node(0, null, null);
		this.tail = new Node(0, null, null);;
		this.size = 0;
	}
	
	public void add_Front(final int start, final int step, final int end) {
		for(int i = start; i<= end; i = i+ step){
			addStart(i);
		}
	}
	
	public void add_End(final int start, final int step, final int end) {
		for(int i = start; i<= end; i = i+ step){
			addEnd(i);
		}
	}
	
	public void addStart(int data){
		Node newNode = new Node(data, null, null);
		if(head.nextNode == null){
			head.nextNode = newNode;
			newNode.prevNode = head;
			newNode.nextNode = tail;
			tail.prevNode = newNode;
		} else{
			newNode.nextNode = head.nextNode;
			newNode.prevNode = head;
			head.nextNode = newNode;
		}
		size +=1;
	}
	
	public void addEnd(int data){
		Node newNode = new Node(data, null, null);
		
		if(tail.prevNode == null){
			head.nextNode = newNode;
			newNode.prevNode = head;
			newNode.nextNode = tail;
			tail.prevNode = newNode;
		} else {
			newNode.prevNode = tail.prevNode;
			tail.prevNode.nextNode = newNode;
			newNode.nextNode = tail;
			tail.prevNode = newNode;
		}
		size +=1;
		
	}
		

	public void removeStart(final int number){
		if(number > size || head.nextNode == null){
			System.out.println("Not possible. Array only has "+ size +" variables.");
			return;
		} else {
			Node temp = head.nextNode;
			for(int i =0; i<number;i++){
				temp = temp.nextNode;
			}
			head.nextNode = temp;
			temp.prevNode = head;
			size -= number;
		}
		
	}
	
	public void removeEnd(final int number){
		if(head.nextNode == null || number > size ){
			System.out.println("Not possible. Array only has "+ size +" variables.");
		} else {
			Node temp = tail.prevNode;
			for(int i =0; i<number;i++){
				temp = temp.prevNode;
			}
			temp.nextNode = tail;
			tail.prevNode = temp;
			size -= number;
		}
	}
	
	public void printList(){
		if(head == null){
			System.out.println("List is Empty");
		} else {
			StringBuilder s = new StringBuilder();
			Node lastNode = head.nextNode;
			for(int i =0; i<size;i++){
				s.append(lastNode.data + ", ");
				lastNode = lastNode.nextNode;
			}
			s.setLength(s.length() - 2);
			System.out.println(s.toString());
		}
	}
}

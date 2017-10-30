package structure;

public class SingleLinkedList {

	Node head;
	int size;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleLinkedList list = new SingleLinkedList();
		list.printList();
		list.addStart(1);
		list.printList();
		list.addEnd(2);
		list.printList();
		list.addStart(3);
		list.printList();
		list.addEnd(4);
		list.printList();
		list.addStart(5);
		list.printList();
		list.addEnd(6);
		list.printList();
		list.addStart(7);
		list.printList();
		list.addEnd(8);
		list.printList();
		list.removeStart();
		list.printList();
		list.removeEnd();
		list.printList();
		list.addAtPosition(10, 3);
		list.printList();
		list.removePosition(3);
		list.printList();
	}
	
	public SingleLinkedList() {
		super();
		this.head = new Node(0, null);
		size = 0;
	}

	public void addStart(int data){
		Node newNode = new Node(data, null);
		if(head.nextNode == null){
			head.nextNode = newNode;
		} else{
			newNode.nextNode = head.nextNode;
			head.nextNode = newNode;
		}
		size +=1;
	}
	
	public void addEnd(int data){
		Node newNode = new Node(data, null);
		Node lastNode = null;
		if(head.nextNode == null){
			head.nextNode = newNode;
		} else {
			lastNode = head;
			for(int i=0; i<size; i++){
				lastNode = lastNode.nextNode;
			}
			lastNode.nextNode = newNode;
		}
		size +=1;
		
	}
	
	public void addAtPosition(int data, int position){
		
		if(head.nextNode == null){
			addStart(data);
		} else {
			if(position > size){
				addEnd(data);
			} else {
				Node newNode = new Node(data, null);
				Node positionNode = head.nextNode;
				for(int i = 0; i< size; i++){
					if(i == position - 2){
						newNode.nextNode = positionNode.nextNode;
						positionNode.nextNode = newNode;
						size +=1;
						break;
					}
					positionNode = positionNode.nextNode;
					
				}	
			}
			
		}
	}
	
	public void removeStart(){
		if(head.nextNode == null){
			System.out.println("List is Empty");
		} else {
			head.nextNode = head.nextNode.nextNode;
			size = size -1;
		}
		
	}
	
	public void removeEnd(){
		Node lastNode = null;
		if(head.nextNode == null){
			System.out.println("List is Empty");
		} else {
			lastNode = head.nextNode;
			for(int i =0; i<size; i++){
				if(i == size-1){
					lastNode.nextNode = null;
				} else {
					lastNode = lastNode.nextNode;	
				}
			}
			size = size -1;
		}
	}
	
	public void removePosition(int position){
		if(head.nextNode == null){
			System.out.println("List is Empty");
		} else {
			if(position > size){
				System.out.println("List is smaller than said position");
			} else {
				Node positionNode = head.nextNode;
				for(int i = 0; i< size; i++){
					if(i == position - 2){
						positionNode.nextNode = positionNode.nextNode.nextNode;
						size -=1;
						break;
					}
					positionNode = positionNode.nextNode;
				}	
			}
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
			System.out.println(s.toString());
		}
		
	}
	
	class Node{
		int data;
		Node nextNode;
		
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
		public Node(int data, Node nextNode) {
			super();
			this.data = data;
			this.nextNode = nextNode;
		}
		
	}
}

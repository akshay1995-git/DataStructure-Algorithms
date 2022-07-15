package searchInList;

//import DoublyLinkedList.DoublyNode;

public class DoublyNode {
	DoublyNode head;
	DoublyNode tail;
	public int value;
	public DoublyNode next;
	public DoublyNode prev;
	int size;

	public DoublyNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insertMethod(int data, int location) {
		DoublyNode newNode = new DoublyNode();
		if (head == null) {
			newNode.value = data;
			newNode.prev = null;
			newNode.next = null;
			head = newNode;
			tail = newNode;
		} else if (location == 0) {
			newNode.value = data;
			newNode.next = head;
			head.prev = newNode;
			newNode.prev = null;
			head = newNode;
		} else if (location >= size) {
			newNode.value = data;
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;

		} else {
			int i = 0;
			DoublyNode current = head;
			while (i < location - 1) {
				current = current.next;
				i++;
			}
			newNode.prev = current;
			newNode.next = current.next;
			current.next = newNode;
			newNode.value = data;
			newNode.next.prev = newNode;
		}
		size++;
	}

	// Traverse DLL
	public void forwardTraverse() {
		if (head != null) {
			DoublyNode tempNode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.value);
				if (i != size - 1) {
					System.out.print(" ==> ");
				}
				tempNode = tempNode.next;
			}
		} else {
			System.out.println("The DLL does not exist!");
		}
		System.out.println("\n");
	}

	public int getAllNodeCount(DoublyNode node) {
		 int counter = 0;  
	        //Node current will point to head  
	        DoublyNode current = node;  
	  
	        while(current != null) {  
	            //Increment the counter by 1 for each node  
	            counter++;  
	            current = current.next;  
	        }  
	        return counter;  

	}
	
	public int countNodes() {  
        int counter = 0;  
        //Node current will point to head  
        DoublyNode current = head;  
  
        while(current != null) {  
            //Increment the counter by 1 for each node  
            counter++;  
            current = current.next;  
        }  
        return counter;  
    }  
	
//	public static void main(String[] args) {
//		DoublyNode temp = new DoublyNode();
//		temp.insertMethod(10, 0);
//		temp.insertMethod(20, 1);
//		temp.insertMethod(30, 2);
//		temp.insertMethod(40, 3);
//		temp.insertMethod(50, 4);
//		
//		System.out.println("Node count :"+temp.countNodes());
//		
//	}
}

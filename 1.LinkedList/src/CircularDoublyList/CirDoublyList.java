package CircularDoublyList;

public class CirDoublyList {
	DoublyNode head, tail;
	int size;

//Insertion Method
	DoublyNode createCDLL(int nodeValue) {
		head = new DoublyNode();
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		head = newNode;
		tail = newNode;
		newNode.next = newNode;
		newNode.prev = newNode;
		size = 1;
		return head;
	}

	// Insertion Method
	void insertNode(int nodeValue, int location) {
		DoublyNode newNode = new DoublyNode();
		newNode.value = nodeValue;
		//list is empty then create first node
		if (head == null) {
			createCDLL(nodeValue);
			return;
		}
		//location=0 then node added from front
		else if (location == 0) {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.next = newNode;
			head = newNode;
		}
		//location >siznode added from end
		else if (location >= size) {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.next = newNode;
			tail = newNode;
		} 
		//random insert 
		else {
			DoublyNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			newNode.prev = tempNode;
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			newNode.next.prev = newNode;
		}
		size++;
	}

//Traverse CDLL
	void traverseForward() {
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
			System.out.println("The CDLL does not exist.");
		}
		System.out.println();
	}

// Reverse Traversal
	void reverseTraversal() {
		if (head != null) {
			DoublyNode tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.value);
				if (i != size - 1) {
					System.out.print(" <== ");
				}
				tempNode = tempNode.prev;
			}
			System.out.println("\n");

		} else {
			System.out.println("The CDLL does not exist!");
		}
	}
	// Deletion Method
	  public void deleteNode(int location) {
	    if (head == null) {
	      System.out.println("The CDLL does not exist!");
	      return;
	    } else if (location == 0) {
	      if (size == 1) {
	        head.prev = null;
	        head.next = null;
	        head = tail = null;
	        size--;
	        return;
	      } else {
	        head = head.next;
	        head.prev = tail;
	        tail.next = head;
	        size--;
	      }
	    } else if (location >= size) {
	      if (size == 1) {
	        head.prev = null;
	        head.next = null;
	        head = tail = null;
	        size--;
	        return;
	      } else {
	        tail = tail.prev;
	        tail.next = head;
	        head.prev = tail;
	        size--;
	      }
	    } else {
	      DoublyNode tempNode = head;
	      for (int i = 0; i < location -1; i++){
	        tempNode = tempNode.next;
	      }
	      tempNode.next = tempNode.next.next;
	      tempNode.next.prev = tempNode;
	      size--;
	    }
	  }


// Search for a Node
	boolean searchNode(int nodeValue) {
		if (head != null) {
			DoublyNode tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.value == nodeValue) {
					System.out.println("The node is found at location: " + i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.println("Node not found! ");
		return false;
	}

	public static void main(String[] args) {
		CirDoublyList node = new CirDoublyList();
		node.insertNode(40, 3);
		node.insertNode(30, 2);
		node.insertNode(20, 1);
		node.insertNode(10, 0);

		node.traverseForward();
		node.reverseTraversal();
		
		node.deleteNode(1);
		node.traverseForward();
		
	}
}

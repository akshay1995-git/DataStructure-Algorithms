package DoublyLinkedList;

//import DoublyLinkedList.DoublyNode;

public class DoublyList {
	DoublyNode head;
	DoublyNode tail;
	int size;

	public void insertMethod(int data, int location) {
		DoublyNode newNode = new DoublyNode();
		//if list is Empty then newnode is first node set head and tail to that newnode
		if (head == null) {
			newNode.value = data;
			newNode.prev = null;
			newNode.next = null;
			head = newNode;
			tail = newNode;
		}
		//if location is 0 then node added from front
		else if (location == 0) {
			newNode.value = data;
			newNode.next = head;
			head.prev = newNode;
			newNode.prev = null;
			head = newNode;
		} 
		//if location is greater than size then node added from rear
		else if (location >= size) {
			newNode.value = data;
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;

		}
		//if location is between 0 to size then insert at that position
		else {
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

	// Reverse Traverse
	public void reverseTraverse() {
		if (head != null) {
			DoublyNode tempNode = tail;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.value);
				if (i != size - 1) {
					System.out.print(" <== ");
				}
				tempNode = tempNode.prev;
			}
		} else {
			System.out.println("The DLL does not exist!");
		}
		System.out.println("\n");
	}

	// Search Node
	public boolean searchNode(int nodeValue) {
		if (head != null) {
			DoublyNode tempNode = head;
			for (int i = 0; i < size; i++) {
				if (tempNode.value == nodeValue) {
					System.out.println("The Node is found at location: " + i);
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		System.out.print("Node not found!");
		return false;
	}
//delete is same as that insert 
	public void deleteMethod(int location) {
		if (head == null) {
			System.out.println("The DLL does not exist!");
			return;
		} 
		//delete from front
		else if (location == 0) {
			if (size == 1) {
				head = null;
				tail = null;
				size--;
				return;
			} else {
				head = head.next;
				head.prev = null;
				size--;
			}
		}
		//delete from end
		else if(location>=size) {
			if (size == 1) {
				head = null;
				tail = null;
				size--;
				return;
			} else {
				tail=tail.prev;
				tail.next=null;
				size--;
			}
		}
		else {//delete at random position
			DoublyNode current=head;
			for(int i=0;i<location-1;i++) {
				current=current.next;
			}
			current.next=current.next.next;
			current.next.prev=current;
			size--;
		}
	}

	public static void main(String[] args) {
		DoublyList node = new DoublyList();
		node.insertMethod(10, 0);
		node.insertMethod(2, 1);
		node.insertMethod(20, 4);
		node.insertMethod(13, 2);
		node.insertMethod(33,3 );
		node.insertMethod(4, 7);/////insertion
		node.forwardTraverse();//forward traversing
		node.reverseTraverse();// reverse traversing
		node.deleteMethod(2);//random delete
		node.forwardTraverse();
		node.deleteMethod(0);//first delete
		node.forwardTraverse();
		node.deleteMethod(7);//last delete
		node.forwardTraverse();
		node.searchNode(20);
		node.searchNode(45);
	}
}

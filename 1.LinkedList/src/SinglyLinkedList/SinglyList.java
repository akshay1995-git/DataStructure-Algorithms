package SinglyLinkedList;

public class SinglyList {
	SinglyList head,tail,next;
	int data;
//	SinglyList(int data){
//		this.head=null;
//		this.tail=null;
//		this.data=data;
//	}
	public SinglyList() {
		super();
	}
	//Insert Node From Front
	public void addFromFront(int data) {
		SinglyList newNode=new SinglyList();
		if(head==null) {
			newNode.data=data;
			head=newNode;
			
		}
		else {
			newNode.next=head;
			newNode.data=data;
			head=newNode;
		}
	}
	//Insert Node from Rear
	public void addFromRear(int data) {
		SinglyList newNode=new SinglyList();
		if(head==null) {
			newNode.data=data;
			head=newNode;
			
		}
		else {
			SinglyList current=head;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=newNode;
			newNode.data=data;
			newNode.next=null;
			
		}
	}
	//Insert Node at Random Position
	public void randomInsert(int index,int data) {
		SinglyList newNode=new SinglyList();
		if(head==null) {
			newNode.data=data;
			head=newNode;
			
		}
		else {
			SinglyList current=head;
			int i=0;
			while(i<index) {
				current=current.next;
				i++;
			}
			newNode.next=current.next;
			newNode.data=data;
			current.next=newNode;
			System.out.println("Node inserted At index : "+index);
		}
	}
	//Retrieve Element at Index
	public void getElementAtIndex(int index) {
		SinglyList current=head;
		if(head==null) {
			System.out.println("List is Empty !!!");
		}
		else {
			int i=0;
			while(i<index) {
				current=current.next;
				i++;
			}
			System.out.println("Element at index "+index+" : "+current.data);
		}
	}
	//Delete Node From First
	public void deleteFromFirst() {
		System.out.println("head node deleted : "+head.data);
		head=head.next;
	}
	//Delete Node From Rear
	public void deleteFromRear() {
		if(head==null) {
			System.out.println("UnderFlow");
		}
		else {
			SinglyList current=head;
			SinglyList curr=null;
			while(current.next!=null) {
				curr=current;
				current=current.next;
			}
			curr.next=null;
			System.out.println("Last node Deleted !!!");
			
		}
	}
	public void deleteAtIndex(int index) {
		if(head==null) {
			System.out.println("UnderFlow");
		}
		else {
			SinglyList current=head;
			SinglyList curr=null;
			int i=0;
			while(i<=index) {
				curr=current;
				current=current.next;
				i++;
			}
			curr.next=current.next;
			System.out.println("Node Deleted at position " +index);
			
		}
	}
	//Get The Count of Node
	public void getAllNodeCount() {
		if(head==null) {
			System.out.println("Node Count is ZERO !!! ");
		}
		else {
			SinglyList current=head;
			int count=0;
			while(current!=null) {
				count++;
				current=current.next;
			}
			System.out.println("Node Count is  : "+count);
		}
	}
	//Method to sort Linked List
	public void sortedList() {
		SinglyList current = head, index = null;
		 
        int temp;
		if(head==null) {
			System.out.println("List is Empty can not be sorted !!!");
		}
		else {
			System.out.println("Sorted Linked list : ");
			 while (current != null) {
	                // Node index will point to node next to
	                // current
	                index = current.next;
	 
	                while (index != null) {
	                    // If current node's data is greater
	                    // than index's node data, swap the data
	                    // between them
	                    if (current.data > index.data) {
	                        temp = current.data;
	                        current.data = index.data;
	                        index.data = temp;
	                    }
	 
	                    index = index.next;
	                }
	                current = current.next;
	            }
		}
	}
	//Print All Node 
	public void printAllElement() {
		SinglyList current=new SinglyList();
		current=head;

		if(current==null) {
			System.out.println("Nothing to Print");
		}
		else {
			System.out.println("Print All Element : ");
			while(current!=null) {
				System.out.println(current.data);
				current=current.next;
				
			}
		
		}
		
	}

	public static void main(String[] args) {
		SinglyList node=new SinglyList();
		node.addFromFront(10);
		node.addFromFront(20);
		node.addFromFront(30);
	    node.printAllElement();
	    node.randomInsert(1, 5);
	    node.printAllElement();
	    node.sortedList();
	    node.printAllElement();
	    node.addFromRear(5);
	    node.addFromRear(2);
	    node.printAllElement();
	    node.deleteFromFirst();
	    node.printAllElement();
	    node.deleteFromRear();
	    node.printAllElement();
	    node.deleteAtIndex(2);
	    node.printAllElement();
	    node.getElementAtIndex(2);
	    node.getAllNodeCount();
	}

}

package searchInList;

public class SinglyList {
	SinglyList head,tail,next;
	int data;

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

	//Get The Count of Node
	public int getAllNodeCount() {
		if(head==null) {
			return -1;
		}
		else {
			SinglyList current=head;
			int count=0;
			while(current!=null) {
				count++;
				current=current.next;
			}
			return count;
		}
	}

	
}

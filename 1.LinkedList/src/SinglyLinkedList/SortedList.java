package SinglyLinkedList;

public class SortedList {
	SortedList head,tail,next;
	int data;

	public SortedList() {
		super();
	}
	public void addViaSort(int data) {
		SortedList newNode=new SortedList();
		if(head==null) {
			head=newNode;
			newNode.data=data;
			tail=newNode;
		}
		else {
			if(head.data>=data) {
				newNode.next=head;
				newNode.data=data;
				head=newNode;
			}
			else {
				SortedList curr=head;
				while(curr.next!=null && curr.next.data<data) {//10<30,20<30
					curr=curr.next;	    //10<25,10<25,30<25
					//System.out.println(curr);
				}
					curr.next=newNode;
					newNode.data=data;
					newNode.next=curr.next.next;	
			}
		}
	}
	
	public void printAllElement() {
		SortedList current=new SortedList();
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
		SortedList node=new SortedList();
				node.addViaSort(10);
		        node.addViaSort(5);
		        node.addViaSort(15);
		        node.addViaSort(20);
		       node.addViaSort(17);
		       node.addViaSort(18);
           node.printAllElement();

	}

}

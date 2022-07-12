package stackList;

public class StackList {
 Stack head;
// int data;
 
 public void push(int data) {
	 Stack node=new Stack();
	 if(head==null) {
		 node.value=data;
		 head=node;
		 System.out.println(node.value+" pushed succesfully .");
	 }
	 else {
		 node.next=head;
		 node.value=data;
		 head=node;
		 System.out.println(node.value+" pushed succesfully .");
	 }
 }
 
public void pop() {
	if(head==null) {
		System.out.println("UNDERFLOW !!! Stack is Empty .");
	}
	else {
		System.out.println(head.value+" popped out .");
		head=head.next;
	}
}
public void peek() {
	if(head==null) {
		System.out.println(" Stack is Empty .");
	}
	else {
		System.out.println(head.value+" is peek Element .");
		
	}

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackList obj=new StackList();
		obj.pop();
		obj.push(10);
		obj.push(20);
		obj.peek();
		obj.push(30);
		obj.pop();
		obj.peek();

	}

}

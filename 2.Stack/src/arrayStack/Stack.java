package arrayStack;

public class Stack {

	// int size=-1;
	int[] array;
	int top;

	public Stack(int size) {
		super();
		this.array = new int[size];
		this.top = -1;
	}
  
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (top == array.length - 1) {
			return true;
		} else {
			return false;
		}

	}
	public void push(int data) {
		if(isFull()) {
			System.out.println("OVERFLOW !!! Can not push new element .");
		}
		else {
			array[++top]=data;
			System.out.println(array[top]+" pushed succesfully");
		}
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("UNDERFLOW !!! can not pop element .");
		}
		else {
			System.out.println(array[top]+" popped succesfully");
			top--;
		}
	}
	public void peek() {
		if(isEmpty()) {
			System.out.println("Stack is Empty !!!");
		}
		else {
			System.out.println("Peek Element "+array[top]);
		}
	}
	public static void main(String[] args) {
		Stack stack=new Stack(4);
		stack.pop();
        stack.push(10);
        stack.push(20);
        stack.peek();
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.peek();
        stack.pop();
        stack.peek();
	}
}

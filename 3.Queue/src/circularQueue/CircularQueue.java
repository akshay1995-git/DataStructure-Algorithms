package circularQueue;

public class CircularQueue {
	int []array;
	int front,rear;
	int size;
	

	public CircularQueue(int size) {
		super();
		this.size = size;
		this.front=-1;
		this.rear=-1;
		array=new int[size];
	}
	public boolean isFull() {
		if(rear==size-1 && front==0) {
			return true;
		}
		else if(rear+1==front) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if(front==-1&& rear==-1) {
			return true;
		}
		return false;
	}
	
	public void enqueue(int data) {
		if(isFull()) {
			System.out.println("OVERFLOW // can not add new Element");
		}
		else if(isEmpty()) {
			front =0;
		//	rear=0;
			array[++rear]=data;
			System.out.println(array[rear]+" inserted");
		}
		else {
			array[++rear]=data;
			System.out.println(array[rear]+" inserted");

		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("UNDERFLOW // queue is empty .");
			return -1;
		}
		else  {
			int value=array[front];
			//System.out.println(array[front++]+" removed");
			//return value;
			if(front ==rear) {
				front =-1;
				rear=-1;
			}
			else if(front+1==size) {
				front=0;
			}
			else {
				front++;
			}
			return value;
			}
		
	}
	public static void main(String[] args) {
		CircularQueue node=new CircularQueue(3);
		node.dequeue();
		node.enqueue(30);
		node.enqueue(10);
		System.out.println(node.dequeue()+" removed");
		node.enqueue(20);

		System.out.println(node.dequeue()+" removed");
		System.out.println(node.dequeue()+" removed");
		System.out.println(node.dequeue()+" removed");

node.enqueue(10);

	}

}
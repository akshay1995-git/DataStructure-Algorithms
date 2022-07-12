package arrayQueue;

public class Queue {

	int size, front, rear;
	int array[];

	public Queue(int size) {
		super();
		array = new int[size];
		front = -1;
		rear = -1;
	}
	 // IsFull
	  public boolean isFull() {
	    if (rear == array.length-1) {
	      return true;
	    } else {
	      return false;
	    }
	  }

	  // isEmpty
	  public boolean isEmpty() {
	    if ((front == -1) || (front == array.length)) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	public void enqueue(int data) {
		if(isFull()) {
			System.out.println("OVERFLOW !!! can not insert new element .");
		}
		else if(isEmpty()){
			array[++rear]=data;
		System.out.println(array[rear] +" inserted successfully .");
		front++;
		}
		else {
			array[++rear]=data;
			System.out.println(array[rear] +" inserted successfully .");
		}
	}
	
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("UNDERFLOW !!! queue is empty .");
		}
		else {
			System.out.println(array[front]+"removed successfully");
			front++;
		}
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println(" Queue is empty .");
		}
		else {
			System.out.println(array[front]+" peek element");
			
		}
	}
	 public void deleteQueue() {
		    array = null;
		    System.out.println("The Queue is successfully deleted!");
		  }

	public static void main(String[] args) {
		Queue queue=new Queue(4);
		queue.dequeue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.peek();
		queue.enqueue(40);
		queue.dequeue();
		queue.peek();
		
	}

}

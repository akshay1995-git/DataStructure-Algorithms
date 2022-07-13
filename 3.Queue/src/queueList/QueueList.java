package queueList;

public class QueueList {
	Queue head, front, rear;

	public void enqueue(int data) {
		Queue node = new Queue();
		if (head == null) {
			front = node;
			rear = node;
			head = node;
			node.value = data;
			System.out.println(node.value + " inserted in Queue .");
		} else if (front == head) {
			node.value = data;
			head.next = node;
			rear = node;
			head = node;
			System.out.println(node.value + " inserted in Queue .");

		} else {
			rear.next = node;
			rear = node;
			head = node;
			node.value = data;
			System.out.println(node.value + " inserted in Queue .");

		}
	}

	public void dequeue() {
		if (head == null) {
			System.out.println("UNDERFLOW !!! queue is Empty .");
		} else {
			System.out.println(front.value + " removed in Queue .");
			front=front.next;
		}
	}

	public static void main(String[] args) {
		QueueList obj = new QueueList();
		obj.dequeue();
		obj.enqueue(30);
		obj.enqueue(20);
		obj.enqueue(10);
		System.out.println(obj.front.value);//front value before dequeue 30
		obj.dequeue();
		System.out.println(obj.front.value);//front value after deuque 30

	}
}

package CircularSinglyList;

import java.util.Scanner;

public class CircularList implements ICirSinglyList {
	CircularList head, next;
	int data;

	public CircularList() {
		super();

	}

	@Override
	public void beginsert(int data) {
		// TODO Auto-generated method stub
		CircularList newNode = new CircularList();
		if (head == null) {
			head = newNode;
			newNode.data = data;
			newNode.next = head;
			System.out.println(data + " data inserted from beginning");
		} else {
			newNode.next = head;
			head.next = newNode;
			newNode.data = data;
			head = newNode;
			System.out.println(data + " data inserted from beginning");

		}

	}

	@Override
	public void lastinsert(int data) {
		// TODO Auto-generated method stub
		CircularList newNode = new CircularList();
		if (head == null) {
			head = newNode;
			newNode.data = data;
			newNode.next = head;
			System.out.println(data + " data inserted from beginning");
		} else {
			CircularList current = head;
			while (current.next != head) {
				current = current.next;
			}
			current.next = newNode;
			newNode.next = head;//connect last node to first node
			newNode.data = data;

		}

	}

	@Override
	public void randominsert(int location, int data) {
		CircularList newNode = new CircularList();
		if (head == null) {
			newNode.data = data;
			head = newNode;
		} else {
			CircularList current = head;
			int i = 0;
			while (i < location - 1) {
				current = current.next;
				i++;
			}
			newNode.next = current.next;
			newNode.data = data;
			current.next = newNode;
		}
	}

	@Override
	public void begin_delete() {
		if (head != null) {
			head = head.next;
		} else {
			System.out.println("List is Empty !!!");
		}

	}

	@Override
	public void last_delete() {
		if (head != null) {
			CircularList current = head, previous = null;
			while (current.next != head) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;//connect head to previous of current
			current.next = head;
		} else {
			System.out.println("List is Empty !!!");
		}
	}

	@Override
	public void random_delete(int location) {
		if(head==null) {
			System.out.println("Nothing to delete in list");
		}
		else {
			CircularList current=head,previous=null;
			int i=0;
			while(i<location) {
				previous=current;
				current=current.next;
				i++;
			}
			previous.next=current.next;
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("Nothing to print : ");
		} else {
			System.out.println("Print all node Data : ");
			CircularList current = head;
			while (current.next != head) {
				System.out.println(current.data);
				current = current.next;
			}
			// System.out.println(current.data);
		}
	}

	@Override
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  element to find it present or not ???");
		CircularList current = head;

		int element = sc.nextInt();
		while (current.next != head) {
			if (current.data == element) {
				System.out.println("Element Present ");
				break;
			} else {
				System.out.println("Element is not Present ");
				current = current.next;
				continue;
			}

		}
		sc.close();
	}

	public static void main(String[] args) {
		CircularList node = new CircularList();
		node.beginsert(20);
		node.beginsert(30);
		node.lastinsert(15);
		node.randominsert(2, 18);
		node.randominsert(3, 48);
		node.lastinsert(33);
		node.begin_delete();
		node.last_delete();
		node.random_delete(2);
		node.display();
        node.search();

	}
}

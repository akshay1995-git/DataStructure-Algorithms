package searchInList;

import java.util.Scanner;

import searchInList.SinglyList;

public class Linear_Search {
	public static int linear_search(SinglyList current, int element) {
		int index = 0;
		if (current.head == null) {
			System.out.println("List is Empty");
			return -1;
		} else {

			SinglyList temp = current;
			while (temp != null) {
				if (temp.data == element) {
					return index;
				} else {
					index++;

				}

				temp = temp.next;
			}
		}
		return index;

	}

	public static void main(String[] args) {
		SinglyList node = new SinglyList();
		node.addFromFront(10);
		node.addFromFront(20);
		node.addFromFront(30);
		node.addFromRear(40);
		node.addFromRear(50);
		node.getAllNodeCount();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a element to search ");
		int ele = sc.nextInt();
		System.out.print(ele + " Element fount at index : " + linear_search(node, ele));
		sc.close();
	}

}

package searchInList;

import java.util.Scanner;

public class Binary_Search {
	public static DoublyNode getMid(DoublyNode node) {
		
		System.out.println("total count in mid : "+node.getAllNodeCount(node));
		int mid = node.getAllNodeCount(node)/2;
		System.out.println("mid before iteration : " + mid);
		int i=0;
		DoublyNode current = node;
		while (i<mid) {
			current = current.next;
			i++;
		}

		return current;
	}

	public static DoublyNode getTail(DoublyNode node) {
		DoublyNode current = node;
		while (current.next != null) {
			current = current.next;
		}

		return current;
	}

	public static boolean binary_search(DoublyNode node, int value) {

		if (node == null) {
			return false;
		} else {

			DoublyNode left = node.head;
			System.out.println("first element in list : " + left.value);
			DoublyNode right = getTail(node.head);
			System.out.println("last element in list :  " + right.value);
			DoublyNode mid = getMid(node.head);
			System.out.println("mid element in list : " + mid.value);
			int left_index = 0;
			int right_index = node.countNodes();
			System.out.println(right_index);
			int mid_index = (left_index + node.countNodes()) / 2;
			System.out.println(mid_index);
			while (left_index < right_index) {
				if (value == mid.value) {
					return true;
				} else if (value < mid.value) {
					/*
					 * assign mid_index-1 value to right_index and that address element to
					 * right(right=mid.prev)
					 * 
					 */
					right_index = mid_index - 1;
					right = mid.prev;

				} else if (value > mid.value) {
					/*
					 * assign mid_index+1 value to left_index and that address element to left
					 * (left=mid.next)
					 * 
					 */
					left_index = mid_index + 1;
					left = mid.next;

				}
			}
			return false;

		}

	}

	public static void main(String[] args) {
		DoublyNode temp = new DoublyNode();
		temp.insertMethod(10, 0);
		temp.insertMethod(20, 1);
		temp.insertMethod(30, 2);
		temp.insertMethod(40, 3);
		temp.insertMethod(50, 4);
		System.out.println(temp.head.value);
		System.out.println("Node count :" + temp.getAllNodeCount(temp));
		temp.forwardTraverse();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a element to search : ");
		int ele = sc.nextInt();
		//check wheather element is found or not
		if (binary_search(temp, ele) == true) {
			System.out.println("element is found in list");
		} else {
			System.out.println("Element not found ");
		}
		sc.close();
	}

}

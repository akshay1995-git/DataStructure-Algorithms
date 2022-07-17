package heapDS;
/*
  A max-heap is a binary tree such that. -
   the data contained in each node is greater than (or equal to) the data in that node's children.
 */
public class MaxHeap {

	int array[];
	int size;

	public MaxHeap(int size) {
		array = new int[size + 1];
		this.size = 0;
	}

	// Check Tree is Empty
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	// Peek element in Binary Heap
	public int peek() {
		if (isEmpty()) {
			System.out.println("Binary Heap is Empty ");
			return -1;
		} else {
			return array[1];
		}
	}

	// Level-Order Traversal in Binary Heap
	public void levelOrder() {
		
			for (int i = 1; i < array.length - 1; i++) {
				System.out.println(" " + array[i]);
			}
		
	}

	// Heapify method(from bottom to top) in binary heap for swapping in mininum
	// Heap
	public void heapifyB_T(int index) {
		int parent = index / 2;
		if (index <= 1) {
			return;
		}
		if (array[index] > array[parent]) {
			int temp = array[index];
			array[index] = array[parent];
			array[parent] = temp;
		}
		heapifyB_T(parent);
	}

	// insert node in binary heap
	public void insert(int value) {
		array[size + 1] = value;
		size++;
		heapifyB_T(size);
		System.out.println(size + " Node inserted ");
	}

	// Heapify method(from Top to Bottom) in binary heap
	public void heapifyT_B(int index) {
		int left = 2 * index;
		int right = 2 * index + 1;
		int swap_index;
		if (size < left) { // Tree having no child
			return;
		}
		if (size == left) {// Tree having only one child
			if (array[index] < array[left]) {
				int temp = array[index];
				array[index] = array[left];
				array[left] = temp;
			}
			return;
		} else { // Tree having two child
			if (array[left] > array[right]) { // case1-left >right element then assign swap to left
				swap_index = left;
			} else {// otherwise assign swap to right
				swap_index = right;
			}
			if (array[index] < array[swap_index]) {
				int temp = array[index];
				array[index] = array[swap_index];
				array[swap_index] = temp;
			}
		}
		heapifyT_B(swap_index);
	}

	// Extract root
	public void extractRoot() {
		int extracted_value = array[1];
		array[1] = array[size - 1];
		size--;
		heapifyT_B(1);
		System.out.println(extracted_value + " value extracted ");
	}

	// delete Entire binary in heap
	public void deleteMH() {
		array = null;
		System.out.println("Entire Max Heap is deleted ");
	}

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(7);
		heap.insert(10);
		heap.insert(15);
		heap.insert(5);
		heap.insert(25);
		heap.insert(30);
		heap.insert(19);
		// heap.insert(23);
		heap.levelOrder();

		heap.extractRoot();
		heap.levelOrder();

		heap.deleteMH();
	
	}

}

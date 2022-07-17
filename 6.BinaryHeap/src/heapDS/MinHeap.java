package heapDS;

/*
 A min-heap is a binary tree such that. - 
 the data contained in each node is less than (or equal to) the data in that node's children. -
 */
public class MinHeap {

	int array[];
	int size;

	public MinHeap(int size) {
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
		if (array[index] < array[parent]) {
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

	// Heapify method(from Top to Bottom) in binary heap for swapping in mininum
	// Heap
	public void heapifyT_B(int index) {
		// find left and right child of index element
		int left = index * 2;//
		int right = index * 2 + 1;
		int swap;
		// case1:if tree having only one node no swapping just return
		if (size < left) {
			return;
		}
		// if tree having 1 child just comapre index and child
		if (size == left) {
			// perform swapping as in minHeap tree
			// if index value > left child
			if (array[index] > array[left]) {
				int temp = array[index];
				array[index] = array[left];
				array[left] = temp;
			}
			// otherwise no swapping
			return;

		}
		// index element having Two child
		else {
			// compare two child take swapping with index whose value is less
			if (array[left] < array[right]) {
				swap = left;// left value<right value
			} else {
				swap = right;// right value<left value
			}
			if (array[index] > array[swap]) {// perform swapping
				int temp = array[index];
				array[index] = array[swap];
				array[swap] = temp;
			}
		}
		heapifyT_B(swap);// call heapify recursively till end
	}

	// Extract method
	public void extractRoot() {
		int extract_value = array[1];
		array[1] = array[size];// assign last value to first index
		size--;// decrease size by 1
		heapifyT_B(1);// call heapify method to perform swapping from index=1
		System.out.println(extract_value + " Node Extracted ");

	}

	// delete Entire binary in heap
	public void deleteMH() {
		array = null;
		System.out.println("Entire Min Heap is deleted ");
	}

	public static void main(String[] args) {
		MinHeap heap = new MinHeap(5);
		heap.insert(10);
		heap.insert(15);
		heap.insert(5);
		heap.insert(1);
		heap.levelOrder();
		heap.extractRoot();
		heap.levelOrder();

	}
}

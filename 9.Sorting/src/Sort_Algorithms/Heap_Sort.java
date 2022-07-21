package Sort_Algorithms;

/*
 Heap Sort :
 Algorithms :
 Insert all data in Binary heap
 Extract data from binary heap
 */
public class Heap_Sort {

	int array[];
	int size;

	public Heap_Sort(int []array,int size) {
		array = new int[array.length];
		this.array=array;
		this.size = -1;
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
		//System.out.println(size + " Node inserted ");
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
	public int extractRoot() {
		int extract_value = array[1];
		array[1] = array[size];// assign last value to first index
		size--;// decrease size by 1
		heapifyT_B(1);// call heapify method to perform swapping from index=1
	//	System.out.println(extract_value + " Node Extracted ");
		return extract_value;

	}
	//------------------------Heap Sort Method--------------------------------//
	public void heap_sort(int[] array) {
		for(int i=0;i<array.length;i++) {
			insert(array[i]);//insert perform as per min heap
			//it always check root element is minimun or equal to child element
			//if not then it swap in case of insertion
		}
		
		for(int i=0;i<array.length;i++) {
			array[i]=extractRoot();//always extract root element by satisfying min heap properties
			//after extracting root elemt it added last element to root
			//then it check whether new root element is satisfying pro. of min heap
			//otherwise it perform swapping 
			//root elementb perform swapping by its min child between two
		}
	}
	
	public void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(" "+array[i]);
		}
	}

	public static void main(String[] args) {
		int[] arr= {5,10,3,1,8,4,7,6};
		Heap_Sort method=new Heap_Sort(arr,arr.length);
		System.out.println("BeFore Sort : ");
		method.printArray(arr);
		method.heap_sort(arr);//call quick sort method
		System.out.println("\nAfTer Sort : ");
		method.printArray(arr);
	}
}

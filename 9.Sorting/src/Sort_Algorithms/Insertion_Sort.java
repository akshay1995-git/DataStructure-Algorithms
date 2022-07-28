package Sort_Algorithms;
//Insertion Sort
/*

*/
public class Insertion_Sort {
	public void insertion_sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i;
			while (j > 0 && array[j - 1] > temp) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = temp;
		}
	}

	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i]);
		}

	}

	public static void main(String[] args) {
		int[] arr = { 5, 9, 3, 1, 2, 8, 4, 7, 6 };
		Insertion_Sort method = new Insertion_Sort();
		System.out.println("BeFore Sort : ");
		method.printArray(arr);
		method.insertion_sort(arr);
		System.out.println("\nAfTer Sort : ");
		method.printArray(arr);

	}

}

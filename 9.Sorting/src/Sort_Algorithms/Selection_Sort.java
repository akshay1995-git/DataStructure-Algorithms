package Sort_Algorithms;
//Selection Sort
/*
It enhance bubble sort in each pass it find minimum value from  array
stored this min value in appropriate  position in sorted array
Time Complexity : O(n^2)
Space Complexity: O(1)

*/
public class Selection_Sort {
	public void selection_sort(int []array) {//5 9 3 1 8 4 7 6
		
		for(int i=0;i<array.length;i++) {
			int min_index=i;//0->5//initally first element is min
			for(int j=i+1;j<array.length;j++) {//
				if(array[j]<array[min_index]) {//compare all remaining element for getting min elememnt
					min_index=j;//set index of min element
				}
				if(min_index!=i) {//swap this eleement if min_index and i is not same
					int temp=array[i];
					array[i]=array[min_index];//we getting our new array 
					array[min_index]=temp;
				}
			}
			
		}
	}
	public void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(" "+array[i]);
		}
	}
	public static void main(String[] args) {
		int[] arr= {5,9,3,1,8,4,7,6};
		Selection_Sort method=new Selection_Sort();
		System.out.println("BeFore Sort : ");
		method.printArray(arr);
		method.selection_sort(arr);
		System.out.println("\nAfTer Sort : ");
		method.printArray(arr);

	}

}

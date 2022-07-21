package Sort_Algorithms;
/*
Quick Sort :Sorting is a way of arranging items in a systematic manner. 
Quicksort is the widely used sorting algorithm that makes n log n comparisons in average case for sorting
It is a faster and highly efficient sorting algorithm. 
This algorithm follows the divide and conquer approach. 
Algorithms :
Pivot can be random, i.e. select the random pivot from the given array.either left or right from array
compare left element with pivot till less(by increment) and right element with pivot till greater
(by decrementing) as we find viceversa(left>=pivot anf right<=pivot) swap these element 
again same procedure follow till left and right reach to the same element after reaching same element 
swap the reached element with pivot now this pivot element as its final position
we successfully divide array where all left element is less than pivot and right is greater than pivot

same alogorithm follow for left subarray and right sub array separtely 

*/
public class Quick_Sort {

	public int partition(int []array,int start,int end) {//5,9,3,1,8,4,7,6
		int pivot=end;//7=>6
		int i=start-1;//-1=>null
		for(int j=start;j<=end;j++) {//j=0
			if(array[j]<=array[pivot]) {//[(5<6),
				i++;
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				
			}
		}
		return i;
	}
	public void quick_sort(int[] array,int start,int end) {
		if(start<end) {
			int pivot=partition(array,start,end);//call partition method for whole array
			quick_sort(array,start,pivot-1);//sorting for left subarray
			quick_sort(array,pivot+1,end);//sorting for right sub array
		}
	}
		public void printArray(int[] array) {
			for(int i=0;i<array.length;i++) {
				System.out.print(" "+array[i]);
			}
		}
		public static void main(String[] args) {
			
			int[] arr= {5,9,3,1,8,4,7,6};
			Quick_Sort method=new Quick_Sort();
			System.out.println("BeFore Sort : ");
			method.printArray(arr);
			method.quick_sort(arr,0,arr.length-1);//call quick sort method
			System.out.println("\nAfTer Sort : ");
			method.printArray(arr);
	}

}

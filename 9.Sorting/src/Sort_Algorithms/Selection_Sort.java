package Sort_Algorithms;

public class Selection_Sort {
	public void selection_sort(int []array) {//5 9 3 1 8 4 7 6
		
		for(int i=0;i<array.length;i++) {
			int min_index=i;//0->5
			for(int j=i+1;j<array.length;j++) {//1->9
				if(array[j]<array[min_index]) {//(9<5)
					min_index=j;
				}
				if(min_index!=i) {
					int temp=array[i];
					array[i]=array[min_index];
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

package Sort_Algorithms;
//Bubble Sort
public class Bubble_Sort {

	public void bubble_sort(int []array) {
		
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
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
		int[] arr= {5,9,3,1,2,8,4,7,6};
		Bubble_Sort method=new Bubble_Sort();
		System.out.println("BeFore Sort : ");
		method.printArray(arr);
		method.bubble_sort(arr);
		System.out.println("\nAfTer Sort : ");
		method.printArray(arr);

	}

}

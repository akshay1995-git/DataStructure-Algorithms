package Sort_Algorithms;
//Merge Sort :
/*
This sort use divide and conquere algorithm in which start dividing array in subarray
and then recursivley sort each of them
Time complexity :O(nlogn)
Space Complexity :O(n)
USES :inversion counting problem,sorting,E-commerce application
*/

public class Merge_Sort {
public void merge(int []array,int left,int middle,int right) {
	int[] leftArr=new int[middle-left+1];
	int []rightArr=new int[right-middle];
	for(int i=0;i<middle-left;i++) {
		leftArr[i]=array[i];//left sub to leftArr
		//System.out.print(" "+leftArr[i]);
	}
	
	for(int i=middle+1;i<right-middle;i++) {
		rightArr[i]=array[i];//right sub to rightArr
		//System.out.println("  "+rightArr[i]);
	}

	int i=0;
	int j=0;
	int k=left;
        //assign left and rightArr valye to array by comparison
	while(i<leftArr.length && j<rightArr.length){
		if(leftArr[i]<=rightArr[j]) {
			array[k]=leftArr[i];
			i++;
		}
		else {
			array[k]=rightArr[j];
			j++;
		}
	k++;
	}
       //assign remaining value toarray
	
	 while (i <leftArr.length) {
	        array[k] = leftArr[i];
	        i++;
	        k++;
	    }

	    while (j < rightArr.length ){
	        array[k] = rightArr[j];
	        j++;
	        k++;
	    }
}
//Method to sort array
public void merge_sort(int []array,int left,int right) {
	if(right>left) {
		int mid=(left+right)/2;
		merge_sort(array,left,mid);//left sub array
		merge_sort(array,mid+1,right);//right sub array
		merge(array,left,mid,right);
	}
}
	
	public void printArray(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(" "+array[i]);
		}
	}
	public static void main(String[] args) {
		
		int[] arr= {5,9,3,1,8,4,7,6};
		Merge_Sort method=new Merge_Sort();
		System.out.println("BeFore Sort : ");
		method.printArray(arr);
		method.merge_sort(arr,0,arr.length-1);
		System.out.println("\nAfTer Sort : ");
		method.printArray(arr);

	}

}

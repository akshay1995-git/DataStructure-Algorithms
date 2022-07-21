package Sort_Algorithms;


public class Merge_Sort {
public void merge(int []array,int left,int middle,int right) {
	int[] leftArr=new int[middle-left+1];
	int []rightArr=new int[right-middle];
	for(int i=0;i<middle-left;i++) {
		leftArr[i]=array[i];
		//System.out.print(" "+leftArr[i]);
	}
	
	for(int i=middle+1;i<right-middle;i++) {
		rightArr[i]=array[i];
		//System.out.println("  "+rightArr[i]);
	}

	int i=0;
	int j=0;
	int k=left;
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
public void merge_sort(int []array,int left,int right) {
	if(right>left) {
		int mid=(left+right)/2;
		merge_sort(array,left,mid);
		merge_sort(array,mid+1,right);
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

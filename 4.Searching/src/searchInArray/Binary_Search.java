package searchInArray;

import java.util.Scanner;

public class Binary_Search {
public static int binary_search(int arr[],int element) {
	int left=0;
	int right=arr.length;
	int mid=(left+right)/2;
	while(left<=right) {
		if(arr[mid]==element) {
			return mid;
			
		}
		else if(arr[mid]>element) {
			right=mid-1;
		}
		else if(arr[mid]<element) {
			left=mid+1;
		}
		mid=(left+right)/2;
	}
	return -1;
}
	public static void main(String[] args) {
		int []arr= {23,34,45,56,67,76,98};
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a element to search ");
		int ele=sc.nextInt();
		System.out.print(ele+" Element fount at index : "+binary_search(arr,ele));
		sc.close();

	}

}

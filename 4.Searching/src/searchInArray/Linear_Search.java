package searchInArray;

import java.util.Scanner;

public class Linear_Search {
		public static int  linear_search(int array[],int element) {
			for (int i=0;i<array.length;i++) {
				if(element==array[i]) {
					return i;
				}
				else {
					continue;
				}
				
			}
			return -1;
		}
	public static void main(String[] args) {
		int []arr= {23,34,45,56,67,76,98};
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a element to search ");
		int ele=sc.nextInt();
		System.out.print(ele+" Element fount at index : "+linear_search(arr,ele));
		sc.close();
	}

}

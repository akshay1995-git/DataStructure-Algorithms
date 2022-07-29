package examples;

public class Fibonacci {

	public static int fibonacci_method(int num) {
		if(num<0) {
			System.out.println("Error");
			return -1;
		}
		else if(num==1) {
			return 0;
		}
		else if(num==2) {
			return 1;
		}
		else {
			return fibonacci_method(num-1)+fibonacci_method(num-2);
		}
	}
	public static void main(String[] args) {
	
		System.out.println(fibonacci_method(10));
	}

}

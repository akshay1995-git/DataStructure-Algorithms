package examples;
//given N,find the number of ways to express N as sum of 1,3,4
//we can use this number multiple time
//N=4 (number of ways=4)
//{4},{1,3},{3,1},{1,1,1,1}
/*
 * N=6
 * N1=5  (5+1,2+3,1+4)                                       N2=3 (3+3)                                          N3=2(2+4)
 * N1.1=4   N1.2=2    N1.3=1                  N2.1=2                                                   N3.1=1
 * ( N1.1.1=3
 */
public class Number_Factor {

	public static int waysTogetFactor(int N) {
		if(N==0 ||N==1||N==2) {
			return 1;
		}
		if(N==3) {
			return 2;
		}
		int sub1=waysTogetFactor(N-1);
		int sub2=waysTogetFactor(N-3);
		int sub3=waysTogetFactor(N-4);
		
		return sub1+sub2+sub3;
	}
	public static void main(String[] args) {
		
		
		System.out.println(waysTogetFactor(6));
		System.out.println(waysTogetFactor(5));


	}

}

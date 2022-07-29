package examples;
/*
 * Given n number of houses with some money in it 
 * Adjacent  houses can not stolen 
 * Find maximum amount can be stolen
 * ind          0      1    2    3       4    5       6
/*House    h1   h2   h3   h4   h5  h6     h7
 * Money   6     7      1     30   8     2         4
 * start from 0 index take 2 and skip 1
 * start from 1 then take 3 and skip 2 index
 */
public class HouseRobber {

	public static int robb_method(int []houseMoney,int current) {
		if(current>=houseMoney.length) {
			return 0;
		}
		int stealHouse=houseMoney[current]+robb_method(houseMoney,current+2);
		int skipHouse=robb_method(houseMoney,current+1);
		return Math.max(stealHouse, skipHouse);
	}
	
	public static void main(String[] args) {
		int houseMoney[]= {6,7,1,30,8,2,4};
		System.out.println(robb_method(houseMoney,0));
	}
}

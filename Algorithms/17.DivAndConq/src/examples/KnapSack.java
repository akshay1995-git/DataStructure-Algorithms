package examples;
//Zero one knapSack Problem -Can not break item in to fraction
public class KnapSack {

	public static int knapsack_method(int []profits,int []weights,int capacity,int index) {
		if(capacity<=0 || index<0||index>=profits.length) {
			return 0;
		}
		int profit1=0;
		int profit2=0;
		if(weights[index]<=capacity) {
			profit1=profits[index]+knapsack_method(profits, weights, capacity-weights[index], index+1);
			profit2=knapsack_method(profits, weights, capacity, index+1);
		}
		return Math.max(profit1,profit2);
		
	}
	
	public static void main(String[] args) {
		int []profits= {31,26,17,72};
		int weights[]= {3,1,2,5};
		System.out.println("Maximum Profit : "+knapsack_method(profits, weights, 7, 0));
	}

}

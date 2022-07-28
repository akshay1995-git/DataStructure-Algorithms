package fraction_knapsack;
/*
 * KNAPSACK PROBLEM
 * We are given n items with its own  weight and value and capacity of 
 * KnapSack is "W"(capacity of bag).we need put these items in knapsack
 * (Bag)such that value of item in KnapSack is maximum
 * AIM:is to maximize value so find out item whose val/wt is max
 */ 
//ALGORITHMS
     //items         n1   n2  n3  n4  n5
/*value     =>   21   24  12  40  30
 * weight  =>   7      4    6     5   6
 * val/wt   =>   3      6   2     8    5
 * sort these value descending order //8  6  5  3  2
 */
public class KnapSack implements Comparable<KnapSack>{
    private double ratio;
	private String name;
	private int weight;
	private int value;
	public KnapSack(String name, int weight, int value) {
		super();
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.ratio=value*1.0/weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	@Override
	public String toString() {
		return "KnapSack [name=" + name + ", weight=" + weight + ", value=" + value + "]";
	}
	@Override
	public int compareTo(KnapSack o) {
	//return (int) (ratio-o.ratio);
		if(ratio>o.ratio) {
			return -1;
		}
		else if (ratio<o.ratio) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}

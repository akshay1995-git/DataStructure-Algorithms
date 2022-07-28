package fraction_knapsack;

import java.util.ArrayList;
import java.util.Collections;

public class KnapSack_Main {

	public static void knapsack_method(ArrayList<KnapSack> list, int capacity) {
		Collections.sort(list);// sort
		int usedCapacity = 0;
		double total_value = 0;
		for (KnapSack item : list) {
			int temp = usedCapacity + item.getWeight();
			if (temp <= capacity) {
				usedCapacity += item.getWeight();
				System.out.println(item.getWeight() + "kg Weight Taken of value "+item.getValue());
				total_value += item.getValue();
			} else {
				int remainWt = capacity - usedCapacity;
				double value = item.getRatio() * remainWt;
				System.out.println(item.getWeight() + " Weight taken of " + item.getRatio() + " Ratio and value "+item.getValue());
				usedCapacity += remainWt;
				total_value += value;
			}
			if (usedCapacity == capacity) {
				break;
			}
		}
		System.out.println("Total Maximum Value in KnapSack : " + total_value);
	}

	public static void main(String[] args) {
		ArrayList<KnapSack> list = new ArrayList<>();
		list.add(new KnapSack("n1", 7, 21));
		list.add(new KnapSack("n2", 4, 24));
		list.add(new KnapSack("n3", 6, 12));
		list.add(new KnapSack("n4", 5, 40));
		list.add(new KnapSack("n5", 6, 30));
		knapsack_method(list, 20);
	}

}

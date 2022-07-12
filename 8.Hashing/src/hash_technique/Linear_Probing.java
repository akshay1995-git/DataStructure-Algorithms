package hash_technique;

import java.util.ArrayList;
/*
 Linear Probing :It is collision resolution technique in which it searches the nearest location 
 to store value by sequential searching 
 Ex:akshay(1),akash(0),sakshi(2),akshay(1)
search for next nearest empty block to store value
index value  
0--akash
1--akshay
2--sakshi
3--akshay(nearest empty block)
 */
public class Linear_Probing {
	
	String[] hashTable;
	int usedCellNum;

	public Linear_Probing(int size) {
		hashTable = new String[size];// size=4
		usedCellNum = 0;
	}

//HashFunction return index position
	public int hashFunction(String str, int m) {
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			total += str.charAt(i);
		}
		return total % m;

	}

	// Get Load-Factor -automatically hashtable size increases
	public double getLoadFactor() {
		double loadfactor = usedCellNum * 1.0 / hashTable.length;
		return loadfactor;
	}

	// Rehashing -creating new hashtable and assigning old hashtable to new
	// hashtable
	public void rehashKey(String word) {
		usedCellNum = 0;
		ArrayList<String> data = new ArrayList<String>();// declare temp hashtable
		for (String s : hashTable) {
			if (s != null) {
				data.add(s);// assign all hashtable data to temp hashtable
			}

			data.add(word);// add new word at last
			hashTable = new String[hashTable.length * 2];// increase size of actual hashtable
			for (String st : data) {
				// insert data in hashtable by incrementing size
				insert(st);// assign all value from temp hashtable to actual hashtable//insert method
			}
		}
	}

//insert value
	public void insert(String word) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKey(word);
		} else {
			int index = hashFunction(word, hashTable.length);
			for (int i = index; i < index + hashTable.length; i++) {
				int new_index = i % hashTable.length;
				if (hashTable[new_index] == null) {
					hashTable[new_index] = word;
					System.out.println(word + " inserted at " + new_index);
					break;

				} else {
					System.out.println("index already occupied use  next cell : ");
				}
			}
		}
		usedCellNum++;
	}

	public void display() {
		if (hashTable == null) {
			System.out.println("Hashtable is Empty ");
		} else {
			System.out.println("-----{ HashTable Data }-----");
			System.out.println("Key    |     Value ");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println(i + "       ->       " + hashTable[i]);
			}
		}
	}

	public boolean searchMethod(String word) {
		int index = hashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int new_index = i % hashTable.length;
			if (hashTable[new_index] != null && hashTable[new_index].equals(word)) {
				System.out.println("Word Found ");
				return true;
			}

		}
		System.out.println("Word Not Found");
		return false;
	}
	public void deleteMethod(String word) {
		int index = hashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int new_index = i % hashTable.length;
			if (hashTable[new_index] != null && hashTable[new_index].equals(word)) {
				hashTable[i]=null;
				System.out.println("Word deleted from hashtable");
				return;
			}
		}
		System.out.println("Word Not found in hashtable");
	}

	public static void main(String[] args) {
		Linear_Probing row = new Linear_Probing(4);

		row.insert("akshay");
		row.insert("akash");
		row.insert("rahul");
		row.insert("rohan");
		row.insert("akshay");
		row.display();
		
		row.searchMethod("rohan");
		row.deleteMethod("rohan");
		row.searchMethod("rohan");
	}

}

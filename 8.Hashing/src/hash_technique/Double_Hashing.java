package hash_technique;

import java.util.ArrayList;

public class Double_Hashing {
	String[] hashTable;
	int usedCellNum;
	public Double_Hashing(int size) {
		hashTable = new String[size];// size=4
		usedCellNum = 0;
	}
	//HashFunction return index position
		public int hashFunction_first(String str, int m) {
			int total = 0;
			for (int i = 0; i < str.length(); i++) {
				total += str.charAt(i);
			}
			return total % m;

		}
//second hash function
		private int addDigit(int sum) {
			int value=0;
			while(sum>0) {
				value=sum%10;
				sum/=10;
			}
			return value;
		}
		
	//hashFunction second
		public int hashFunction_second(String word,int m) {
			int total = 0;
			for (int i = 0; i < word.length(); i++) {
				total += word.charAt(i);
			}
			while(total>hashTable.length) {
				total=addDigit(total);
			}
			return total%m;
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
		//insert method
		public void insert(String word) {
			double loadFactor = getLoadFactor();
			if (loadFactor >= 0.75) {
				rehashKey(word);
			} else {
				int first=hashFunction_first(word,hashTable.length);
				int second=hashFunction_second(word, hashTable.length);
				for(int i=0;i<hashTable.length;i++) {
					int new_index=(first+i*second)%hashTable.length;
					if (hashTable[new_index] == null) {
						hashTable[new_index] = word;
						System.out.println(word + " inserted at " + new_index);
						break;

					} else {
						System.out.println("index already occupied use  next cell : ");
					}
				}
			}
		}
		
		//display method
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
		//------------------------------------------------------------------------------------
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

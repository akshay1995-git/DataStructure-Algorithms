package hash_technique;

import java.util.LinkedList;
/*
Direct_Chaining: It is collision resolution technique in which after returning hashvalue(index) 
by hash function if that index occupied then next data is linked together by address
Ex:akshay,akash,sakshi,akshay
it hold items which return same hashvalue by array of linked list
index value  
0--akash
1--akshay-->akshay(direct chain )if two or more data return same hashvalue then chaining happens
2--sakshi
*/
public class Direct_Chain {
//creating linked list
	LinkedList<String> hashtable[];
	int max_size = 5;

	Direct_Chain(int size) {
		this.hashtable = new LinkedList[size];
	}
//HashFunction return index position
	public int hashFunction(String str, int m) {
		int total = 0;
		for (int i = 0; i < str.length(); i++) {
			total += str.charAt(i);
		}
		return total % m;

	}
//insert string in hashFunction
	public void insert(String str) {
		int index = hashFunction(str, hashtable.length);//return hashvalue
		if (hashtable[index] == null) {//if index is null in hashtable
			hashtable[index] = new LinkedList<String>();//create linkednode
			hashtable[index].add(str);//add str to that node
		} else {
			hashtable[index].add(str);//if node is not empty simply add new str to present str
		}
	}

	public void display() {
		if (hashtable == null) {
			System.out.println("Hashtable is Empty ");
		} else {
			System.out.println("---HashTable Data---");
			for (int i = 0; i < hashtable.length; i++) {
				System.out.println("Key : " + i + " Value : " + hashtable[i]);
			}
		}
	}

	public boolean search(String str) {
		int search_index = hashFunction(str, hashtable.length);
		if (hashtable[search_index] != null && hashtable[search_index].contains(str)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean delete(String str) {
		int search_index = hashFunction(str, hashtable.length);
		if (hashtable[search_index] != null && hashtable[search_index].contains(str)) {
			hashtable[search_index].remove("str");
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Direct_Chain node = new Direct_Chain(10);
		node.insert("akshay");
		node.insert("akash");
		node.insert("sakshi");
		node.insert("rohan");
		node.insert("akshay");
		node.display();
		if (node.search("rohan")) {
			System.out.println("String Found");
		} else {
			System.out.println("String Not Found");
		}
		if (node.delete("rohan")) {
			System.out.println("String deleted");
		} else {
			System.out.println("String Not Found");
		}
		node.display();
	}

}

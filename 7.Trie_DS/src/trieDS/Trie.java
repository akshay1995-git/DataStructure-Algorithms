package trieDS;

public class Trie implements Itrie {

	Trie_Node root;
	Trie(){
		root=new Trie_Node();
	}
	
/*
 Insert :Every char in str inserted individually in trie node
 if present node having ref of present char set present node to present ref otherwise create new ref 
 *
 */
 
	@Override
	public void insert(String str) {//bad,bat
		if(str==null || str.isEmpty()) {//str is empty then no need traversal for insertion
			System.out.println("Word is Empty ");
		}
		else {
			Trie_Node temp=root;//null
			for(int i=0;i<str.length();i++) {
				char chr=str.charAt(i);//b
				int index=chr-'a';//1
				if(temp.array[index]==null) {
					Trie_Node curr=new Trie_Node();
					temp.array[index]=curr;//1->26 char
					temp=curr;
				}
				else {
					temp=temp.array[index];//1-->2--.>3 index
				}
			}
			temp.end=true;//after inserttion end is true for givin str
		}
		
	}
	@Override
	public boolean search(String str) {
		Trie_Node current = root;
	    for (int i = 0; i < str.length(); i++) {
	        char ch =str.charAt(i);
	        int index=ch-'a';
	        Trie_Node node = current.array[index];
	        if (node == null) {
	            return false;
	        }
	        current = node;
	    }
	    return current.end;
		
	}
	@Override
	public boolean delete(String str) {
		Trie_Node current=root;
			  for (int i = 0; i < str.length(); i++) {
			        char ch =str.charAt(i);
			        int index=ch-'a';
			        Trie_Node node = current.array[index];
			        if (node == null) {
			            return false;
			        }
			        current = node;
			  }
			  current=null;
			  return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		trie.insert("dog");
		trie.insert("duck");
		trie.insert("dull");
		trie.insert("cat");
		System.out.println(trie.search("duck"));
		System.out.println(trie.delete("duck"));
		System.out.println(trie.search("duck"));

	}


}

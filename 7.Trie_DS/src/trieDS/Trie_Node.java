package trieDS;

public class Trie_Node  {
	//creating trie node class
	boolean end;
	Trie_Node array[];
	
	Trie_Node(){
		this.end=false;//end is false
		this.array=new Trie_Node[26];//each node having 26 chr length
	}

	
}

package trieDS;

public interface Itrie {
//insert character in trie_node from string
	void insert(String str);
//search a string 
	boolean search(String str);
//delete the given string from trie
	boolean delete(String str);
}

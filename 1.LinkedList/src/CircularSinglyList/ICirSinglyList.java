package CircularSinglyList;

public interface ICirSinglyList {
	//operation performed on circular singly list
	void beginsert (int data);   
	void lastinsert (int data);  
	void randominsert(int index,int data);  
	void begin_delete();  
	void last_delete();  
	void random_delete(int index);  
	void display();  
	void search();  
}

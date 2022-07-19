package AVLtree;

public class TreeNode {

	public int data;
	public int height;
	TreeNode left,right;
	TreeNode(int data){
		left=null;
		this.data=data;
		right=null;
		height=0;
	}
}

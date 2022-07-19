package binarytree;

public class Perfect_BT {
 Perfect_BT left,right;
 int data;
	public Perfect_BT(int data) {
	left=null;
	this.data=data;
	right=null;
	}
	public static int depth(Perfect_BT node) {
	    int d = 0;
	    while (node != null) {
	      d++;
	      node = node.left;
	    }
	    return d;
	  }
	public static boolean check_perfect_BT(Perfect_BT root,int d,int level) {
		
		 if (root == null)
		      return true;

		    // If for children
		    if (root.left == null && root.right == null)
		      return (d == level + 1);

		    if (root.left == null || root.right == null)
		      return false;

		    return check_perfect_BT(root.left, d, level + 1) && check_perfect_BT(root.right, d, level + 1);
		
	}
	static boolean is_Perfect(Perfect_BT root) {
	    int d = depth(root);
	    return check_perfect_BT(root, d, 0);
	  }
	public static void main(String[] args) {
		Perfect_BT root1=new Perfect_BT(1);
		root1.left = new Perfect_BT(2);
		root1.right = new Perfect_BT(3);
		root1.left.left = new Perfect_BT(4);
		root1.left.right = new Perfect_BT(5);
		root1.right.left = new Perfect_BT(3);
	 root1.right.right=new Perfect_BT(6);
		if(is_Perfect(root1)==true) {
			System.out.println("Tree is Perfect Binary Tree ");
		}
		else {
			System.out.println("Tree is not Perfect binary tree");
		}
	}

}

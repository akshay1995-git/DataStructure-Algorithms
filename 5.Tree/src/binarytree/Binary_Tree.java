package binarytree;

public class Binary_Tree {
	Binary_Tree left;
	Binary_Tree right;
	int data;

	Binary_Tree(int data) {
		left = null;
		this.data = data;
		right = null;

	}

//Pre-Order Traverse in binary Tree -->Root-Left-Right
	public void preOrderTraverse(Binary_Tree root) {
		if (root != null) {
			System.out.print(" " + root.data);
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
		}
	}
//In-Order Traverse in binary Tree-->Left-Root-Right
	public void inOrderTraverse(Binary_Tree root) {
		if(root.left!=null) {
			inOrderTraverse(root.left);
		}
		System.out.print(" "+root.data);
		if(root.right!=null) {
			inOrderTraverse(root.right);
		}
	}
	//Post-Order Traverse in binary Tree-->Left-Right-Root
		public void postOrderTraverse(Binary_Tree root) {
			if(root.left!=null) {
				inOrderTraverse(root.left);
			}
			
			if(root.right!=null) {
				inOrderTraverse(root.right);
			}
			System.out.print(" "+root.data);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Binary_Tree root = new Binary_Tree(1);
		root.left = new Binary_Tree(2);
		root.right = new Binary_Tree(3);
		root.left.left = new Binary_Tree(4);
		root.right.left = new Binary_Tree(5);
		root.right.right = new Binary_Tree(6);
		System.out.print("Pre-Order Traverse : ");
		root.preOrderTraverse(root);
		System.out.println(" ");
		System.out.print("In-Order Traverse : ");
		root.inOrderTraverse(root);
		System.out.println(" ");
		System.out.print("Post-Order Traverse : ");
		root.postOrderTraverse(root);
	}

}

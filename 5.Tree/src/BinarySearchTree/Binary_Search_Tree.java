package BinarySearchTree;

public class Binary_Search_Tree {
	Binary_Search_Tree left, right;
	Binary_Search_Tree root;
	int data;

	Binary_Search_Tree() {
		root = null;
	}

	Binary_Search_Tree(int data) {
		left = null;
		this.data = data;
		right = null;
	}

//insert node in  binary search tree using RECURSION 
	public Binary_Search_Tree insertByRec(Binary_Search_Tree root, int value) {

		if (root == null) {
			root = new Binary_Search_Tree(value);
			return root;
		}
		if (root.data < value) {
			root.right = insertByRec(root.right, value);
		} else if (root.data > value) {
			root.left = insertByRec(root.left, value);
		}
		return root;
	}

//inser node in binary search tree using ITERATION
	public Binary_Search_Tree insertByItr(Binary_Search_Tree root, int value) {
		if (root == null) {
			root = new Binary_Search_Tree(value);
			return root;
		} else {
			Binary_Search_Tree current = root;
			Binary_Search_Tree temp = null;
			while (current != null) {
				temp = current;
				if (current.data < value) {
					current = current.right;
				} else if (current.data > value) {
					current = current.left;
				}
			}
			if (temp.data > value) {
				temp.left = new Binary_Search_Tree(value);
			} else {
				temp.right = new Binary_Search_Tree(value);
			}
			return root;
		}
	}
//In-Order traversal

	public void inorderTraverse(Binary_Search_Tree root) {
		if (root != null) {
			inorderTraverse(root.left);
			System.out.print(root.data + " --> ");
			inorderTraverse(root.right);
		}
	}

//min node value in tree

	public int getMinValue(Binary_Search_Tree root) {
		if (root == null) {
			System.out.println("Tree is Empty ");
			return -1;
		} else {
			Binary_Search_Tree current = root;
			while (current.left != null) {
				current = current.left;
			}
			System.out.println("\nMin Node value : " + current.data);
			return current.data;
		}
	}
	// Get max node value

	public void getMaxValue(Binary_Search_Tree root) {
		if (root == null) {
			System.out.println("Tree is Empty ");
		} else {
			Binary_Search_Tree current = root;
			while (current.right != null) {
				current = current.right;
			}
			System.out.println("\nMax Node value : " + current.data);
		}
	}

	// Search node in binary search tree
	public boolean search_node(Binary_Search_Tree root, int value) {
//		if (root == null) {
//			return false;
//		}
		if (root.data == value) {
			return true;
		}
		else {
			Binary_Search_Tree current = root;
			Binary_Search_Tree temp = null;
			while (current != null) {
				temp = current;
				if (current.data < value) {
					current = current.right;
				} else if (current.data > value) {
					current = current.left;
				}
			}
			if(temp.data==value) {
				return true;
			}
			else {
				return false;
			}
		}
	}
//Delete node by Recursion
	public Binary_Search_Tree deleteByRec(Binary_Search_Tree root,int value) {
		/*
		 * 
		1.the node to be deleted is the leaf node. In such a case, simply delete the node from the tree.
        2.the node to be deleted lies has a single child node. In such a case follow the steps below:
            Replace that node with its child node.
            Remove the child node from its original position.
        3.the node to be deleted has two children. In such a case follow the steps below:
            Get the inorder successor of that node.
            Replace the node with the inorder successor.
            Remove the inorder successor from its original position.
		 */
		if(root==null) {
			System.out.println("Tree is Empty");
			return root;
		}
		if(root.data>value) {
			root.left=deleteByRec(root.left, value);
		}
		else if(root.data<value) {
			root.right=deleteByRec(right, value);
		}
		else {
			
			if (root.left == null)
		        return root.right;
		      else if (root.right == null)
		        return root.left;
			
			
			value= getMinValue(root.right);

		      // Delete the inorder successor
		      root.right = deleteByRec(root.right,value);
		}
		return root;
	}
	public static void main(String[] args) {
		Binary_Search_Tree tree = new Binary_Search_Tree(3);
		tree = tree.insertByRec(tree, 8);
		tree = tree.insertByRec(tree, 1);
		tree = tree.insertByItr(tree, 6);
		tree = tree.insertByRec(tree, 7);
		tree = tree.insertByItr(tree, 10);
		tree = tree.insertByItr(tree, 14);
		System.out.print("In-Order Traversal : ");
		tree.inorderTraverse(tree);

		tree.getMinValue(tree);

		tree.getMaxValue(tree);
//
//		if (tree.search_node(tree, 6) == true) {
//			System.out.println("Node Present");
//		} else {
//			System.out.println("Node absent");
//		}
		
		tree.deleteByRec(tree, 7);
		System.out.print("After delete In-Order Traversal : ");
		tree.inorderTraverse(tree);

	}

}

package AVLtree;

public class AVL_Tree {
	TreeNode root;

	public AVL_Tree() {
		root = null;
	}

//	Traversal Technique
	// 1.In-Order Traversal -----------------------------------------
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(" " + root.data);
			inOrder(root.right);
		} else {
			return;
		}
	}

	// 2.PreOrder Traversal---------------------------------------------
	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.println(" " + root.data);
			preOrder(root.left);
			preOrder(root.right);
		} else {
			return;
		}
	}

	// 3.Post Order Traversal-------------------------------------------------
	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(" " + root.data);
		} else {
			return;
		}
	}

//4.Level-Order Traversal---------------------------------------------------------------
	public void levelOrder(TreeNode root) {

	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

//Search node in AVL tree----------------------------------------------------------------
	public TreeNode searchNode(TreeNode root, int value) {
		if (root == null) {
			System.out.println(value + " Not found in AVL tree Node ");

			return null;
		} else if (root.data == value) {
			System.out.println(value + " found in AVL tree Node ");
			return root;
		} else if (root.data > value) {
			return searchNode(root.left, value);
		} else {
			return searchNode(root.right, value);
		}
	}

	// Height of node---------------------------------------------------------
	int height(TreeNode N) {
		if (N == null)
			return 0;
		return N.height;
	}

	// Get balance factor of a
	// node------------------------------------------------------
	int getBalanceFactor(TreeNode N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	/*---------------------------------ROTATION------------------------------------------------------------*/
	public TreeNode leftRotation(TreeNode root) {// Anticlockwise
		TreeNode tempNode1 = root.right;
		TreeNode tempNode2 = root.left;
		tempNode1.left = root;
		root.right = tempNode2;
		root.height = max(height(root.left), height(root.right)) + 1;
		tempNode1.height = max(height(tempNode1.left), height(tempNode1.right)) + 1;
		return tempNode1;
	}

	public TreeNode rightRotation(TreeNode root) {// clockwise
		TreeNode tempNode1 = root.left;
		TreeNode tempNode2 = root.right;
		tempNode1.right = root;
		root.left = tempNode2;
		root.height = max(height(root.left), height(root.right)) + 1;
		tempNode1.height = max(height(tempNode1.left), height(tempNode1.right)) + 1;
		return tempNode1;
		//return tempNode2;

	}

	/*-----------------------------------------------------------------------------------------------------*/
//Insert Node in AVL tree
	public TreeNode insertNode(TreeNode root, int value) {
		if (root == null) {
			root = new TreeNode(value);
			return root;
		} else if (root.data > value) {
			root.left = insertNode(root.left, value);
		} else if (root.data < value) {
			root.right = insertNode(root.right, value);
		} else
			return root;

		root.height = 1 + max(height(root.left), height(root.right));
		int balenceFactor = getBalanceFactor(root);
		if (balenceFactor > 1) {
			if (root.left.data > value) {
				// right rotation
				return rightRotation(root);
			} else if (root.left.data < value) {
				// left and then right rotation
				root.left = leftRotation(root.left);
				return rightRotation(root);
			}
		} else if (balenceFactor < -1) {
			if (root.right.data < value) {
				// left rotation
				return leftRotation(root);
			} else if (root.right.data > value) {
				// right and then left rotation
				root.right = rightRotation(root.right);
				return leftRotation(root);
			}
		}
		return root;
	}
	// Delete Operation in AVL-----------------------------------------------------------
	  TreeNode nodeWithMimumValue(TreeNode node) {
		    TreeNode current = node;
		    while (current.left != null)
		      current = current.left;
		    return current;
		  }
	  
public TreeNode deleteNode(TreeNode root,int item) {
	 // Find the node to be deleted and remove it
    if (root == null)
      return root;
    if (item < root.data)
      root.left = deleteNode(root.left, item);
    else if (item > root.data)
      root.right = deleteNode(root.right, item);
    else {
      if ((root.left == null) || (root.right == null)) {
        TreeNode temp = null;
        if (temp == root.left)
          temp = root.right;
        else
          temp = root.left;
        if (temp == null) {
          temp = root;
          root = null;
        } else
          root = temp;
      } else {
        TreeNode temp = nodeWithMimumValue(root.right);
        root.data = temp.data;
        root.right = deleteNode(root.right, temp.data);
      }
    }
    if (root == null)
      return root;

    // Update the balance factor of each node and balance the tree
    root.height = max(height(root.left), height(root.right)) + 1;
    int balanceFactor = getBalanceFactor(root);
    if (balanceFactor > 1) {
      if (getBalanceFactor(root.left) >= 0) {
        return rightRotation(root);
      } else {
        root.left = leftRotation(root.left);
        return rightRotation(root);
      }
    }
    if (balanceFactor < -1) {
      if (getBalanceFactor(root.right) <= 0) {
        return leftRotation(root);
      } else {
        root.right = rightRotation(root.right);
        return leftRotation(root);
      }
    }
	return root;
	
}
//Print the AVL Tree 
	// Print the tree
	private void printTree(TreeNode currPtr, String indent, boolean last) {
		if (currPtr != null) {
			System.out.print(indent);
			if (last) {
				System.out.print("R------>");
				indent += "   ";
			} else {
				System.out.print("L------>");
				indent += "|  ";
			}
			System.out.println(currPtr.data);
			printTree(currPtr.left, indent, false);
			printTree(currPtr.right, indent, true);
		}
	}

	public static void main(String[] args) {
		AVL_Tree tree = new AVL_Tree();
		tree.root = tree.insertNode(tree.root, 33);
		tree.root = tree.insertNode(tree.root, 13);
		tree.root = tree.insertNode(tree.root, 53);
		tree.root = tree.insertNode(tree.root, 9);
		tree.root = tree.insertNode(tree.root, 21);
		tree.root = tree.insertNode(tree.root, 61);
		tree.root = tree.insertNode(tree.root, 8);
		tree.root = tree.insertNode(tree.root, 11);
		tree.printTree(tree.root, "", true);
		
		tree.root = tree.deleteNode(tree.root, 13);
	    System.out.println("------------: After Deletion : ----------");
	    tree.printTree(tree.root, "", true);
	}

}

package binarytree;
/*
 Full Binary Tree:
 A tree of every node having two children except leaf node 
 all level are completely filled
 */
public class Full_Binary_Tree {
	Full_Binary_Tree left,right;
	int data;
	public Full_Binary_Tree(int data) {
		left=null;
		this.data=data;
		right=null;
	}
	public static boolean check_full_BT(Full_Binary_Tree node) {
		if (node == null)
		    return true;

		  // Checking the children
		  if (node.left == null && node.right== null)
		    return true;

		  if ((node.left != null) && (node.right != null))
		    return (check_full_BT(node.left) && check_full_BT(node.right));

		  return false;
		
		
	}
	/*
	public static boolean check_full_BT(Full_Binary_Tree node){
		if(node==null){
			return true;
		}
		if (node.left == null && node.right== null)
		    return true;

		LinkedList<Full_Binary_Tree> q=new LinkedList<>();
		q.add(node);
		   // traverse all the nodes of the binary tree
    // level by level until queue is empty
    while (!q.isEmpty()) {
        // get the pointer to 'node' at front
        // of queue
        Node node = q.peek();
        q.remove();
 
        // if it is a leaf node then continue
        if (node.left == null && node.right == null)
            continue;
 
        // if either of the child is not null and the
        // other one is null, then binary tree is not
        // a full binary tee
        if (node.left == null || node.right == null)
            return false;
 
        // push left and right childs of 'node'
        // on to the queue 'q'
        q.add(node.left);
        q.add(node.right);
    }
 
    // binary tree is a full binary tee
    return true
	}
	 */

	public static void main(String[] args) {
		Full_Binary_Tree root1 = new Full_Binary_Tree(1);
		root1.left = new Full_Binary_Tree(2);
		root1.right = new Full_Binary_Tree(3);
		root1.left.left = new Full_Binary_Tree(4);
		root1.left.right = new Full_Binary_Tree(5);
		root1.right.left = new Full_Binary_Tree(3);
		//root1.right.right= new Full_Binary_Tree(7);
		if(check_full_BT(root1)==true) {
			System.out.println("Tree is Full Binary Tree ");
		}
		else {
			System.out.println("Tree is not Full binary tree");
		}
	}

}

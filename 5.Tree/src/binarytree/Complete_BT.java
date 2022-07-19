package binarytree;
/*
 * A complete binary tree is just like a full binary tree, but with two major differences

All the leaf elements must lean towards the left.
The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to
 be a full binary tree.

 */
//import java.util.LinkedList;
public class Complete_BT {
Complete_BT left,right;
int data;
Complete_BT(int data){
	left=null;
	this.data=data;
	right=null;
}
//Count the number of nodes
public static int countNumNodes(Complete_BT root1) {
 if (root1 == null)
   return (0);
 return (1 + countNumNodes(root1.left) + countNumNodes(root1.right));
}
public static boolean check_complete_BT(Complete_BT root,int index,int numberNodes) {
	if (root == null)
	      return true;

	    if (index >= numberNodes)
	      return false;

	    return (check_complete_BT(root.left, 2 * index + 1, numberNodes)
	        && check_complete_BT(root.right, 2 * index + 2, numberNodes));
	  
	
	
}
/*
static boolean isCompleteBT(Complete_BT root)
    {
        // Base Case: An empty tree is complete Binary Tree
        if(root == null)
            return true;
          
        // Create an empty queue
        LinkedList<Complete_BT> queue =new LinkedList<>();
          
        // Create a flag variable which will be set true
        // when a non full node is seen
        boolean flag = false;
          
        // Do level order traversal using queue.
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node temp_node = queue.remove(0);
              
            /* Check if left child is present
            if(temp_node.left != null)
            {
                 // If we have seen a non full node, and we see a node
                 // with non-empty left child, then the given tree is not
                 // a complete Binary Tree
                if(flag == true)
                    return false;
                  
                 // Enqueue Left Child
                queue.add(temp_node.left);
            }
            // If this a non-full node, set the flag as true
            else
                flag = true;
              
            //// Check if right child is present 8
			/*
            if(temp_node.right != null)
            {
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if(flag == true)
                    return false;
                  
                // Enqueue Right Child
                queue.add(temp_node.right);
                  
            }
            // If this a non-full node, set the flag as true
            else 
                flag = true;
        }
         // If we reach here, then the tree is complete Binary Tree
        return true;
    }*/
	public static void main(String[] args) {
		Complete_BT root1 = new Complete_BT(1);
		root1.left = new Complete_BT(2);
		root1.right = new Complete_BT(3);
		root1.left.left = new Complete_BT(4);
		root1.left.right = new Complete_BT(5);
		//root1.right.left = new Complete_BT(3);
		root1.right.right= new Complete_BT(7);
		int node_count = countNumNodes(root1);
	    int index = 0;

		if(check_complete_BT(root1,index,node_count)==true) {
			System.out.println("Tree is Complete Binary Tree ");
		}
		else {
			System.out.println("Tree is not Complete binary tree");
		}
	}

}

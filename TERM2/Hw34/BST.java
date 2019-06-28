//Jeffrey Weng
//APCS2 - pd 3
//HW34 -- Algorithm as Data Structure
//2017-05-03

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal) 
    {
	root = insertTree(root, new TreeNode(newVal));
    }

    public TreeNode insertTree(TreeNode root, TreeNode temp){
	if(root == null){
	    return temp;
	}
	else if(temp.getValue() > root.getValue()){
	    root.setRight(insertTree(root.getRight(), temp));
	}
	else if(temp.getValue() < root.getValue()){
	    root.setLeft(insertTree(root.getLeft(), temp));
	}

	return root;
    }
		    
		
	
	       


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

     // PreOrder Traversal Wrapper
    public void preOrderTrav() 
    {
	preOrder(root);
    }

    
    public void preOrder(TreeNode node) { 
	if (node == null) {
	    return;
	}
	System.out.print(node.getValue() + " ");

	preOrder(node.getLeft());

	preOrder(node.getRight());
    }

    // InOrder Traversal Wrapper
    public void inOrderTrav() 
    {
	inOrder(root);
    }

   
    public void inOrder(TreeNode node) { 

	if (node == null) {
	    return;
	}

	inOrder(node.getLeft());

	System.out.print(node.getValue() + " ");

	inOrder(node.getRight());
    }

    // PostOrder Traversal Wrapper
    public void postOrderTrav() 
    {
	postOrder(root);
    }
    
   
    public void postOrder(TreeNode node) { 

	if (node == null) {
	    return;
	}

	postOrder(node.getLeft());

	postOrder(node.getRight());

	System.out.print(node.getValue() + " ");
    }
  /*~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


    //main method for testing
    public static void main( String[] args ) 
    {

	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();

	  System.out.println("");
	  	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class

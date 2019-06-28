//Jeffrey Weng
//APCS2 pd3
//HW35 -- BSTs is in the Perfect Place for Shade
//2017-05-04

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
 public void insert( int newVal ) 
    {
	TreeNode newNode = new TreeNode( newVal );

	if ( root == null ) {
	    root = newNode;
	    return;
	}
        insert( root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode ) {

	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
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

    public boolean isLeaf(TreeNode node){
	if(node.getRight() == null && node.getLeft() == null){
	    return true;
	}
	return false;
    }


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	return search(target,root);
    }

    
    //this doesnt work, even though its going to the right nodes, doesn't return the correct pointer. 
    public TreeNode search(int target, TreeNode item){
	if(target < item.getValue()){    
	    if(item.getLeft() == null){
		return null;
	    }
	    else{
		System.out.println("hi");
		return search(target, item.getLeft());
	    }
		
	}
	else if(target > item.getValue()){
	    if(item.getRight() == null){
		return null;
	    }
	    else{
		System.out.println("what");
	      return search(target, item.getRight());
	    }

	}
	else{
	    System.out.println("yolo");
	    // System.out.println(root);
	    return item;
	}
	
    }
    

    
    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
	return height(root);
    }

    //helper method for height
    public int height(TreeNode node){
	//if node is null then it contains nothing therefore having height 0
	if(node == null){
	    return 0;
	}
	//finds the height of the left and right subtrees
	//recursively doing this until it reaches null
	else{
	    if(height(node.getLeft()) > height(node.getRight())){
		return 1 + height(node.getLeft());
	    }
	    else{
		return 1 + height(node.getRight());
	    }
	}
    }
   

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    
    public int numLeaves()
    {
	return nodeLeaves(root);
    }

    //recursive helper 
    //yea this is bad recursion 
    int numLeaves = 0; // using an instance variable to store the value
    public int nodeLeaves(TreeNode node){
	
	//recursively look through the node until you reach a point where a node doesn't have left or right filled node
	if(node.getLeft() != null){
	    nodeLeaves(node.getLeft());
	}
	if(node.getRight() != null){
	    nodeLeaves(node.getRight());
	}
	//tests it here
	if(isLeaf(node)){	    
	    return numLeaves += 1;
	}

	return numLeaves;
    }

    


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
	
	  System.out.println(arbol.search(6));
	  System.out.println(arbol.height());
	  System.out.println(arbol.numLeaves());
	      	
	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();	
/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  //insert your new test calls here...
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class

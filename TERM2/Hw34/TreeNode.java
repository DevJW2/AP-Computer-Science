//Jeffrey Weng
//APCS2 - pd 3
//HW34 -- Algorithm as Data Structure
//2017-05-03

/*****************************************************
 * class TreeNode
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 *****************************************************/

public class TreeNode 
{
    //instance variables / attributes of a TreeNode:
    int cargo; 
    TreeNode left; 
    TreeNode right; 

    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( int initValue )
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	cargo = initValue; 
	left = null;
	right = null;
    }
          

    /*****************************************************
     * overloaded constructor
     * Construct a tree node with specified
     * value, left, and right subtrees.
     *****************************************************/
    TreeNode( int initValue, TreeNode initLeft, TreeNode initRight ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	cargo = initValue; 
	left = initLeft; 
	right = initRight;
    }
 

    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	return left;
    }


    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	return right;
    }


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    int getValue() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	return cargo;
    }


    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode theNewLeft ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	left = theNewLeft;
    }


    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode theNewRight ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	right = theNewRight;
    }


    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue( int theNewValue ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	cargo = theNewValue;
    }
 
}//end class

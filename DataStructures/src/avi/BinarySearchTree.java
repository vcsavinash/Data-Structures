package avi;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{

	/** The tree root. */
	private BinaryNode<AnyType> root;
	/**
	 * Construct the tree.
	 */
	public BinarySearchTree( )
	{
		root = null;
	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 * @param x the item to insert.
	 */
	public void insert( AnyType x )
	{
		root = insert( x, root );
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * @param x the item to remove.
	 */
	public void remove( AnyType x )
	{
		root = remove( x, root );
	}

	/**
	 * Find the smallest item in the tree.
	 * @return smallest item or null if empty.
	 * @throws Exception 
	 */
	public AnyType findMin( ) throws Exception
	{
		if( isEmpty( ) )
			throw new Exception( );
		return findMin( root ).element;
	}

	/**
	 * Find the largest item in the tree.
	 * @return the largest item of null if empty.
	 * @throws Exception 
	 */
	public AnyType findMax( ) throws Exception
	{
		if( isEmpty( ) )
			throw new Exception( );
		return findMax( root ).element;
	}

	/**
	 * Find an item in the tree.
	 * @param x the item to search for.
	 * @return true if not found.
	 */
	public boolean contains( AnyType x )
	{
		return contains( x, root );
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty( )
	{
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return root == null;
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree( )
	{
		if( isEmpty( ) )
			System.out.println( "Empty tree" );
		else
			printTree( root );
	}
	
	public void printTree1( )
	{
		if( isEmpty( ) )
			System.out.println( "Empty tree" );
		else
			printTree1( root );
	}

	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null )
			return new BinaryNode<>( x, null, null );

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			t.left = insert( x, t.left );
		else if( compareResult > 0 )
			t.right = insert( x, t.right );
		else
			;  // Duplicate; do nothing
		return t;
	}

	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null )
			return t;   // Item not found; do nothing

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			t.left = remove( x, t.left );
		else if( compareResult > 0 )
			t.right = remove( x, t.right );
		else if( t.left != null && t.right != null ) // Two children
		{
			t.element = findMin( t.right ).element;
			t.right = remove( t.element, t.right );
		}
		else
			t = ( t.left != null ) ? t.left : t.right;
		return t;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node containing the smallest item.
	 */
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
	{
		if( t == null )
			return null;
		else if( t.left == null )
			return t;
		return findMin( t.left );
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the subtree.
	 * @return node containing the largest item.
	 */
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
	{
		if( t != null )
			while( t.right != null )
				t = t.right;

		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the subtree.
	 * @return node containing the matched item.
	 */
	private boolean contains( AnyType x, BinaryNode<AnyType> t )
	{
		if( t == null )
			return false;

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			return contains( x, t.left );
		else if( compareResult > 0 )
			return contains( x, t.right );
		else
			return true;    // Match
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * @param t the node that roots the subtree.
	 */
		private void printTree( BinaryNode<AnyType> t )
	{
		if( t != null )
		{			
			printTree( t.left );
			System.out.print( t.element+" ");
			printTree( t.right );
		}
	}
		
		private void printTree1( BinaryNode<AnyType> t )
		{
			if( t != null )
			{
				System.out.println( t.element+" " );
				printTree1( t.left );			
				printTree1( t.right );
			}
		}


	/**
	 * Internal method to compute height of a subtree.
	 * @param t the node that roots the subtree.
	 */
	private int height( BinaryNode<AnyType> t )
	{
		if( t == null )
			return -1;
		else
			return 1 + Math.max( height( t.left ), height( t.right ) );    
	}

	// Basic node stored in unbalanced binary search trees
	private static class BinaryNode<AnyType>
	{
		// Constructors
		BinaryNode( AnyType theElement )
		{
			this( theElement, null, null );
		}

		BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
		{
			element  = theElement;
			left     = lt;
			right    = rt;
		}

		AnyType element;            // The data in the node
		BinaryNode<AnyType> left;   // Left child
		BinaryNode<AnyType> right;  // Right child
	}

	// a - Method to obtain the count of nodes in the tree

	private int nodeCount(BinaryNode<AnyType> t)
	{
		if(t==null)
			return 0;
		else
		{
			return 1+nodeCount(t.left)+nodeCount(t.right);
		}
	}


	public int nodeCount()
	{
		return nodeCount(root);
	}

	// b - Method to check if the tree is full

	private boolean isFull(BinaryNode<AnyType> t)
	{
		if(t==null)
			return true;

		if(t.left==null && t.right==null)
			return true;

		if((t.left!=null)&&(t.right!=null))
		{
			return(isFull(t.left)&&(isFull(t.right)));
		}
		return false;
	}

	public boolean isFull()
	{
		return isFull(root);
	}

	// c - Method to compare the structure of 2 trees

	private boolean compareStructure1(BinaryNode<AnyType> t, BinaryNode<AnyType> t1)
	{
		if(t==null && t1==null)
			return true;
		if(t!=null && t1!=null)
			return (compareStructure1(t.left, t1.left)&& compareStructure1(t.right, t1.right));
		return false;
	}

	public boolean compareStructure(BinaryNode<AnyType> t,BinaryNode<AnyType> t1)
	{
		return compareStructure(t,t1);
	}

	// d - Method to check if 2 trees are identical

	private boolean equals1(BinaryNode<AnyType> t, BinaryNode<AnyType> t1)
	{
		if(t==null && t1==null)
			return true;
		if((t!=null && t1!=null)&&(t.element==t1.element))
			return (equals1(t.left, t1.left)&& equals1(t.right, t1.right));

		return false;
	}

	public boolean equals(BinaryNode<AnyType> t, BinaryNode<AnyType> t1)
	{
		return equals1(t,t1);
	}

	// e - Copy a tree to another

	private BinaryNode<AnyType> copy1(BinaryNode<AnyType> t)
	{
		BinaryNode<AnyType> newNode=null;
		if(t!=null)
		{
			newNode = new BinaryNode<>(t.element,t.left,t.right);
			copy1(t.left);
			copy1(t.right);
		}
		return newNode;
	}

	public BinaryNode<AnyType> copy(BinaryNode<AnyType> t)
	{
		return copy1(t);
	}

	// f - Method to create a mirror image of the given tree

	private BinaryNode<AnyType> mirror1(BinaryNode<AnyType> t)
	{
		if(t==null)
			return t;

		BinaryNode n1=mirror1(t.left);
		BinaryNode n2=mirror1(t.right);
		t.left=n2;
		t.right=n1;
		return t;
	}

	public BinaryNode<AnyType> mirror(BinaryNode<AnyType> t)
	{
		return mirror1(t);
	}

	// g - Method to check if trees are mirror images of each other

	private boolean isMirror1(BinaryNode<AnyType> t, BinaryNode<AnyType> t1)
	{
		BinaryNode mirnode=mirror(t1);
		if(mirnode==t)
			return true;
		else
			return false;
	}

	public boolean isMirror(BinaryNode<AnyType> t, BinaryNode<AnyType> t1)
	{
		return isMirror1(t, t1);
	}

	// method to find the parent node

	private BinaryNode<AnyType> findParentNode1(BinaryNode<AnyType> t, AnyType x)
	{
		if(t == null)
			return null;
		else if(t == root && (x.compareTo(root.element)== 0))
			return t;
		else
		{
			if((t.left!= null && (x.compareTo(t.left.element) == 0)) || (t.right!= null && (x.compareTo(t.right.element) == 0)))
				return t;
			else
			{
				BinaryNode<AnyType> temp = findParentNode1(t.left,x);
				if(temp == null)
					return findParentNode1(t.right,x);
				else
					return temp;
			}
		}
	}

	public BinaryNode<AnyType> findParentNode(BinaryNode<AnyType> t, AnyType x)
	{
		return findParentNode1(t, x);
	}

	private BinaryNode<AnyType> find1(  BinaryNode<AnyType> t ,AnyType x)
	{
		if( t == null )
			return t;

		int compareResult = x.compareTo( t.element );

		if( compareResult < 0 )
			return find1(t.left, x );
		else if( compareResult > 0 )
			return find1(t.right, x );
		else
			return t;    
	}

	public BinaryNode<AnyType> find(BinaryNode<AnyType> t, AnyType x )
	{
		return find1(t, x );
	}
	
	// h - Method to rotate right

	private BinaryNode<AnyType> rotateRight1(BinaryNode<AnyType>t, AnyType x)
	{
		BinaryNode<AnyType> no=find(t,x);
		BinaryNode<AnyType> parno=findParentNode(t,x);

		if(no==parno)
		{
			BinaryNode temp1=parno.left;
		    BinaryNode temp2=parno.right;
		    BinaryNode temp3=parno.left.right;
		    parno.left=null;
		    parno.right=null;
		    temp1.right=null;
		    root=temp1;
		    root.right=parno;
		    root.right.left=temp3;
		    root.right.right=temp2;
		}
		

		if(no.element.compareTo(parno.element)<0)
		{
			BinaryNode temp = parno.left;
			parno.left=no.left;
			temp.left=null;
			BinaryNode tempr=parno.left.right;
			parno.left.right=temp;
			parno.left.right.left=tempr;
		}

		if(no.element.compareTo(parno.element)>0)
		{
			BinaryNode temp = parno.right;		
			parno.right=no.left;
			temp.left=null;
			BinaryNode tempr=parno.right.right;
			parno.right.right=temp;
			parno.right.right.left=tempr;

		}
		return t;
	}

	public BinaryNode<AnyType> rotateRight(BinaryNode<AnyType> t,AnyType x)
	{
		return rotateRight1(t,x);
	}

	// i - Method to rotate left
	
	private BinaryNode<AnyType> rotateLeft1(BinaryNode<AnyType>t, AnyType x)
	{
		BinaryNode<AnyType> no=find(t,x);
		BinaryNode<AnyType> parno=findParentNode(t,x);

		if(no==parno)
		{
		    BinaryNode temp1=parno.left;
		    BinaryNode temp2=parno.right;
		    BinaryNode temp3=parno.right.left;
		    parno.left=null;
		    parno.right=null;
		    temp2.left=null;
		    root=temp2;
		    root.left=parno;
		    root.left.right=temp3;
		    root.left.left=temp1;
		}

		
		if(no.element.compareTo(parno.element)<0)
		{
			BinaryNode temp=parno.left;
			parno.left=no.right;
			temp.right=null;
			BinaryNode templ=parno.left.left;
			parno.left.left=temp;
			parno.left.left.right=templ;
		}
		
		if(no.element.compareTo(parno.element)>0)
		{
			BinaryNode temp=parno.right;
			parno.right=no.right;
			temp.right=null;
			BinaryNode templ=parno.right.left;
			parno.right.left=temp;
			parno.right.left.right=templ;
		}
		return t;
	}
	
	public BinaryNode<AnyType> rotateLeft(BinaryNode<AnyType> t,AnyType x)
	{
		return rotateLeft1(t,x);
	}

	// j - Method to print tree by levels
	
	 void printLevel()
	    {
	        int h = height(root);
	        int i;
	        for (i=1; i<=h+1; i++)
	            printGivenLevel(root, i);
	    }
	 void printGivenLevel(BinaryNode root ,int level)
	    {
		 
	        if (root == null)
	            return;
	        if (level == 1)
	        {
	            System.out.print(root.element + " ");
	        }
	        else if (level > 1)
	        {
	            printGivenLevel(root.left, level-1);
	            printGivenLevel(root.right, level-1);
	        }
	    }

	// Test program
	public static void main( String [ ] args ) throws Exception
	{
		BinarySearchTree<Integer> t = new BinarySearchTree<>( );
		BinarySearchTree<Integer> t1 = new BinarySearchTree<>( );
		BinarySearchTree<Integer> t2 = new BinarySearchTree<>( );

		//final int NUMS = 4000;

		t.insert( 10);
		t.insert( 5);
		t.insert( 4);          
		t.insert( 6);
		t.insert( 12);
		t.insert( 11);
		t.insert( 14);

		t.printTree();
		System.out.println();

		int c=t.nodeCount();
		System.out.println("Node Count is "+c);


		if(t.isFull())
			System.out.println("Tree is full");
		else
			System.out.println("Tree is not full");

		t1.insert( 10);
		t1.insert( 5);
		t1.insert( 4);          
		t1.insert( 6);
		t1.insert( 12);
		t1.insert( 11);
		t1.insert( 18);

		if(t.compareStructure(t.root,t1.root))
			System.out.println("The structures match");
		else
			System.out.println("The structures do not match");

		if(t.equals(t.root,t1.root))
			System.out.println("The trees are identical");
		else
			System.out.println("The trees are not identical");


		BinaryNode n=t.copy(t.root);
		System.out.println("The copied tree is");
		t.printTree(n);
		System.out.println();

		BinaryNode mir=t.mirror(t.root);
		System.out.println("The mirror tree is");
		t.printTree(mir);
		System.out.println();


		if(t.isMirror(mir,t.root))
			System.out.println("The passesd trees are the mirrors of each other");
		else
			System.out.println("The passesd trees are not the mirrors of each other");


		System.out.println("Level by level printing of Right Rotated tree");
		t.rotateRight(t.root, 5);                              // Rotate Right
		t.printLevel();                                        // Level by level printing
		System.out.println();
		
		System.out.println("Level by level printing of Left Rotated tree");
		t.rotateLeft(t.root, 12);                              // Rotate Left
		t.printLevel();                                        // Level by level printing
		System.out.println();
	
	/*	BinaryNode rol=t.rotateLeft(t.root, 10);
		t.printTree1(rol);
		System.out.println();
    */
		
		/*
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( i );

        if( NUMS < 40 )
            t.printTree();
        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i+=2 )
             if( !t.contains( i ) )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( t.contains( i ) )
                System.out.println( "Find error2!" );
        }
		 */
	}
}

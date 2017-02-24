package avi.InsertAVLTree;

import java.lang.Math;

/**
 * @author avinash
 *
 */
public class InsertAVLTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node start = null;
		Node first = insertAVLTree(7,start);
		inOrder(first);
		System.out.println(" ");
		Node second = insertAVLTree(9, first);
		inOrder(second);
		System.out.println(" ");
		Node third = insertAVLTree(13, second);
		inOrder(third);
		System.out.println(" ");
		Node fourth = insertAVLTree(21, third);
		inOrder(fourth);
		System.out.println(" ");
		Node fifth = insertAVLTree(34, fourth);
		inOrder(fifth);
		System.out.println(" ");
		Node sixth = insertAVLTree(36, fifth);
		inOrder(sixth);
		System.out.println(" ");
		Node seventh = insertAVLTree(45, sixth);
		inOrder(seventh);
		System.out.println(" ");
		Node eighth = insertAVLTree(54, seventh);
		inOrder(eighth);
		System.out.println(" ");
		Node ninth = insertAVLTree(65, eighth);
		inOrder(ninth);
		System.out.println(" ");
		Node tenth = insertAVLTree(87, ninth);
		inOrder(tenth);
		System.out.println(" ");
	}

	/**
	 * This method inserts each key into the AVL tree either left or right depending on the value of the key.
	 * @param n
	 * @param root
	 * @return
	 */
	public static Node insertAVLTree(int n, Node root){
		int left,rHeight,right,rightLeft,leftRight,rightRight, leftLeft;
		Node prevRoot = root;
		root = findChild(root,n);
			if(root == null){
				root = new Node(n, null, null, null,0);
				return root;
			}else if(n > root.getKey()){
				root.setRChild(new Node(n,root,null,null,0));
				root.getRChild().setParent(root);
				height(root);
					height(root.getLChild());
					
					while(root !=null){
						height(root);
						height(root.getLChild());
						height(root.getRChild());
						if(root.getLChild()!=null){
							left = root.getLChild().getHeight();
						}else{
							left = -1;
						}
						if(root.getRChild()!=null){
							rHeight = root.getRChild().getHeight();
						}else{
							rHeight = -1;
						}
						if(Math.abs(rHeight-left)>=2){
							if(left>rHeight){
								if(root.getLChild().getRChild()!=null){
									leftRight = root.getLChild().getRChild().getHeight();
								}else{
									leftRight = -1;
								}
								if(root.getLChild().getLChild()!=null){
									leftLeft = root.getLChild().getLChild().getHeight();
								}else{
									leftLeft = -1;
								}
								if(leftLeft < leftRight){
									root.getLChild().setParent(root.getLChild().getRChild());
									root.getLChild().getRChild().setParent(root);
									root.getLChild().getRChild().setLChild(root.getLChild());
									root.setLChild(root.getLChild().getRChild());
									root.getLChild().getLChild().setRChild(null);
								}
								root.getLChild().setParent(root.getParent());
								if(root.getParent()!=null){
									root.getParent().setLChild(root.getLChild());
								}
								if(root.getLChild().getRChild() != null){
									root.getLChild().getRChild().setParent(root);
								}
								root.setParent(root.getLChild());
								if(root.getLChild().getRChild()!=null){
									root.setLChild(root.getLChild().getRChild());
								}else{
									root.setLChild(null);
								}
								root.getParent().setRChild(root);
							
							}else{
								if(root.getRChild().getLChild()!=null){
									rightLeft = root.getRChild().getLChild().getHeight();
								}else{
									rightLeft = -1;
								}
								if(root.getRChild().getRChild()!=null){
									rightRight = root.getRChild().getRChild().getHeight();
								}else{
									rightRight = -1;
								}
								if(rightRight < rightLeft){
									root.getRChild().setParent(root.getRChild().getLChild());
									root.getRChild().getLChild().setParent(root);
									root.getRChild().getLChild().setRChild(root.getRChild());
									root.setRChild(root.getRChild().getLChild());
									root.getRChild().getRChild().setLChild(null);
								}
								root.getRChild().setParent(root.getParent());
								if(root.getParent()!=null){
									root.getParent().setRChild(root.getRChild());
								}
								if(root.getRChild().getLChild() != null){
									root.getRChild().getLChild().setParent(root);
								}
								root.setParent(root.getRChild());
								if(root.getRChild().getLChild()!=null){
									root.setRChild(root.getRChild().getLChild());
								}else{
									root.setRChild(null);
								}
								root.getParent().setLChild(root);
							}
							height(root.getLChild());
							height(root);
							height(root.getRChild());
							root = root.getParent();
							height(root.getLChild());
							height(root);
							height(root.getRChild());
						}
						prevRoot = root;
						root = root.getParent();
					}
					return prevRoot;
			}
			else if(n < root.getKey()){
				root.setLChild(new Node(n,root,null,null,0));
				root.getLChild().setParent(root);
				height(root);
					
					while(root!=null){
						height(root);
						height(root.getLChild());
						height(root.getRChild());
						if(root.getRChild()!=null){
							right = root.getRChild().getHeight();
						}else{
							right =-1; 
						}
						if(root.getLChild()!=null){
							rHeight = root.getLChild().getHeight();
						}else{
							rHeight = -1;
						}
						
						if(Math.abs(rHeight-right)>=2){
							if(right>rHeight){
								if(root.getRChild().getLChild()!=null){
									rightLeft = root.getRChild().getLChild().getHeight();
								}else{
									rightLeft = -1;
								}
								if(root.getRChild().getRChild()!=null){
									rightRight = root.getRChild().getRChild().getHeight();
								}else{
									rightRight = -1;
								}
								if(rightRight < rightLeft){
									root.getRChild().setParent(root.getRChild().getLChild());
									root.getRChild().getLChild().setParent(root);
									root.getRChild().getLChild().setRChild(root.getRChild());
									root.setRChild(root.getRChild().getLChild());
									root.getRChild().getRChild().setLChild(null);
								}
								root.getRChild().setParent(root.getParent());
								if(root.getParent()!=null){
									root.getParent().setLChild(root.getRChild());
								}
								if(root.getRChild().getLChild() != null){
									root.getRChild().getLChild().setParent(root);
								}
								root.setParent(root.getRChild());
								if(root.getRChild().getLChild()!=null){
									root.setRChild(root.getRChild().getLChild());
								}else{
									root.setRChild(null);
								}
								root.getParent().setLChild(root);
							}else{
								if(root.getLChild().getRChild()!=null){
									leftRight = root.getLChild().getRChild().getHeight();
								}else{
									leftRight = -1;
								}
								if(root.getLChild().getLChild()!=null){
									leftLeft = root.getLChild().getLChild().getHeight();
								}else{
									leftLeft = -1;
								}
								if(leftLeft < leftRight){
									root.getLChild().setParent(root.getLChild().getRChild());
									root.getLChild().getRChild().setParent(root);
									root.getLChild().getRChild().setLChild(root.getLChild());
									root.setLChild(root.getLChild().getRChild());
									root.getLChild().getLChild().setRChild(null);
									
								}
								root.getLChild().setParent(root.getParent());
								if(root.getParent()!=null){
									root.getParent().setLChild(root.getLChild());
								}
								if(root.getLChild().getRChild() != null){
									root.getLChild().getRChild().setParent(root);
								}
								root.setParent(root.getLChild());
								if(root.getLChild().getRChild()!=null){
									root.setLChild(root.getLChild().getRChild());
								}else{
									root.setLChild(null);
								}
								root.getParent().setRChild(root);
							}
							
							height(root.getLChild());
							height(root);
							height(root.getRChild());
								root = root.getParent();
								height(root.getLChild());
								height(root);
								height(root.getRChild());
						}
						prevRoot = root;
						root = root.getParent();
					}
				return prevRoot;
			}
		return root;
	}
	
	/**
	 * This method sets the height of each Node when added.
	 * @param root
	 */
	public static void height(Node root){
		int heightl=0,heightr=0;
		if(root!=null){
			if(root.getRChild() != null){
				heightr = root.getRChild().getHeight()+1;
			}else{
				heightr = 0;
			}
			if(root.getLChild() != null){
				heightl = root.getLChild().getHeight()+1;
			}else{
				heightl=0;
			}
			if(heightr > heightl){
				root.setHeight(heightr);
			}else if(heightl>heightr){
				root.setHeight(heightl);
			}else if(heightr==heightl){
				root.setHeight(heightr);
			}else{
				root.setHeight(0);
			}
		}
	}
	
	/**
	 * This method prints the in-order traversal of keys inserted into AVL Tree.
	 * @param root
	 */
	public static void inOrder(Node root){
		if(root!=null){
			inOrder(root.getLChild());
			System.out.print(root.getKey()+" ");
			inOrder(root.getRChild());
			}
	}
	
	/**
	 * This method finds the Child where the Node n has to be inserted.
	 * @param root
	 * @param n
	 * @return
	 */
	public static Node findChild(Node root, int n){
		if(root==null){
			return root;
		}else{
			while((root.getRChild()!=null) || (root.getLChild()!=null)){
				if(n>root.getKey() && root.getRChild()!=null){
					root = root.getRChild();
				}else if(n<root.getKey() && root.getLChild()!=null){
					root = root.getLChild();
				}else
					return root;
			}
		}
		return root;
	}
}

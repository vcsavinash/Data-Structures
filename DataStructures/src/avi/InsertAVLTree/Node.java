/**
 * 
 */
package avi.InsertAVLTree;

/**
 * @author avinash
 * The Node structure is defined as below
 */
public class Node {
	private int key;
	private int height;
	private Node leftChild;
	private Node rightChild;
	private Node parent;
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Node getLChild() {
		return leftChild;
	}
	public void setLChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRChild() {
		return rightChild;
	}
	public void setRChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node(int n, Node p, Node l, Node r, int h){
		key = n;
		parent = p;
		leftChild = l;
		rightChild = r;
		height = h;
	}
}

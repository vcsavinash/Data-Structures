/**
 * 
 */
package avi.assignment4;

/**
 * @author avinash
 */
public class Node {
	int value;
	Node node;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	
	public Node(int i){
		this.value = i;
	}
	
}

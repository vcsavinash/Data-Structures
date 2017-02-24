/**
 * 
 */
package avi.assignment;

import avi.assignment.Node;

/**
 * @author avinash
 */
public class Node {
		private int element; 
		private Node next; 
		public Node(int e){
			element = e;
		}
		public Node(int e, Node n) { 
			element = e;
			next = n;
		} 
		public void setElement(int element) {
			this.element = element;
		}
		public int getElement( ) throws IllegalStateException { 
			return element;
		} 
		public Node getNext( ) { 
			return next;
		} 
		public void setNext(Node n) { 
			this.next = n;
		} 
    }

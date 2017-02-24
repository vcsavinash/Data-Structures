/**
 * 
 */
package avi.assignment;

import avi.assignment.Node;

/**
 * This class is used to add the integer values in the list.
 * @author avinash
 */
public class SingleLinkedListAddition {
	/**
	 * This method is used for adding the integers in the list.
	 * @param head
	 * @return
	 */
	public static int add_list(Node head){
		if(head == null){
			return 0;
		}
		return (head.getElement()+add_list(head.getNext()));
	}
}

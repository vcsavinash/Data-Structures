/**
 * 
 */
package avi.assignment;

import avi.assignment.Node;

/**
 * This class is for getting the count of number of 5's in the list.
 * @author avinash
 */
public class SingleLinkedListCount {
	/**
	 * This method is used for counting the value 5 in the list.
	 * @param head
	 * @param five
	 * @return
	 */
	public static int count_d(Node head,int five){
		if(head.getElement() != five && head.getNext()==null){
			return 0;
		} else if(head.getElement() == five && head.getNext()==null){
			return 1;
		} else if(head.getElement() == five){
			return 1+count_d(head.getNext(),five);
		} else 
			return count_d(head.getNext(),five);
	}
}

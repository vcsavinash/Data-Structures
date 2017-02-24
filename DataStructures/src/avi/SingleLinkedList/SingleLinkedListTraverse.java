/**
 * 
 */
package avi.assignment;

/**
 * This Class is for traversing the integer values in the list.
 * @author avinash
 */
public class SingleLinkedListTraverse {
	/**
	 * This is the main method which initiates the other methods call.
	 * @param args
	 */
	public static void main(String[] args){
		Node head = insert(null,2);
		Node head3 = insert(head,5);
		Node head4 = insert(head3,0);
		Node head5 = insert(head4,5);
		Node head6 = insert(head5,2);
		Node head7 = insert(head6,5);
		Node head8 = insert(head7,1);
		Node head9 = insert(head8,5);
		Node head10 = insert(head9,3);
		Node head11 = insert(head10,5);
		Node head12 = insert(head11,3);
		Node head13 = insert(head12,5);
		Node head14 = insert(head13,8);
		Node head15 = insert(head14,5);
		Node head16 = insert(head15,2);
		Node head17 = insert(head16,5);
		Node head18 = insert(head17,7);
		Node head19 = insert(head18,5);
		Node head20 = insert(head19,4);
		insert(head20,5);
		if(head != null){
			Boolean value = traverse(head);
			if(value){
				System.out.println("The traverse is success");
				System.out.println("The no of occurences of the digit 5 is : "+SingleLinkedListCount.count_d(head,5));
				System.out.println("The occurence of 6 is "+SingleLinkedListCount.count_d(head,6));
				System.out.println("The sum of all the integers is "+SingleLinkedListAddition.add_list(head));
			}else
				System.out.println("There is some issue with the traversal or no head available");
		}else
			System.out.println("The value of head is invalid");
	}
	
	/**
	 * This method is used to insert the integer values into a list.
	 * @param head
	 * @param n
	 * @return Node
	 */
	public static Node insert(Node head, int n){
		if(head == null){
			head = new Node(n);
			return head;
		} else if(head.getNext() == null){
			head.setNext(new Node(n));
			return head;
		} else if(head.getNext() != null){
			insert(head.getNext(), n);
		}
		return head;
	}
	
	/**
	 * This method is used for traversing the integer values in the list and print them.
	 * @param head
	 * @return
	 */
	public static boolean traverse(Node head){
		if(head == null){
			return false;
		}
		if(head.getNext() != null){
			System.out.println("The value in the list is "+head.getElement());
			traverse(head.getNext());
		} else {
			System.out.println("The tail of list is "+head.getElement());
		}
		return true;
	}
}

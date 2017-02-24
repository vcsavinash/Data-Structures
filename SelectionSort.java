/**
 * 
 */
package avi.assignment2;

import avi.assignment2.Node;

/**
 * @author avinash
 */
public class SelectionSort {
	/**
	 * This is the main method which initiates the other methods call.
	 * @param args
	 */
	public static void main(String[] args){
		//Random rand = new Random();
		//int  n = rand.nextInt(50) + 1;
		Node head = insert(null,1);
		Node head2 = insert(head,6);
		Node head3 = insert(head2,10);
		Node head4 = insert(head3,0);
		Node head5 = insert(head4,-1);
		Node head6 = insert(head5,3);
		Node head7 = insert(head6,3);
		Node head8 = insert(head7,8);
		Node head9 = insert(head8,2);
		Node head10 = insert(head9,7);
		insert(head10,4);
		if(head != null){
			Boolean value = traverse(head);
			if(value){
				System.out.println("The traverse is success and the sorted order is as follows:");
				head = SelectionSorting(head);
				traverse(head);
			}else
				System.out.println("There is some issue with the traversal or no head available");
		}else
			System.out.println("The value of head is invalid");
	}
	
	/**
	 * This method sorts the numbers in the single linked list in ascending order using selection sort, by swapping the links.
	 * @param head
	 * @return
	 */
	public static Node SelectionSorting(Node head){
		Node currentprev = null;
		Node current = head;
		Node current2;
		Node current4;
		Node nextprev;
		Node beforesort;
		Node min;
		Node current5;
		while(current != null){
			min = current;
			nextprev = current;
			beforesort = nextprev;
			current2 = current.getNext();
			while(current2 != null){
				if(min.getElement() > current2.getElement()){   //Finding the minimum element
					beforesort = nextprev;
					min = current2;
				}
				nextprev = current2;
				current2 = current2.getNext();
			}
			if(current.getNext()==min){                        //When minimum is adjacent to the current node

				if(currentprev == null){					   //When current is the first node
					current5=min.getNext();
					int temp = current.getElement();
					current.setElement(min.getElement());
					min.setElement(temp);
					current.setNext(min);
					min.setNext(current5);
					currentprev = current;
				}else{
					current5=min.getNext();
					currentprev.setNext(min);
					min.setNext(current);
					current.setNext(current5);
					current=min;
				}
			}else if(current.getNext()!=min && current!=min){

				if(currentprev == null){
					current4=current.getNext();            
					current5=min.getNext();            
					int temp = min.getElement();
					int temp1 = current.getElement();
					current.setElement(temp);
					min.setElement(temp1);
					beforesort.setNext(min); 
					current.setNext(current4);
					currentprev = current;
					//min.setNext(current5);
				}else {
					current4=current.getNext();            
					current5=min.getNext();           
					currentprev.setNext(min);               
					min.setNext(current4);
					beforesort.setNext(current);
					current.setNext(current5);
					current=min;
				}
			}
			currentprev = current;
			current = current.getNext();
		}
		return head;
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

/**
 * 
 */
package avi.assignment5;

/**
 * @author avinash
 *
 */
public class Node implements Comparable<Node>{
	int num;
	String name;
    Edge[] adjacencies;
    double minDistance = Double.POSITIVE_INFINITY;
    Node previous;
    Node next;
    Node(int number) { 
    	num = number; 
    }
    
    public Node(String argName) { 
    	name = argName; 
    }
    
    public String toString() { 
    	return name; 
    }
    
    public int compareTo(Node node){
        return Double.compare(minDistance, node.minDistance);
    }
}

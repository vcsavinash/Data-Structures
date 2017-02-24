/**
 * 
 */
package avi.DijkstraAlgorithm;

/**
 * @author avinash
 *
 */
public class Edge {
	 	Node finalNode;
	    double weight;
	    
	    public Edge(Node argTarget, double argWeight){ 
	    	finalNode = argTarget; 
	    	weight = argWeight; 
	    }
}

/**
 * 
 */
package avi.assignment5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import avi.assignment5.Edge;
import avi.assignment5.Node;

/**
 * @author avinash
 *
 */
public class DijkshtraAlgorithm {

	/**
	 * This method is used to compute the shortest paths
	 * @param source
	 */
	public static void computePaths(Node source)
    {
        source.minDistance = 0.;
        PriorityQueue<Node> Queue = new PriorityQueue<Node>();
        Queue.add(source);

    while (!Queue.isEmpty()) {
    	Node u = Queue.poll();
        System.out.println(u.num +"    : "+ u.minDistance);
        if(u.adjacencies!=null){
            for (Edge e : u.adjacencies){
            	Node v = e.finalNode;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		        if (distanceThroughU < v.minDistance) {
		        	Queue.remove(v);
		            v.minDistance = distanceThroughU ;
		            v.previous = u;
		            Queue.add(v);
		        }
            }
        }
    }
    }

    /**
     * This method is used to get the shortest path from node 1 to 7
     * @param lastNode
     * @return
     */
    public static List<Node> getShortestPathTo(Node lastNode)
    {
        List<Node> path = new ArrayList<Node>();
        for (Node node = lastNode; node != null; node = node.previous)
            path.add(node);
        	
        return path;
    }

    /**
     * This is main method.
     * @param args
     */
    public static void main(String[] args)
    {
    	Node A = new Node(1);
    	Node B = new Node(2);
    	Node C = new Node(3);
    	Node D = new Node(4);
    	Node E = new Node(5);
    	Node F = new Node(6);
    	Node G = new Node(7);

    	System.out.println("Adjacency List: Start Node is 1");
        A.adjacencies = new Edge[]{ new Edge(B, 2) ,new Edge(C, 3),new Edge(D, 8),new Edge(E, 9)};
        System.out.print("1");
        for(Edge a : A.adjacencies){
        	System.out.print(" -> "+ a.finalNode.num +" " +a.finalNode.minDistance);
        }
        System.out.println();
        B.adjacencies = new Edge[]{ new Edge(D, 4),new Edge(E, 10),new Edge(G, 12)  };
        System.out.print("2");
        for(Edge a : B.adjacencies){
        	System.out.print(" -> "+ a.finalNode.num +" " +a.finalNode.minDistance);
        }
        System.out.println();
        C.adjacencies = new Edge[]{ new Edge(D, 11),new Edge(E, 5) ,new Edge(F, 13)  };
        System.out.print("3");
        for(Edge a : C.adjacencies){
        	System.out.print(" -> "+ a.finalNode.num +" " +a.finalNode.minDistance);
        }
        System.out.println();
        D.adjacencies = new Edge[]{ new Edge(F, 6),new Edge(G, 14)  };
        System.out.print("4");
        for(Edge a : D.adjacencies){
        	System.out.print(" -> "+ a.finalNode.num +" " +a.finalNode.minDistance);
        }
        System.out.println();
        E.adjacencies = new Edge[]{ new Edge(F, 15),new Edge(G, 7) };
        System.out.print("5");
        for(Edge a : E.adjacencies){
        	System.out.print(" -> "+ a.finalNode.num +" " +a.finalNode.minDistance);
        }
        System.out.println();
        F.adjacencies = new Edge[]{ new Edge(G, 16) };
        System.out.print("6");
        for(Edge a : F.adjacencies){
        	System.out.print(" -> "+ a.finalNode.num +" " +a.finalNode.minDistance);
        }
        System.out.println();
        G.adjacencies = new Edge[]{ };
        System.out.print("7");
        for(Edge a : G.adjacencies){
        	System.out.print(" -> "+ a.finalNode.num +" " +a.finalNode.minDistance);
        }
        System.out.println();
        System.out.println("Node : Short distance from Node 1");
        computePaths(A); 
        System.out.println();
        List<Node> path = getShortestPathTo(G);
        int i = path.lastIndexOf(A);
        System.out.print("The shortest path from node 1 to 7 is: ");
        while(i>=0){
        	if(path.get(i).num != 7)
        		System.out.print(path.get(i).num +" -> ");
        	else
        		System.out.print(path.get(i).num );
        	i--;
        }
        System.out.print(" with distance : "+ G.minDistance);
    }
}
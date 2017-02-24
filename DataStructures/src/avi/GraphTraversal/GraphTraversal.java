/**
 * 
 */
package avi.GraphTraversal;

import java.util.LinkedList;

/**
 * @author avinash
 *
 */
public class GraphTraversal {
	
	public static LinkedList<Node> adjacenyList[];
	
	@SuppressWarnings({ "unchecked" })
	GraphTraversal(){
		adjacenyList = new LinkedList[29];
		for(int i=0; i<29; i++){
			adjacenyList[i] = new LinkedList<Node>();
		}
	}
	
	/**
	 * This method calls the other subsequent methods of the class
	 * @param args 
	 */
	public static void main(String[] args) {
		GraphTraversal graph = new GraphTraversal();
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		Node eleven = new Node(11);
		Node twelve = new Node(12);
		Node thirteen = new Node(13);
		Node fourteen = new Node(14);
		Node fifteen = new Node(15);
		Node sixteen = new Node(16);
		Node seventeen = new Node(17);
		Node eighteen = new Node(18);
		Node nineteen = new Node(19);
		Node twenty = new Node(20);
		
		//While changing the nodes please change the adjacency list index to also correspondingly
		graph.addVertex(0,one);
		graph.addVertex(0,two);
		graph.addVertex(0,three);
		graph.addVertex(1,zero);
		graph.addVertex(1,four);
		graph.addVertex(1,five);
		graph.addVertex(2,zero);
		graph.addVertex(2,six);
		graph.addVertex(2,seven);
		graph.addVertex(3,zero);
		graph.addVertex(3,eight);
		graph.addVertex(3,nine);
		graph.addVertex(4,one);
		graph.addVertex(4,ten);
		graph.addVertex(4,eleven);
		graph.addVertex(5,one);
		graph.addVertex(5,twelve);
		graph.addVertex(5,thirteen);
		graph.addVertex(6,two);
		graph.addVertex(6,fourteen);
		graph.addVertex(6,fifteen);
		graph.addVertex(7,two);
		graph.addVertex(7,sixteen);
		graph.addVertex(7,seventeen);
		graph.addVertex(8,three);
		graph.addVertex(8,eighteen);
		graph.addVertex(8,nineteen);
		graph.addVertex(9,three);
		graph.addVertex(9,twenty);
		
		boolean visited[] = new boolean[29];
		boolean done[] = new boolean[29];
		graph.dfs(0,visited,done);
		boolean visitedBFS[] = new boolean[29];
		graph.bfs(0, visitedBFS);
	}
	
	/**
	 * This method adds the Node into the adjacency List
	 * @param v1
	 * @param v2
	 */
	private void addVertex(int v1, Node v2){
		adjacenyList[v1].add(v2);
	}
	
	/**
	 * This method finds the Depth First Search of the graph
	 * @param vertex
	 */
	private void dfs(int vertex,boolean visited[],boolean done[]){
		
		visited[vertex] = true;
		System.out.println("DFS : \t"+vertex+" ");
		if(adjacenyList[vertex]==null){
			if(visited[vertex]){
				System.out.println(vertex);
				done[vertex] = true;
			return ;
			}
		}
		for(Node node:adjacenyList[vertex]){
			if(!visited[node.getValue()])
				dfs(node.getValue(),visited,done);
		}
		if(visited[vertex]){
			done[vertex] = true;
			return;
		}
		System.out.println("  ");
	}
	
	/**
	 * This method gives the Breadth first Search of the graph.
	 * @param vertex
	 * @param visited
	 */
	private void bfs(int vertex, boolean visited[]){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(vertex);
		visited[vertex] = true;
		while(list.size()!=0){
			int value = list.pop();
			System.out.println("\tBDS : \t"+value+" ");
			for(Node val:adjacenyList[value]){
				if(!visited[val.getValue()]){
					visited[val.getValue()]=true;
					list.add(val.getValue());
				}
			}
		}
	}

}

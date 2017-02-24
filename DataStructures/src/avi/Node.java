package avi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Node implements Comparable<Node> {

private final char label;
private int distanceFromSource;
private final Map<Node, Integer> neighbourList;

public Node(char label, int distanceFromSource) {
    this.label = label;
    this.distanceFromSource = distanceFromSource;
    this.neighbourList = new LinkedHashMap<>();
}

public void addNeighbourer(Node node, int distance) {
    neighbourList.put(node, distance);
}

public char getLabel() {
    return label;
}

public Map<Node, Integer> getNeighbourerList() {
    return neighbourList;
}

public int getDistanceFromSource() {
    return distanceFromSource;
}

public void setDistanceFromSource(int distanceFromSource) {
    this.distanceFromSource = distanceFromSource;
}

@Override
public int compareTo(Node o) {
    return Integer.compare(this.getDistanceFromSource(), o.getDistanceFromSource());
}

public void findShortestDistances(PriorityQueue<Node> nodePriority, int noOfVertices) {

    Set<Node> MST = new LinkedHashSet<>();
    while (MST.size() < noOfVertices) { // time complexity: O(n)  


        Node minNode = nodePriority.poll();
        MST.add(minNode);

        /* list of nodes to be updated in nodePriority after iteration finishes. */
        List<Node> nodesToAdd = new ArrayList<>();
        Iterator<Node> nodePriorityIterator = nodePriority.iterator();
        while (nodePriorityIterator.hasNext()) {  // time complexity: O(n)

            Node node = nodePriorityIterator.next();
            if (minNode.getNeighbourerList().containsKey(node)) { // time complexity: O(log(n))

                int adjacentNodeDistanceFromSource = minNode.getDistanceFromSource() + minNode.getNeighbourerList().get(node);
                if (node.getDistanceFromSource() > adjacentNodeDistanceFromSource) {

                    Node updatedCopy = node; // original node copied.
                    updatedCopy.setDistanceFromSource(adjacentNodeDistanceFromSource); // node copy updated with new value.
                    nodesToAdd.add(updatedCopy); // updated node added to list.
                    nodePriorityIterator.remove();  // time complexity: O(logn(n))
                }
            }
        }
        nodePriority.addAll(nodesToAdd); // all updated nodes added to priority Queue.
    }
    /* display final shortest distances for all vertices from source */
    for (Node node : MST) {
        System.out.println(node.getLabel() + " : " + node.getDistanceFromSource());
    }
}


public static void main(String[] args){
	PriorityQueue<Node> nodePriority = new PriorityQueue<>();
    nodePriority.add(nodeA);
    nodePriority.add(nodeB);
    nodePriority.add(nodeC);
    nodePriority.add(nodeD);
    nodePriority.add(nodeE);
    nodePriority.add(nodeF);
    Dijkistra dijkistra = new Dijkistra();
    dijkistra.findShortestDistances(nodePriority, 6);
}
}
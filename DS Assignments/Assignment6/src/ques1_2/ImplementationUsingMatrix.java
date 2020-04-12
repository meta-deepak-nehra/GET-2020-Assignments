package ques1_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ImplementationUsingMatrix implements UndirectedWeightedGraph {
	 private int[][] graph;

	    public ImplementationUsingMatrix(int[][] graph) throws GraphException {
	        if (graph == null)
	            throw new NullPointerException("Graph can't be Null");
	        if (graph.length != graph[0].length)
	            throw new GraphException("Matrix is not Square");
	        this.graph = graph;
	    }

	    @Override
	    public boolean isConnected() {
	        Stack<Integer> stackOfVertices = new Stack<Integer>();
	        Set<Integer> traversedElements = new HashSet<Integer>();
	        stackOfVertices.push(0);
	        while (!stackOfVertices.isEmpty()) {
	            int deletedElement = stackOfVertices.pop();
	            traversedElements.add(deletedElement);
	            for (int j = 0; j < graph[0].length; j++) {
	                if (traversedElements.contains(j))
	                    continue;
	                else if (graph[deletedElement][j] > 0)
	                    stackOfVertices.push(j);
	            }
	        }
	        return traversedElements.size() == graph.length;
	    }

	    @Override
	    public List<Integer> reachable(int node) throws GraphException {
	        if (node >= graph.length || node < 0)
	            throw new GraphException("Given Node not Present in Graph");

	        List<Integer> reachableVertices = new ArrayList<Integer>();
	        for (int j = 0; j < graph[0].length; j++) {
	            if (graph[node][j] > 0)
	                reachableVertices.add(j);

	        }
	        return reachableVertices;
	    }

	    @Override
	    public int[][] minimumSpanningTree() {
	        List<Integer> treeNodes = new LinkedList<Integer>();
	        int minimumWeightedTree[][] = new int[graph.length][graph[0].length];
	        minimumWeightedTree[0][0] = 0;
	        treeNodes.add(0);
	        int minWeight = Integer.MAX_VALUE;
	        int startVertex = 0;
	        int endVertex = 0;
	        int sizeOfTree = treeNodes.size();

	        // i and k is used to iterate over treeNodes that contains the nodes in Minimum
	        // Spanning Tree, For every i in treeNodes, we are checking the weight of i to j
	        // vertex
	        for (int i = treeNodes.get(0), k = 0; sizeOfTree != graph.length;) {
	            for (int j = 0; j < graph[0].length; j++) {
	                if (graph[i][j] != 0 && !treeNodes.contains(j) && graph[i][j] < minWeight) {
	                    endVertex = j;
	                    startVertex = i;
	                    minWeight = graph[i][j];
	                }
	            }
	            if (k < sizeOfTree - 1) {
	                k++;
	                i = treeNodes.get(k);
	            } else if (k == sizeOfTree - 1) {
	                treeNodes.add(endVertex);
	                sizeOfTree = treeNodes.size();
	                minimumWeightedTree[startVertex][endVertex] = minWeight;
	                minimumWeightedTree[endVertex][startVertex] = minWeight;
	                k = 0;
	                i = treeNodes.get(k);
	                minWeight = Integer.MAX_VALUE;
	            }
	        }
	        return minimumWeightedTree;
	    }

	    @Override
	    public int shortestPath(int node1, int node2) throws GraphException {
	        if (node1 >= graph.length || node1 < 0 || node2 >= graph.length || node2 < 0)
	            throw new GraphException("Given Nodes not Present in Graph");

	        int distanceOfVertices[] = new int[graph.length];
	        boolean vertexVisit[] = new boolean[graph.length];
	        for (int i = 0; i < graph.length; i++) {
	            distanceOfVertices[i] = Integer.MAX_VALUE;
	            vertexVisit[i] = false;
	        }
	        distanceOfVertices[node1] = 0;

	        // Find Shortest path for all vertices
	        for (int i = 0; i < graph.length - 1; i++) {
	            int u = minDistance(distanceOfVertices, vertexVisit);

	            // Mark the Selected vertex as visited
	            vertexVisit[u] = true;

	            // Updating Distance of the adjacent vertices of the selected vertex.
	            for (int v = 0; v < graph.length; v++) {
	                if (!vertexVisit[v] && graph[u][v] != 0
	                        && distanceOfVertices[u] != Integer.MAX_VALUE
	                        && distanceOfVertices[u] + graph[u][v] < distanceOfVertices[v])
	                    distanceOfVertices[v] = distanceOfVertices[u] + graph[u][v];

	            }
	        }
	        return distanceOfVertices[node2];
	    }

	    int minDistance(int distanceOfVertices[], boolean vertexVisit[]) {
	        int minimumDistance = Integer.MAX_VALUE;
	        int index = -1;
	        for (int v = 0; v < graph.length; v++)
	            if (vertexVisit[v] == false && distanceOfVertices[v] <= minimumDistance) {
	                minimumDistance = distanceOfVertices[v];
	                index = v;
	            }
	        return index;
	    }
}

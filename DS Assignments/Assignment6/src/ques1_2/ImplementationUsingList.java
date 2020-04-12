package ques1_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ImplementationUsingList implements UndirectedWeightedGraph {
	private List<LinkedList<AdjacencyList>> graph = new LinkedList<LinkedList<AdjacencyList>>();

    public ImplementationUsingList(List<LinkedList<AdjacencyList>> graph) throws GraphException {
        if (graph == null) {
            throw new NullPointerException("Graph can't be Null");
        }
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
            for (int i = 0; i < graph.get(deletedElement).size(); i++) {
                AdjacencyList element = graph.get(deletedElement).get(i);
                if (traversedElements.contains(element.getVertex()))
                    continue;
                else if (element.getWeight() > 0)
                    stackOfVertices.push(element.getVertex());
            }
        }
        return traversedElements.size() == graph.size();
    }

    @Override
    public List<Integer> reachable(int node) throws GraphException {
        if (node >= graph.size() || node < 0)
            throw new GraphException("Given Node not Present in Graph");
        List<Integer> reachableVertices = new ArrayList<Integer>();
        for (int j = 0; j < graph.get(node).size(); j++) {
            AdjacencyList graphNode = graph.get(node).get(j);
            if (graphNode.getWeight() > 0)
                reachableVertices.add(graphNode.getVertex());
        }
        return reachableVertices;
    }

    @Override
    public int[][] minimumSpanningTree() {
        List<Integer> treeNodes = new LinkedList<Integer>();
        int minimumWeightedTree[][] = new int[graph.size()][graph.size()];
        minimumWeightedTree[0][0] = 0;
        treeNodes.add(0);
        int minWeight = Integer.MAX_VALUE;
        int startVertex = 0;
        int endVertex = 0;
        int sizeOfTree = treeNodes.size();

        // i and k is used to iterate over treeNodes that contains the nodes in Minimum
        // Spanning Tree, For every i in treeNodes, we are checking the weight of i to j
        // vertex
        for (int i = treeNodes.get(0), k = 0; sizeOfTree != graph.size();) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                AdjacencyList graphNode = graph.get(i).get(j);
                if (!treeNodes.contains(graphNode.getVertex()) && graphNode.getWeight() < minWeight) {
                    endVertex = graphNode.getVertex();
                    startVertex = i;
                    minWeight = graphNode.getWeight();
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
        if (node1 >= graph.size() || node1 < 0 || node2 >= graph.size() || node2 < 0)
            throw new GraphException("Given Nodes not Present in Graph");
        int distanceOfVertices[] = new int[graph.size()];
        boolean vertexVisit[] = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            distanceOfVertices[i] = Integer.MAX_VALUE;
            vertexVisit[i] = false;
        }
        distanceOfVertices[node1] = 0;

        // Find Shortest path for all vertices
        for (int i = 0; i < graph.size() - 1; i++) {
            int u = minDistance(distanceOfVertices, vertexVisit);

            // Mark the Selected vertex as visited
            vertexVisit[u] = true;

            // Updating Distance of the adjacent vertices of the selected vertex.
            for (int v = 0; v < graph.get(u).size(); v++) {
                AdjacencyList graphNode = graph.get(u).get(v);
                if (!vertexVisit[graphNode.getVertex()]
                        && graphNode.getWeight() != 0
                        && distanceOfVertices[u] != Integer.MAX_VALUE
                        && distanceOfVertices[u] + graphNode.getWeight() < distanceOfVertices[graphNode
                                .getVertex()])
                    distanceOfVertices[graphNode.getVertex()] =
                            distanceOfVertices[u] + graphNode.getWeight();
            }
        }
        return distanceOfVertices[node2];
    }

    int minDistance(int distanceOfVertices[], boolean vertexVisit[]) {
        int minimumDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int v = 0; v < graph.size(); v++)
            if (vertexVisit[v] == false && distanceOfVertices[v] <= minimumDistance) {
                minimumDistance = distanceOfVertices[v];
                index = v;
            }
        return index;
    }
}

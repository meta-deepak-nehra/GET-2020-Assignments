package ques1_2;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GraphTestUsingList {
	ImplementationUsingList graphList;

    @Before
    public void init() throws GraphException {
        // Input Graph
        // 0---1
        // | /| \
        // | / | 2
        // |/ | /
        // 4---3
        List<LinkedList<AdjacencyList>> list = new LinkedList<LinkedList<AdjacencyList>>();
        LinkedList<AdjacencyList> list1 = new LinkedList<>();
        list1.add(new AdjacencyList(1, 5));
        list1.add(new AdjacencyList(4, 8));
        list.add(list1);
        LinkedList<AdjacencyList> list2 = new LinkedList<>();
        list2.add(new AdjacencyList(0, 5));
        list2.add(new AdjacencyList(2, 9));
        list2.add(new AdjacencyList(3, 10));
        list2.add(new AdjacencyList(4, 1));
        list.add(list2);
        LinkedList<AdjacencyList> list3 = new LinkedList<>();
        list3.add(new AdjacencyList(1, 9));
        list3.add(new AdjacencyList(3, 4));
        list.add(list3);
        LinkedList<AdjacencyList> list4 = new LinkedList<>();
        list4.add(new AdjacencyList(1, 10));
        list4.add(new AdjacencyList(2, 4));
        list4.add(new AdjacencyList(4, 2));
        list.add(list4);
        LinkedList<AdjacencyList> list5 = new LinkedList<>();
        list5.add(new AdjacencyList(0, 8));
        list5.add(new AdjacencyList(1, 1));
        list5.add(new AdjacencyList(3, 2));
        list.add(list5);
        graphList = new ImplementationUsingList(list);
    }

    @Test
    public void GraphConnected() {
        assertTrue(graphList.isConnected());
    }

    @Test
    public void VertexReachable() throws GraphException {
        assertEquals(new LinkedList<Integer>(Arrays.asList(1, 4)), graphList.reachable(0));
    }

    @Test
    public void MinimumSpanningTreeTest() {
        // Minimum Spanning Tree
        // 0---1
        // /
        // / 2
        // / /
        // 4---3
        assertArrayEquals(new int[][] { {0, 5, 0, 0, 0}, {5, 0, 0, 0, 1}, {0, 0, 0, 4, 0},
                {0, 0, 4, 0, 2}, {0, 1, 0, 2, 0}}, graphList.minimumSpanningTree());
    }

    @Test
    public void GraphShortesdPathTest() throws GraphException {
        assertEquals(7, graphList.shortestPath(1, 2));
    }

    @Test(expected = NullPointerException.class)
    public void GraphIsNull() throws GraphException {
        graphList = new ImplementationUsingList(null);
    }

    @Test(expected = GraphException.class)
    public void GraphNodeNotPresent() throws GraphException {
        graphList.reachable(5);
    }

    @Test(expected = GraphException.class)
    public void GraphNodeNotPresentForShortestPath() throws GraphException {
        graphList.shortestPath(0, 6);
    }
}

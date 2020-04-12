package ques1_2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GraphTestUsingMatrix {
	 ImplementationUsingMatrix graphMatrix;

	    @Before
	    public void init() throws GraphException {
	        // Input Graph
	        // 0---1
	        // | /| \
	        // | / | 2
	        // |/ | /
	        // 4---3
	        graphMatrix =
	                new ImplementationUsingMatrix(new int[][] { {0, 5, 0, 0, 8}, {5, 0, 9, 10, 1},
	                        {0, 9, 0, 4, 0}, {0, 10, 4, 0, 2}, {8, 1, 0, 2, 0}});
	    }

	    @Test
	    public void When_GraphConnected_Expect_True() {
	        assertTrue(graphMatrix.isConnected());
	    }

	    @Test
	    public void When_Vertex0Reachable_Expect_Vertex1Vertex4() throws GraphException {
	        assertEquals(new LinkedList<Integer>(Arrays.asList(1, 4)), graphMatrix.reachable(0));
	    }

	    @Test
	    public void When_Graph_Expect_MinimumSpanningTree() {
	        // Minimum Spanning Tree
	        // 0---1
	        // /
	        // / 2
	        // / /
	        // 4---3
	        assertArrayEquals(new int[][] { {0, 5, 0, 0, 0}, {5, 0, 0, 0, 1}, {0, 0, 0, 4, 0},
	                {0, 0, 4, 0, 2}, {0, 1, 0, 2, 0}}, graphMatrix.minimumSpanningTree());
	    }

	    @Test
	    public void When_GraphShortesdPathBetween0To2_Expect_ShortestPath12() throws GraphException {
	        assertEquals(7, graphMatrix.shortestPath(1, 2));
	    }

	    @Test(expected = NullPointerException.class)
	    public void GraphIsNull() throws GraphException {
	        graphMatrix = new ImplementationUsingMatrix(null);
	    }

	    @Test(expected = GraphException.class)
	    public void GraphMatrixNotSquare() throws GraphException {
	        graphMatrix = new ImplementationUsingMatrix(new int[][] { {1}, {1, 4}});
	    }

	    @Test(expected = GraphException.class)
	    public void GraphNodeNotPresent() throws GraphException {
	        graphMatrix.reachable(5);
	    }

	    @Test(expected = GraphException.class)
	    public void GraphNodeNotPresentForShortestPath() throws GraphException {
	        graphMatrix.shortestPath(0, 6);
	    }
}

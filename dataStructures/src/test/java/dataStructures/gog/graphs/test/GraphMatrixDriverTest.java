package dataStructures.gog.graphs.test;

import dataStructures.gog.graphs.GraphUsingMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GraphMatrixDriverTest {
    static GraphUsingMatrix<Integer,Integer> g =new GraphUsingMatrix<>(1,false);
@BeforeAll
    public static void beforeAll()
    {
        g.addEdge(0, 1, true);
        g.addEdge(2, 3, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(3, 4, true);
    }

    @Test
    public void testGetVertexCount()
    {
        Assertions.assertEquals(5,g.getVertexCount());
    }
    @Test
    public void testGetEdgesCount()
    {
        Assertions.assertEquals(5,g.getEdgesCount());
    }

}
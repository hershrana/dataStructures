package dataStructures.gog.graphs.test;

import dataStructures.gog.graphs.GraphUsingList;
import org.junit.jupiter.api.*;

class GraphUsingListTest {
    static GraphUsingList<Integer,Integer> g =new GraphUsingList<>(1,false);
    @BeforeAll
    static void setUp() {
       /* g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4,9);
        g.addEdge(4, 5,true,9);*/
        g.compareBifunction = (x,y) -> {return  x!=null ? x.compareTo(y) : -1; };

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        p.o.printMandatory(g);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getOrCreateNewVertex() {
    }

    @Test
    void addVertex() {
    }

    @Test
    void addEdge() {
    }

    @Test
    void testAddEdge() {
    }

    @Test
    void testAddEdge1() {
    }

    @Test
    void testAddEdge2() {
    }

    @Test
    void getVertexCount() {
       Assertions.assertEquals( 6 , g.getVertexCount());
    }

    @Test
    void getEdgesCount() {
        Assertions.assertEquals(   9, g.getEdgesCount());
    }

    @Test
    void hasVertex() {
        Assertions.assertFalse(g.hasVertex(6));
        Assertions.assertFalse(g.hasVertex(4));
    }

    @Test
    void hasEdge() {
        Assertions.assertTrue(g.hasEdge(3,4));
        Assertions.assertTrue(g.hasEdge(5,4));

    }

    @Test
    void edgeWeight() {
        Assertions.assertEquals(g.edgeWeight(3,4),9);
        Assertions.assertEquals(g.edgeWeight(1,2),GraphUsingList.configWeight);
    }

    @Test
    void bfsTraversal()
    {
        g.bfsTraversalIterative(2);
    }
    @Test
    void dfsTraversal()
    {
        GraphUsingList<Character,Integer> localG = new GraphUsingList<>(1,false);
        localG.compareBifunction = (x,y) -> { return x!=null? x.compareTo(y) : -1;};

        localG.addEdge('a','c',true);
        localG.addEdge('a','z',true);
        localG.addEdge('c','b',true);
        localG.addEdge('c','f',true);
        localG.addEdge('c','e',false);
        localG.addEdge('b','f',true);
        localG.addEdge('d','f',true);
        localG.addEdge('d','c',false);
        localG.addEdge('e','f',false);
       // g.dfsTraversalIterative(0);
/*        localG.addEdge(1, 0);
        localG.addEdge(2, 1);
        localG.addEdge(3, 4);
        localG.addEdge(4, 0);*/

        p.o.printMandatory(g);


        p.o.printMandatory(g.dfsTraversalIterative(0));
        p.o.printMandatory(g.dfsRecursion(0));
        p.o.printMandatory(localG);
        p.o.printMandatory(localG.dfsTraversalIterative('a'));
        p.o.printMandatory(localG.dfsRecursion('a'));

    }
}
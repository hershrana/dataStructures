package dataStructures.gog.graphs;

import org.junit.jupiter.api.Test;

public class GraphDriver {
    public static void main(String[] args)
    {
        p.o.whiteList();
        GraphUsingMatrix<Integer,Integer> g =new GraphUsingMatrix<>(1,false);
        g.addEdge(0, 1, true);
        g.addEdge(2, 3, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(3, 4, true);
        p.o.println(g);
        p.o.println(g.getVertexCount());
        // Gives the no of vertices in the graph.
        g.getVertexCount();

        // Gives the no of edges in the graph.
        g.getEdgesCount();

        // Tells whether the edge is present or not.
        g.hasEdge(3, 4);

        // Tells whether vertex is present or not
        g.hasVertex(5);
    }


}

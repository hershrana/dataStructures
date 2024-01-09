package dataStructures.gog.graphs;

public interface Graph<T,U extends Number> {
    public default boolean addVertex(T t)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.addVertex(T t)");
        return false;
    }
    public default boolean addEdge(T source,T destination)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.addEdge(T source,T destination)");
        return false;
    }
    public default boolean addEdge(T source,T destination,boolean bidirectional)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.addEdge(T source,T destination,boolean bidirectional)");
        return false;
    }
    public default boolean addEdge(T source,T destination,U weight)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.addEdge(T source,T destination,U weight)");
        return false;
    }
    public default boolean addEdge(T source,T destination,boolean bidirectional,U weight)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.addEdge(T source,T destination,boolean bidirectional,U weight)");
        return false;
    }
    public default int getVertexCount()
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.getVertexCount()");
        return -1;
    }
    public default long getEdgesCount()
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.getEdgesCount()");
        return -1;
    }
    public default boolean hasVertex(T s)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.hasVertex(T s)");
        return false;
    }
    public default boolean hasEdge(T s, T d)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.hasEdge(T s, T d)");
        return false;
    }
    public default Number edgeWeight(T s, T d)
    {
        p.o.whiteList();
        p.o.println("this is default method of Graph<T>.edgeWeight(T s, T d)");
        return null;
    }
}

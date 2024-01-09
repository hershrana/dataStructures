package dataStructures.gog.graphs;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GraphUsingMatrix<T,U extends Number> implements Graph<T,U>{
    int maxVertices;
    Number[][] adjacencyMatrix;
    private static Number configWeight = Integer.valueOf(1);
    Number defaultWeight = Integer.valueOf(1);
    Map<T,Integer> vertexIndexLookup;
    int lastUsedIndiex = -1;
    boolean defaultBiDirection = true;
    GraphUsingMatrix(int maxVertices,boolean defaultBiDirection,U defaultWeight)
    {
        this.maxVertices = maxVertices;
        this.adjacencyMatrix = new Number[this.maxVertices][this.maxVertices];
        this.vertexIndexLookup = new TreeMap<>();
        this.defaultBiDirection = defaultBiDirection;
        this.defaultWeight = defaultWeight;
    }
    GraphUsingMatrix(int maxVertices)
    {
        this(maxVertices,true,(U)configWeight);
    }
    GraphUsingMatrix()
    {
        this(1000   ,true,(U) configWeight);
    }
    public GraphUsingMatrix(U proposedDefaultWeight, boolean proposedBiDirection)
    {
        this(1000   ,proposedBiDirection,proposedDefaultWeight);
    }

    private int indexToUseForVertex(T t)
    {
        return vertexIndexLookup.computeIfAbsent(t,k -> ++lastUsedIndiex);
    }
    public boolean addVertex(T t) {
        return indexToUseForVertex(t)  >= 0;
    }
    @Override
    public boolean addEdge(T source, T destination) {
        return addEdge(source,destination,defaultBiDirection,(U) configWeight);
    }

    @Override
    public boolean addEdge(T source, T destination, boolean bidirectional) {
        return addEdge(source,destination,bidirectional,(U)configWeight);
    }

    @Override
    public boolean addEdge(T source, T destination, U weight) {
        return addEdge(source,destination,defaultBiDirection,weight);
    }

    @Override
    public boolean addEdge(T source, T destination, boolean bidirectional, U weight) {
        adjacencyMatrix[indexToUseForVertex(source)][indexToUseForVertex(destination)] =   weight;
        if(bidirectional)
            adjacencyMatrix[indexToUseForVertex(destination)][indexToUseForVertex(source)] =   weight;
        return true;
    }

    @Override
    public int getVertexCount() {
        return lastUsedIndiex+1;
    }

    @Override
    public long getEdgesCount() {
        return Arrays.stream(adjacencyMatrix).filter( u -> !Objects.nonNull(defaultWeight)).count();
    }

    @Override
    public boolean hasVertex(T s) {
        return vertexIndexLookup.containsKey(s);
    }

    @Override
    public boolean hasEdge(T s, T d) {
        return edgeWeight(s,d) != null;
    }

    @Override
    public Number edgeWeight(T s, T d) {
        if(!hasVertex(s) || !hasVertex(d))
            return null;
        return adjacencyMatrix[indexToUseForVertex(s)][indexToUseForVertex(d)];
    }

    public String toString()
    {
        Object[] arr = vertexIndexLookup.keySet().toArray();
        StringBuffer sb = new StringBuffer("    "+vertexIndexLookup.toString()).append("\n      ");
        sb.append(Arrays.stream(arr).map(a -> String.valueOf(a)).collect(Collectors.joining(",")) );
        sb.append("\n");
        for(int r = 0 ; r <= lastUsedIndiex ; r++) {
            sb.append(arr[r]+" -> ");
            for (int c = 0; c <= lastUsedIndiex; c++) {
                sb.append(adjacencyMatrix[r][c] != null ? ((Number)adjacencyMatrix[r][c]).toString() : null ).append(" , ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

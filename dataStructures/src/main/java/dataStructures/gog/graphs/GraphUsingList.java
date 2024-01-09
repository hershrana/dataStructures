package dataStructures.gog.graphs;

import java.util.*;
import java.util.function.BiFunction;

public class GraphUsingList<T extends Comparable,U extends Number> implements Graph<T,U>{
    public static final Number configWeight = Integer.valueOf(1);
    Number defaultWeight = configWeight;
    int lastUsedIndiex = -1;
    boolean defaultBiDirection = false;
    GraphUsingList(boolean defaultBiDirection,U defaultWeight)
    {
        this.defaultBiDirection = defaultBiDirection;
        this.defaultWeight = defaultWeight;
    }

    public GraphUsingList(U proposedDefaultWeight, boolean proposedBiDirection)
    {
        this(proposedBiDirection,proposedDefaultWeight);
    }
    Map<WeightedNode<T,U>, Set<WeightedNode>> adjenncySet = new HashMap<>();
    public BiFunction<T, T,Integer> compareBifunction = null;
    /*  Set<WeightedNode> getOrCreateNewVertex(T vertexToAdd,boolean add)
    {
        return adjenncySet.compute( new WeightedNode<T,U>(vertexToAdd,(U) defaultWeight) ,
                (k,v) -> {
                    if(add)
                    if( && v==null)  v = new HashSet<>();
                    return v;
                }
        )
        ;
    }*/
  Set<WeightedNode> getOrCreateNewVertex(T vertexToAdd)
    {
        /*return getOrCreateNewVertex(vertexToAdd,true)
        ;*/
        return  adjenncySet.compute( new WeightedNode<T,U>(vertexToAdd,(U) defaultWeight,compareBifunction) ,
            (k,v) -> {
               if( v==null)  v = new TreeSet<>();
                return v;
            }
    )
    ;
    }
    @Override
    public boolean addVertex(T vertexToAdd) {
        return getOrCreateNewVertex(vertexToAdd).isEmpty();
    }

    @Override
    public boolean addEdge(T source, T destination) {
        return addEdge(source, destination,defaultBiDirection,(U) defaultWeight);
    }

    @Override
    public boolean addEdge(T source, T destination, boolean bidirectional) {
        return addEdge(source, destination, bidirectional , (U) defaultWeight);
    }

    @Override
    public boolean addEdge(T source, T destination, U weight) {
        return addEdge(source, destination, defaultBiDirection,weight);
    }

    @Override
    public boolean addEdge(T source, T destination, boolean bidirectional, U weight) {
        if(bidirectional) {
            getOrCreateNewVertex(destination).add(new WeightedNode(source, weight,compareBifunction));
        }
        else {
            //just create a destination node if not bi-directional
            getOrCreateNewVertex(destination);
        }
        return getOrCreateNewVertex(source).add(new WeightedNode(destination,weight,compareBifunction));
    }

    @Override
    public int getVertexCount() {
        return adjenncySet.size();
    }

    @Override
    public long getEdgesCount() {
        return adjenncySet.entrySet()
        .stream().mapToInt( k ->
                            k.getValue().size()
                        ).sum();
    }

    @Override
    public boolean hasVertex(T s) {
        return adjenncySet.containsKey(s);
    }

    @Override
    public boolean hasEdge(T s, T d) {
        return getOrCreateNewVertex(s).stream().anyMatch(x -> x.value().equals(d));
    }

    @Override
    public Number edgeWeight(T s, T d) {
        return getOrCreateNewVertex(s).stream().filter(i -> i.equals(d)).findAny().get().weight();
    }
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (WeightedNode<T,U> v : adjenncySet.keySet()) {
            builder.append(v.toString() + ": ");
            for (WeightedNode<T,U> w : adjenncySet.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }
    //https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
    public LinkedHashSet<WeightedNode<T,U>> bfsTraversalIterative(T s)
    {
        WeightedNode<T,U>  start = null;
        Queue<WeightedNode<T,U>>  queue = new ArrayDeque<>();
        LinkedHashSet<WeightedNode<T,U>> visited = new LinkedHashSet<>();
        if(s == null)
            start = adjenncySet.keySet().stream().iterator().next();
        else
            start = adjenncySet.keySet().stream().filter(x -> x.value().equals(s)).findFirst().get();

        p.o.printMandatory("using start as "+start);
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty())
        {
            WeightedNode<T,U> current = queue.poll();
            adjenncySet.get(current).stream().forEach(
                 currentNode ->
                 {
                     if(!visited.contains(currentNode)) {
                         visited.add(currentNode);
                         queue.offer(currentNode);
                     }
                 }
            );
        }
        p.o.printMandatory(visited);
        return visited;
    }
    public LinkedHashSet<WeightedNode<T,U>> bfsTraversalRecursive(T s)
    {
        WeightedNode<T,U>  start = null;
        LinkedHashSet<WeightedNode<T,U>> visited = new LinkedHashSet<>();
        if(s == null)
            start = adjenncySet.keySet().stream().iterator().next();
        else
            start = adjenncySet.keySet().stream().filter(x -> x.value().equals(s)).findFirst().get();
        bfsRecursive(start,visited);
        return visited;
    }
    private void bfsRecursive(WeightedNode<T,U> currentNode,LinkedHashSet<WeightedNode<T,U>> visited)
    {
        if(!visited.contains(currentNode))
        {
            visited.add(currentNode);
            adjenncySet.get(currentNode).forEach( x -> bfsRecursive(x,visited) );
        }
        return;
    }


    //https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
    public LinkedHashSet<WeightedNode<T,U>> dfsTraversalIterative(T s)
    {
        WeightedNode<T,U>  start = null;
        if(s == null)
            start = adjenncySet.keySet().stream().iterator().next();
        else
            start = adjenncySet.keySet().stream().filter(x -> x.value().equals(s)).findFirst().get();
        LinkedHashSet<WeightedNode<T,U>> visited = new LinkedHashSet<>();
        Stack<WeightedNode<T,U>> stack = new Stack<>();
        stack.push(start);
        visited.add(start);
        while (!stack.isEmpty())
        {
            WeightedNode<T,U> currentNode = stack.peek();
            stack.pop();
            if(!visited.contains(currentNode))
                visited.add(currentNode);

            adjenncySet.get(currentNode).stream().forEach(
                    cNode ->
                    {
                        if(!visited.contains(cNode))
                        {
                            //p.o.printMandatory(cNode+" ");
                            stack.push(cNode);
                        }
                    }
            );
        }
        p.o.printMandatory(visited);
        return visited;
    }

    public LinkedHashSet<WeightedNode<T,U>> dfsRecursion(T s)
    {
        WeightedNode<T,U> start  = s != null ? adjenncySet.keySet().stream().filter(x -> x.value().equals(s)).findFirst().get() : adjenncySet.keySet().stream().findFirst().get();
        p.o.printMandatory("dfsRecursion start node "+start);
        LinkedHashSet<WeightedNode<T,U>> visited = new LinkedHashSet<>();
        dfsHelper(start,visited);
        return visited;
    }
    private void dfsHelper(WeightedNode<T,U> currentNode , LinkedHashSet<WeightedNode<T,U>> visited)
    {
        if(!visited.contains(currentNode))
        {
            visited.add(currentNode);
            adjenncySet.get(currentNode).stream().forEach(
                    cNode ->
                    {
                        if(!visited.contains(cNode))
                        {
                            dfsHelper(cNode,visited);

                        }
                    }
            );
        }
        return;
    }
}
record WeightedNode <T ,U extends Number> (T value,U weight, BiFunction<T,T,Integer> compareBiFunction) implements Comparable<T>{
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if(other instanceof Number)
        {
            return  other.equals(this.value);
        }
        if (!(other instanceof WeightedNode)) {
            return false;
        }
        WeightedNode movie = (WeightedNode) other;
        if (movie.value.equals(this.value)) {
            return true;
        }
        return false;
    }


    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
    public String toString()
    {
        return String.format("%s%s%s","{",value(),"}");
    }
    public String toStringWeight()
    {
        return String.format("%s%s:%s%s","{",value(),weight(),"}");
    }

    @Override
    public int compareTo(Object o) {
        if(o == null)
            return 1;
        WeightedNode<T,U> weightedNode = (WeightedNode<T, U>) o;
        return compareBiFunction.apply(this.value,weightedNode.value());
    }
}

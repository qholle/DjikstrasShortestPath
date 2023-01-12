import java.util.List;

/**
 * This ADT represents a directed graph data structure with positive edge weights.
 *
 * @param <T> the data type stored at each graph vertex
 */
public interface GraphADT<T> {

  public boolean insertVertex(T data);

  public boolean removeVertex(T data);

  public boolean insertEdge(T source, T target, int weight);

  public boolean removeEdge(T source, T target);

  public boolean containsVertex(T data);

  public boolean containsEdge(T source, T target);

  public int getWeight(T source, T target);

  public List<T> shortestPath(T start, T end);

  public int getPathCost(T start, T end);

  public boolean isEmpty();

  public int getEdgeCount();

  public int getVertexCount();

}

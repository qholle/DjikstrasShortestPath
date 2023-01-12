
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertVertex("G"); //inaccessible node that I made for a test case
        // insert edges from Week 11. Shortest Path Activity
        graph.insertEdge("A","B",6);
        graph.insertEdge("A","C",2);
        graph.insertEdge("A","D",5);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("C","B",3);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",3);
        graph.insertEdge("E","A",4);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }
    

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }
    
    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    @Test
    public void testPathCostAtoE() {
        assertTrue(graph.getPathCost("A", "E") == 6);
    }
    
    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    @Test
    public void testPathCostAtoC() {
        assertTrue(graph.getPathCost("A", "C") == 2);
    }
    
    /**
     * Checks the distance/total weight cost from the vertex E to F.
     */
    @Test
    public void testPathCostEtoF() {
        assertTrue(graph.getPathCost("E", "F") == 7);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to E.
     */
    @Test
    public void testPathAtoE() {
        assertTrue(graph.shortestPath("A", "E").toString().equals(
            "[A, C, B, E]"
        ));
    }
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * E to F.
     */
    @Test
    public void testPathEtoF() {
        assertTrue(graph.shortestPath("E", "F").toString().equals(
            "[E, A, C, F]"
        ));
    }
    
    /**
     * Checks the predecessor node of the shortest path from the vertex C to E
     */
    @Test
    public void testPredecessorCtoE() {
        assertTrue(graph.shortestPath("C", "E").toString().equals(
            "[C, B, E]"
        ));
    }
    
    /**
     * Checks the  node of the shortest path from vertex A to A
     */
    @Test
    public void testPathAtoA() {
        assertTrue(graph.shortestPath("A", "A").toString().equals(
            "[A]"
        ));
    }
    
    /**
     * Checks the cost of the shortest path from vertex A to A
     */
    @Test
    public void testPathCostAtoA() {
        assertTrue(graph.getPathCost("A", "A") == 0);
    }
    
    /**
     * Checks if a NoSuchElementException is thrown when a path cannot be found to a node
     */
    @Test
    public void testThrowsErrorNoPath() {
        assertThrows(NoSuchElementException.class, () -> graph.getPathCost("A", "G"));
    }
    
    /**
     * Checks if a NoSuchElementException is thrown when a vertice isn't located in the graph
     */
    @Test
    public void testThrowsErrorNotInGraph() {
        assertThrows(NoSuchElementException.class, () -> graph.getPathCost("X", "G"));
    }

    public static void main(String[] args) {
        String className = MethodHandles.lookup().lookupClass().getName();
        String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
        String[] arguments = new String[] {
          "-cp",
          classPath,
          "--include-classname=.*",
          "--select-class=" + className };
        ConsoleLauncher.main(arguments);
      }

}
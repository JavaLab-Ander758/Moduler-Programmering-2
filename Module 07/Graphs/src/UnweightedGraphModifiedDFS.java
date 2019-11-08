import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class UnweightedGraphModifiedDFS<V> extends UnweightedGraph<V> {
    /**
     * Construct an empty graph
     */
    public UnweightedGraphModifiedDFS() {
    }

    /**
     * Construct a graph from vertices and edges stored in arrays
     */
    public UnweightedGraphModifiedDFS(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    /**
     * Construct a graph from vertices and edges stored in List
     */
    public UnweightedGraphModifiedDFS(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    /**
     * Construct a graph for integer vertices 0, 1, 2 and edge list
     */
    public UnweightedGraphModifiedDFS(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    /**
     * Construct a graph from integer vertices 0, 1, and edge array
     */
    public UnweightedGraphModifiedDFS(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }


    // Med hjelp fra: https://www.baeldung.com/java-depth-first-search (3.2)

    @Override                                               // Override dfs in Graph.java by using a Stack
    public SearchTree dfs(int vertex) {
        boolean[] isVisited = new boolean[vertices.size()]; // Declare new boolean array to contain which is visited
        int[] parent = new int[vertices.size()];            // Declare new int array to contain every parent
        Stack<Integer> stack = new Stack<>();               // Declare new Stack for non-recursion
        List<Integer> searchOrder = new ArrayList<>();      // Declare new list containing the search order

        Arrays.fill(parent, -1);                        // Assigns the specified data to each element in the array
        stack.add(vertex);                                  // Add vertex to the stack

        while (!stack.isEmpty()) {                          // Loops as long as stack is not empty
            vertex = stack.pop();                           // Pop vertex from stack in every loop until stack not empty
            if (!isVisited[vertex]) {                       // Check if given vertex is visited in boolean array isVisited[]
                searchOrder.add(vertex);                    // If not visited, add vertex to searchOrder list
                isVisited[vertex] = true;                   // Assigns vertex as visited in boolean array isVisited[]
            }
            for (Edge u : neighbors.get(vertex))
                if (!isVisited[u.getV()]) {                 // Check if neighbour not visited
                    stack.add(u.getV());                    // Add given neighbour to stack
                    parent[u.getV()] = vertex;              // Refresh parent
                }
        }
        return new SearchTree(vertex, parent, searchOrder); // Return the searchTree
    }
}
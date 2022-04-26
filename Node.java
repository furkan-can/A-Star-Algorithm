import java.util.*;

public class Node {
	// Id for readability of result purposes
    public String id;
    // Parent in the path
    public Node parent = null;

    public List<Edge> neighbors;

    // Evaluation functions
    public int FCost = Integer.MAX_VALUE;
    public int gCost = Integer.MAX_VALUE;
    // Hardcoded heuristic
    public int hCost; 

    Node(int h,String id){
          this.hCost = h;
          this.id = id;
          this.neighbors = new ArrayList<>();
    }

    public static class Edge {
          Edge(int cost, Node node){
                this.cost = cost;
                this.node = node;
          }

          public int cost;
          public Node node;
    }

    public void addBranch(int weight, Node node){
          Edge newEdge = new Edge(weight, node);
          neighbors.add(newEdge);
    }

    public int calculateHeuristic(Node target){
          return this.hCost;
    }
    
    
}

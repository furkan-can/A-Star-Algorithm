import java.util.*;


public class PathFinding {
	
    public static Node aStar(Node startNode, Node goalNode){
	    List<Node> frontier = new ArrayList<>();
	    HashSet<Node> explored = new HashSet<>();
	    
	    startNode.FCost = startNode.gCost + startNode.calculateHeuristic(goalNode);
	    frontier.add(startNode);

	    while(!frontier.isEmpty()){
	    	
	        Node currentNode = frontier.get(0);
	        
	        for (Node eachNode : frontier) {
				if(eachNode.FCost<currentNode.FCost)
					currentNode=eachNode;
			}
	        
	        if(currentNode == goalNode){
	            return currentNode;
	        }

	        for(Node.Edge edge : currentNode.neighbors){
	            Node neighbour = edge.node;
	            
	            int totalWeight = currentNode.gCost + edge.cost;

	            if(!frontier.contains(neighbour) && !explored.contains(neighbour)){
	            	neighbour.parent = currentNode;
	            	neighbour.gCost = totalWeight;
	            	neighbour.FCost = neighbour.gCost + neighbour.calculateHeuristic(goalNode);
	                frontier.add(neighbour);
	            } else {
	                if(totalWeight < neighbour.gCost){
	                	neighbour.parent = currentNode;
	                	neighbour.gCost = totalWeight;
	                	neighbour.FCost = neighbour.gCost + neighbour.calculateHeuristic(goalNode);

	                    if(explored.contains(neighbour)){
	                        explored.remove(neighbour);
	                        frontier.add(neighbour);
	                    }
	                }
	            }
	        }

	        frontier.remove(currentNode);
	        explored.add(currentNode);
	    }
	    return null;
	}
    
    public static int pathCost(Node startNode,Node goalNode) {
    	List<String> idas=new ArrayList<>();
    	Node target=goalNode;
    	idas.add(goalNode.id);
    	while(target!=startNode) {
    		target=target.parent;
    		idas.add(target.id);
    	}
    	
    	int x=goalNode.hCost;
    	
    	for (int i = idas.size()-1; i > 0; i--) {
    		for (Node.Edge edge : startNode.neighbors) {
    			if(edge.node.id.equals(idas.get(i-1))){
    				x+=edge.cost;
    				startNode=edge.node;
    			}
    			
			}
		}
    	return x;
    }

	public static void printPath(Node goalNode){
	    Node currentNode = goalNode;

	    if(currentNode==null)
	        return;

	    List<String> ids = new ArrayList<>();

	    while(currentNode.parent != null){
	        ids.add(currentNode.id);
	        currentNode = currentNode.parent;
	    }
	    ids.add(currentNode.id);
	    Collections.reverse(ids);
	    String s="";
	    for(String id : ids){
	    	s+=id + " -> ";
	    }
	    System.out.println("Path\t  : "+s.substring(0, s.length()-3));
	}
}

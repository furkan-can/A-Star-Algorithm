
public class test {
	public static void main(String[] args) {
	    Node s = new Node(5,"S");
	    s.gCost = 0;

	    Node a = new Node(3,"A");
	    Node b = new Node(4,"B");
	    Node c = new Node(2,"C");
	    Node d = new Node(6,"D");
	    Node g = new Node(0,"G");
	    
	    
	    s.addBranch(1, a);
	    s.addBranch(10, g);
	    
	    a.addBranch(2, b);
	    a.addBranch(1, c);
	    
	    b.addBranch(5, d);
	    
	    c.addBranch(3, d);
	    c.addBranch(4, g);
	    
	    d.addBranch(2, g);
	    
	    
	    
	    Node path = PathFinding.aStar(s, g);
	    PathFinding.printPath(path);
	    int pathCost=PathFinding.pathCost(s, g);
	    System.out.println("Path Cost : " + pathCost);
	    
	}
}

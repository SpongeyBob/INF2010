import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	public Graph() {
		// A compléter
	nodes= new ArrayList<>();
	edges =new ArrayList<>();

	}
	
	public List<Edge> getEdgesGoingFrom(Node source) {
		// A complèter DONE

				List <Edge> cheminsDe =new ArrayList<>(); //déclaration et initialisation de la variable de retour
		for (int i=0; i<edges.size(); i++)
		{
			if(edges.get(i).getSource().getId()== source.getId())  //verifier que le ID de la source est le meme que la source de chaque edge
				cheminsDe.add(edges.get(i));
		}

		return cheminsDe;
		
	}
	public List<Edge> getEdgesGoingTo(Node dest) {
		// A complèter DONE
		List <Edge> cheminVers= new ArrayList<>();

		for(int i=0; i< edges.size();i++)
		{
			if (edges.get(i).getDestination().getId()==dest.getId())
				cheminVers.add(edges.get(i));
		}

		return cheminVers;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}

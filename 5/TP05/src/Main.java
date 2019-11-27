import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1: A completer : Création du graphe

		//////// definition des noeuds du graphe////////////
		Node nodeA=new Node(1, "A");
		Node nodeB= new Node (2, "B");
		Node nodeC= new Node (3, "C");
		Node nodeD= new Node (4, "D");
		Node nodeE= new Node (5, "E");
		Node nodeF= new Node (6, "F");
		Node nodeG= new Node (7, "G");


		List <Node> n = new ArrayList<>();

		n.add(nodeA);
		n.add(nodeB);
		n.add(nodeC);
		n.add(nodeD);
		n.add(nodeE);
		n.add(nodeF);
		n.add(nodeG);

		g.setNodes(n);
		////////////////////// definition des arcs du graphe//////////

		Edge arcAetB= new Edge(nodeA, nodeB, 2);
		Edge arcAetC= new Edge(nodeA, nodeC, 1);

		Edge arcBetA= new Edge(nodeB, nodeA, 2);
		Edge arcBetC= new Edge(nodeB, nodeC, 2);
		Edge arcBetE= new Edge(nodeB, nodeE, 3);
		Edge arcBetD= new Edge(nodeB, nodeD, 1);

		Edge arcCetA= new Edge(nodeC, nodeA, 1);
		Edge arcCetB= new Edge(nodeC, nodeB, 2);
		Edge arcCetD= new Edge(nodeC, nodeD, 4);
		Edge arcCetE= new Edge(nodeC, nodeE, 3);
		Edge arcCetF= new Edge(nodeC, nodeF, 5);

		Edge arcDetB= new Edge(nodeD, nodeB, 1);
		Edge arcDetC= new Edge(nodeD, nodeC, 4);
		Edge arcDetF= new Edge(nodeD, nodeF, 6);
		Edge arcDetG= new Edge(nodeD, nodeG, 5);

		Edge arcEetB= new Edge(nodeE, nodeB, 3);
		Edge arcEetC= new Edge(nodeE, nodeC, 3);
		Edge arcEetF= new Edge(nodeE, nodeF, 1);

		Edge arcFetC= new Edge(nodeF, nodeC, 5);
		Edge arcFetD= new Edge(nodeF, nodeD, 6);
		Edge arcFetE= new Edge(nodeF, nodeE, 1);
		Edge arcFetG= new Edge(nodeF, nodeG, 2);

		Edge arcGetD= new Edge(nodeG, nodeD, 5);
		Edge arcGetF= new Edge(nodeG, nodeF, 2);


		List <Edge> e= new ArrayList<>();

		e.add(arcAetB);
		e.add(arcAetC);

		e.add(arcBetA);
		e.add(arcBetC);
		e.add(arcBetE);
		e.add(arcBetD);

		e.add(arcCetA);
		e.add(arcCetB);
		e.add(arcCetD);
		e.add(arcCetE);
		e.add(arcCetF);

		e.add(arcDetB);
		e.add(arcDetC);
		e.add(arcDetF);
		e.add(arcDetG);

		e.add(arcEetB);
		e.add(arcEetC);
		e.add(arcEetF);

		e.add(arcFetC);
		e.add(arcFetD);
		e.add(arcFetE);
		e.add(arcFetG);

		e.add(arcGetD);
		e.add(arcGetF);

		g.setEdges(e);
		
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(null, null/* Spécifiez les paramètres */);
		
		d.showTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.printShortPath(null, null/* Spécifiez les paramètres */));
	
	}
}

package dijkstra_package;
/**
*
* @author EduardBalasa
* 
*/
public class Edge_Dijkstra {
	private final String id;
	private final Vertex_Dijsktra source;
	private final Vertex_Dijsktra destination;
	private final int weight;

	public Edge_Dijkstra(String id, Vertex_Dijsktra source, Vertex_Dijsktra destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	// Getters for getting the Id
	public String getId() {
		return id;
	}

	// Getters for getting the Destination
	public Vertex_Dijsktra getDestination() {
		return destination;
	}

	// Getters for getting the Source
	public Vertex_Dijsktra getSource() {
		return source;
	}

	// Getters for getting the Weight
	public int getWeight() {
		return weight;
	}

	// Method that returns the string representation of the object.
	@Override
	public String toString() {
		return source + " " + destination;
	}

}
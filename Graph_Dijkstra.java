package dijkstra_package;
/**
*
* @author EduardBalasa
* 
*/
import java.util.List;

public class Graph_Dijkstra {
	private final List<Vertex_Dijsktra> vertexes;
	private final List<Edge_Dijkstra> edges;

	public Graph_Dijkstra(List<Vertex_Dijsktra> vertexes, List<Edge_Dijkstra> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	// Getters for getting Vertexes
	public List<Vertex_Dijsktra> getVertexes() {
		return vertexes;
	}

	// Getters for getting Edges
	public List<Edge_Dijkstra> getEdges() {
		return edges;
	}
}
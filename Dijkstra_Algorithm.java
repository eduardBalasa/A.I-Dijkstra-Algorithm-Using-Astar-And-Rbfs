package dijkstra_package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
*
* @author EduardBalasa
* 
*/
public class Dijkstra_Algorithm {

	private final List<Vertex_Dijsktra> nodes;
	private final List<Edge_Dijkstra> edges;
	private Set<Vertex_Dijsktra> settledNodes;
	private Set<Vertex_Dijsktra> unSettledNodes;
	private Map<Vertex_Dijsktra, Vertex_Dijsktra> predecessors;
	private Map<Vertex_Dijsktra, Integer> distance;

	public Dijkstra_Algorithm(Graph_Dijkstra graph) {
		// create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<Vertex_Dijsktra>(graph.getVertexes()); // create a new vertices list
		this.edges = new ArrayList<Edge_Dijkstra>(graph.getEdges()); // create a new edges list
	}

	public void execute(Vertex_Dijsktra source) {
		settledNodes = new HashSet<Vertex_Dijsktra>(); // all nodes needs to be checked in order to be settledNodes
		unSettledNodes = new HashSet<Vertex_Dijsktra>(); // firstly all nodes are in unSettledNodes
		distance = new HashMap<Vertex_Dijsktra, Integer>(); // distance between two nodes
		predecessors = new HashMap<Vertex_Dijsktra, Vertex_Dijsktra>(); // all nodes expect the first one
		distance.put(source, 0); // set distance from source to 0
		unSettledNodes.add(source); // add a node in to unSettledNodes
		while (unSettledNodes.size() > 0) {
			Vertex_Dijsktra node = getMinimum(unSettledNodes); // call function getMinimum to check the node from unSettledNodes
			settledNodes.add(node); // add the node to settledNodes
			unSettledNodes.remove(node); // remove the node from unSettledNodes
			findMinimalDistances(node); // call findMinimalDistances
		}
	}

	private void findMinimalDistances(Vertex_Dijsktra node) {
		List<Vertex_Dijsktra> adjacentNodes = getNeighbors(node); // call function getNeighbors to get node neighbors
		for (Vertex_Dijsktra target : adjacentNodes) { // check every neighbor
			if (getShortestDistance(target) > getShortestDistance(node) // call function getShortestDistance to check if
																		// there is a shorter distance to node
					+ getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) // calculate distance between target and node
						+ getDistance(node, target));
				predecessors.put(target, node); // remove the node it checked
				unSettledNodes.add(target); // adds target to unSettledNodes
			}
		}

	}

	// for each edge returns distance between current node and target node
	private int getDistance(Vertex_Dijsktra node, Vertex_Dijsktra target) {
		for (Edge_Dijkstra edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("not allowed");
	}

	// create a vector which contains all the neighbors of the node
	private List<Vertex_Dijsktra> getNeighbors(Vertex_Dijsktra node) {
		List<Vertex_Dijsktra> neighbors = new ArrayList<Vertex_Dijsktra>();
		for (Edge_Dijkstra edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	// search the shortest path between two nodes
	private Vertex_Dijsktra getMinimum(Set<Vertex_Dijsktra> vertexes) {
		Vertex_Dijsktra minimum = null;
		for (Vertex_Dijsktra vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	// verify that if a node is visited
	private boolean isSettled(Vertex_Dijsktra vertex) {
		return settledNodes.contains(vertex);
	}

	// verify the shortest distance
	private int getShortestDistance(Vertex_Dijsktra destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	public LinkedList<Vertex_Dijsktra> getPath(Vertex_Dijsktra target) {
		LinkedList<Vertex_Dijsktra> path = new LinkedList<Vertex_Dijsktra>();
		Vertex_Dijsktra step = target;

		if (predecessors.get(step) == null) { // check if a path exists and NULL if no path exists
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}

		Collections.reverse(path); // put it into the correct order
		return path;
	}

}
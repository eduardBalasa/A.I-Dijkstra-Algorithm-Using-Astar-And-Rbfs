package dijkstra_package;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author EduardBalasa
 * 
 */


public class Main_Dijkstra {

	private List<Vertex_Dijsktra> nodes;
	private List<Edge_Dijkstra> edges;

	//Function that is used for UNIT TEST the path using JUnit Package 4
	
	@Test 
	public void testExcute() {
		nodes = new ArrayList<Vertex_Dijsktra>();
		edges = new ArrayList<Edge_Dijkstra>();

		for (int i = 0; i < 34; i++) {
			Vertex_Dijsktra location = new Vertex_Dijsktra("City_" + i, i);
			nodes.add(location);
		}

		Random rand = new Random();

		addLane("Edge_0", 0, 1, rand.nextInt(500));
		addLane("Edge_1", 0, 2, rand.nextInt(500));
		addLane("Edge_2", 1, 3, rand.nextInt(500));
		addLane("Edge_3", 1, 2, rand.nextInt(500));
		addLane("Edge_4", 3, 4, rand.nextInt(500));
		addLane("Edge_5", 3, 5, rand.nextInt(500));
		addLane("Edge_6", 3, 2, rand.nextInt(500));
		addLane("Edge_7", 4, 6, rand.nextInt(500));
		addLane("Edge_8", 4, 7, rand.nextInt(500));
		addLane("Edge_9", 7, 8, rand.nextInt(500));
		addLane("Edge_10", 7, 5, rand.nextInt(500));
		addLane("Edge_11", 6, 5, rand.nextInt(500));
		addLane("Edge_12", 5, 8, rand.nextInt(500));
		addLane("Edge_13", 5, 9, rand.nextInt(500));
		addLane("Edge_14", 5, 10, rand.nextInt(500));
		addLane("Edge_15", 11, 12, rand.nextInt(500));
		addLane("Edge_16", 11, 10, rand.nextInt(500));
		addLane("Edge_17", 8, 13, rand.nextInt(500));
		addLane("Edge_18", 13, 14, rand.nextInt(500));
		addLane("Edge_19", 14, 15, rand.nextInt(500));
		addLane("Edge_20", 14, 16, rand.nextInt(500));
		addLane("Edge_21", 14, 17, rand.nextInt(500));
		addLane("Edge_22", 15, 16, rand.nextInt(500));
		addLane("Edge_23", 15, 17, rand.nextInt(500));
		addLane("Edge_24", 16, 17, rand.nextInt(500));
		addLane("Edge_25", 17, 18, rand.nextInt(500));
		addLane("Edge_26", 17, 19, rand.nextInt(500));
		addLane("Edge_27", 17, 20, rand.nextInt(500));
		addLane("Edge_28", 20, 19, rand.nextInt(500));
		addLane("Edge_29", 19, 21, rand.nextInt(500));
		addLane("Edge_30", 21, 22, rand.nextInt(500));
		addLane("Edge_31", 21, 23, rand.nextInt(500));
		addLane("Edge_32", 21, 24, rand.nextInt(500));
		addLane("Edge_33", 21, 25, rand.nextInt(500));
		addLane("Edge_34", 21, 26, rand.nextInt(500));
		addLane("Edge_35", 22, 24, rand.nextInt(500));
		addLane("Edge_36", 22, 23, rand.nextInt(500));
		addLane("Edge_37", 22, 26, rand.nextInt(500));
		addLane("Edge_38", 22, 25, rand.nextInt(500));
		addLane("Edge_39", 23, 24, rand.nextInt(500));
		addLane("Edge_40", 23, 26, rand.nextInt(500));
		addLane("Edge_41", 23, 25, rand.nextInt(500));
		addLane("Edge_42", 24, 25, rand.nextInt(500));
		addLane("Edge_43", 24, 26, rand.nextInt(500));
		addLane("Edge_44", 26, 25, rand.nextInt(500));
		addLane("Edge_45", 26, 27, rand.nextInt(500));
		addLane("Edge_46", 26, 28, rand.nextInt(500));
		addLane("Edge_47", 25, 29, rand.nextInt(500));
		addLane("Edge_48", 29, 12, rand.nextInt(500));
		addLane("Edge_49", 29, 27, rand.nextInt(500));
		addLane("Edge_50", 29, 17, rand.nextInt(500));
		addLane("Edge_51", 29, 8, rand.nextInt(500));
		addLane("Edge_52", 29, 7, rand.nextInt(500));
		addLane("Edge_53", 29, 5, rand.nextInt(500));
		addLane("Edge_54", 27, 30, rand.nextInt(500));
		addLane("Edge_55", 27, 31, rand.nextInt(500));
		addLane("Edge_56", 27, 12, rand.nextInt(500));
		addLane("Edge_57", 27, 17, rand.nextInt(500));
		addLane("Edge_58", 27, 8, rand.nextInt(500));
		addLane("Edge_59", 27, 7, rand.nextInt(500));
		addLane("Edge_60", 30, 32, rand.nextInt(500));
		addLane("Edge_61", 31, 28, rand.nextInt(500));
		addLane("Edge_62", 28, 33, rand.nextInt(500));
		addLane("Edge_63", 28, 9, rand.nextInt(500));
		addLane("Edge_64", 33, 9, rand.nextInt(500));
		addLane("Edge_65", 33, 0, rand.nextInt(500));
		addLane("Edge_66", 33, 2, rand.nextInt(500));
		addLane("Edge_67", 33, 1, rand.nextInt(500));
		addLane("Edge_68", 9, 2, rand.nextInt(500));
		addLane("Edge_69", 9, 32, rand.nextInt(500));
		addLane("Edge_70", 9, 10, rand.nextInt(500));
		addLane("Edge_71", 2, 10, rand.nextInt(500));
		addLane("Edge_72", 2, 32, rand.nextInt(500));
		addLane("Edge_73", 32, 10, rand.nextInt(500));
		addLane("Edge_74", 10, 3, rand.nextInt(500));
		addLane("Edge_75", 12, 17, rand.nextInt(500));
		addLane("Edge_76", 12, 8, rand.nextInt(500));
		addLane("Edge_77", 12, 5, rand.nextInt(500));
		addLane("Edge_78", 12, 7, rand.nextInt(500));

		Graph_Dijkstra graph = new Graph_Dijkstra(nodes, edges);
		Dijkstra_Algorithm dijkstra = new Dijkstra_Algorithm(graph);

		Scanner scan = new Scanner(System.in);
		System.out.println("Min. value = 0 and Max. value = 33");
		System.out.print("Select a city between: 0 and 33 cities \n");
		System.out.print("Select the city you want to leave: ");
		
		
		int nr1 = scan.nextInt();

		System.out.print("Select the city where you want to reach: ");

		int nr2 = scan.nextInt();

		scan.close();
		System.out.println("\n");
		System.out.println("Here we go travelling...");
		System.out.print("The following cities need to be cover to reach at the wanted city: \n");

		dijkstra.execute(nodes.get(nr1));
		LinkedList<Vertex_Dijsktra> path = dijkstra.getPath(nodes.get(nr2));

		assertNotNull(path);
		assertTrue(path.size() > 0);
		
		for (Vertex_Dijsktra vertex : path) {
			if (vertex.getName() == nr1) {
				System.out.println(vertex + "'th city");
			} else if (vertex.getName() == nr2) {
				System.out.println(vertex + "'th city");
			} else {
				System.out.println(vertex+ "'th city");
				System.out.println("\n");
				System.out.println(vertex+ "'th city");
			}
		}
		System.out.println("Coordinates Followed Succesfully!");
		System.out.println("Journey Completed.");
	} //end of UNIT TEST
	

	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
		Edge_Dijkstra lane = new Edge_Dijkstra(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}
}
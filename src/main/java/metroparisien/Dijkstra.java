package metroparisien;

import java.util.*;

public class Dijkstra {

    public static class Edge {
	    public Station dest;
	    public int cost;

	    public Edge(Voie voie) {
	        this.dest = voie.getStationArrivee();
	        this.cost = voie.getDistance();
	    }
	}


    public static class Node implements Comparable<Node> {
	    public Station station;
	    public int cost;

	    public Node(Station station, int cost) {
	        this.station = station;
	        this.cost = cost;
	    }

	    public int compareTo(Node other) {
	        return this.cost - other.cost;
	    }
	}


    public static int dijkstra(ArrayList<Edge>[] graph, Station source, Station destination, ArrayList<Station> stations) {
	    PriorityQueue<Node> queue = new PriorityQueue<>();
	    queue.add(new Node(source, 0));

	    int[] dist = new int[graph.length];
	    Arrays.fill(dist, Integer.MAX_VALUE);
	    dist[stations.indexOf(source)] = 0;

	    while (!queue.isEmpty()) {
	        Node node = queue.poll();
	        Station u = node.station;

	        for (Edge edge : graph[stations.indexOf(u)]) {
	            Station v = edge.dest;
	            int cost = edge.cost;

	            if (dist[stations.indexOf(u)] + cost < dist[stations.indexOf(v)]) {
	                dist[stations.indexOf(v)] = dist[stations.indexOf(u)] + cost;
	                queue.add(new Node(v, dist[stations.indexOf(v)]));
	            }
	        }
	    }

	    return dist[stations.indexOf(destination)];
	}


}

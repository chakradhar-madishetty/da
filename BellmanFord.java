import java.util.Scanner;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFord {

    public static void bellmanFord(Edge[] edges, int V, int E, int src) {
        double[] distance = new double[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }
        distance[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;
                if (distance[u] != Double.POSITIVE_INFINITY && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        for (int j = 0; j < E; j++) {
            int u = edges[j].source;
            int v = edges[j].destination;
            int weight = edges[j].weight;
            if (distance[u] != Double.POSITIVE_INFINITY && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int V = sc.nextInt();
       
        System.out.println("Enter the number of edges: ");
        int E = sc.nextInt();
       
        Edge[] edges = new Edge[E];

        System.out.println("Enter the edges (source destination weight): ");
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges[i] = new Edge(src, dest, weight);
        }

        System.out.println("Enter the source vertex: ");
        int source = sc.nextInt();

        bellmanFord(edges, V, E, source);

        sc.close();
    }
}

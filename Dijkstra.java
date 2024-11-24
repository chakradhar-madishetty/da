import java.util.Scanner;

public class Dijkstra {
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
       
        System.out.println("Enter the adjacency matrix (use " + INF + " for no connection): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the source vertex: ");
        int source = sc.nextInt();

        dijkstra(graph, source, n);
    }

    public static void dijkstra(int[][] graph, int src, int n) {
        int[] dist = new int[n]; 
        boolean[] sptSet = new boolean[n]; 
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, sptSet, n);

            sptSet[u] = true;

            for (int v = 0; v < n; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static int minDistance(int[] dist, boolean[] sptSet, int n) {
        int min = INF, minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}

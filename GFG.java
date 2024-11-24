import java.io.*;
import java.util.*;

class GFG {

    static int INF = Integer.MAX_VALUE;

    public static int shortestDist(int[][] graph, int N) {
        int[] dist = new int[N];
        dist[N - 1] = 0;

        for (int i = N - 2; i >= 0; i--) {
            dist[i] = INF;

            for (int j = i; j < N; j++) {
                if (graph[i][j] == INF) {
                    continue;
                }

                dist[i] = Math.min(dist[i], graph[i][j] + dist[j]);
            }
        }

        return dist[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int N = scanner.nextInt();

        int[][] graph = new int[N][N];

        System.out.println("Enter the adjacency matrix (use " + INF + " for no edge):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The shortest distance from node 0 to node " + (N - 1) + " is: " + shortestDist(graph, N));

        scanner.close();
    }
}
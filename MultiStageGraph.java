import java.util.Scanner;

public class MultiStageGraph {

    // Function to find the shortest path in a multi-stage graph
    public static void findShortestPath(int[][] graph, int[] stageCost, int n) {
        // Array to store the minimum cost to reach each node
        int[] minCost = new int[n];
        // Array to store the next node in the path
        int[] nextNode = new int[n];

        // Initialize the last node's cost to its stage cost
        minCost[n - 1] = stageCost[n - 1];

        // Calculate minimum cost for each node starting from the second to last stage
        for (int i = n - 2; i >= 0; i--) {
            minCost[i] = Integer.MAX_VALUE; // Set initial min cost to infinity
            // Explore each node's outgoing edges to the next stage
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0) { // If there's an edge
                    int cost = graph[i][j] + minCost[j]; // Calculate total cost
                    if (cost < minCost[i]) {
                        minCost[i] = cost; // Update min cost
                        nextNode[i] = j; // Update next node
                    }
                }
            }
            // Add the stage cost of the current node to the min cost
            minCost[i] += stageCost[i];
        }

        // Print the minimum cost to reach the destination node
        System.out.println("Minimum cost to reach destination: " + minCost[0]);
       
        // Print the path taken
        System.out.print("Path: " + 0);
        int currentNode = 0;
        while (nextNode[currentNode] != n - 1) {
            currentNode = nextNode[currentNode];
            System.out.print(" -> " + currentNode);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();

        // Adjacency matrix for the graph
        int[][] graph = new int[n][n];

        System.out.println("Enter the cost matrix (0 for no edge): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the stage costs: ");
        int[] stageCost = new int[n];
        for (int i = 0; i < n; i++) {
            stageCost[i] = sc.nextInt();
        }

        // Run the shortest path algorithm for the multi-stage graph
        findShortestPath(graph, stageCost, n);

        sc.close();
    }
}
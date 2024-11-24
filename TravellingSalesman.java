

import java.util.Scanner;

public class TravellingSalesman {
    private static final int INF = 10000000; 
    private static int tsp(int[][] dist, int mask, int pos, int[][] dp, int[][] parent) {
        int n = dist.length;

        if (mask == (1 << n) - 1) {
            return dist[pos][0];
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int minCost = INF;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = dist[pos][city] + tsp(dist, mask | (1 << city), city, dp, parent);
                if (newCost < minCost) {
                    minCost = newCost;
                    parent[mask][pos] = city; 
                }
            }
        }

        return dp[mask][pos] = minCost;
    }

    private static void printOptimalPath(int[][] parent, int n) {
        int mask = 1, pos = 0;
        System.out.print("Optimal Path: 0 ");
        for (int i = 1; i < n; i++) {
            pos = parent[mask][pos];
            System.out.print("-> " + pos + " ");
            mask |= (1 << pos);
        }
        System.out.println("-> 0"); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of cities: ");
        int n = sc.nextInt();

        int[][] dist = new int[n][n];
        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
                parent[i][j] = -1;
            }
        }

        int minCost = tsp(dist, 1, 0, dp, parent);

        System.out.println("The minimum cost of visiting all cities is: " + minCost);

        printOptimalPath(parent, n);

        sc.close();
    }
}
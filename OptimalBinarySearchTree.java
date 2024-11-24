import java.util.Scanner;

public class OptimalBinarySearchTree {

    // Function to calculate the optimal cost of the binary search tree
    public static double optimalCost(int[] keys, double[] freq, int n) {
        double[][] cost = new double[n][n];
        double[][] root = new double[n][n];

        // Filling the cost matrix for single keys
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        // Fill cost matrix for chains of length 2 to n
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                cost[i][j] = Double.MAX_VALUE;

                // Try placing each key in the root
                for (int r = i; r <= j; r++) {
                    // Calculate cost when keys[r] is the root
                    double currentCost = ((r > i) ? cost[i][r - 1] : 0) +
                                         ((r < j) ? cost[r + 1][j] : 0) +
                                         sum(freq, i, j);

                    if (currentCost < cost[i][j]) {
                        cost[i][j] = currentCost;
                        root[i][j] = r;
                    }
                }
            }
        }

        // Print the optimal BST
        System.out.println("Optimal Cost: " + cost[0][n - 1]);
        System.out.println("Root matrix:");
        printMatrix(root, n);
        return cost[0][n - 1];
    }

    // Function to calculate the sum of frequencies from i to j
    public static double sum(double[] freq, int i, int j) {
        double total = 0;
        for (int k = i; k <= j; k++) {
            total += freq[k];
        }
        return total;
    }

    // Function to print the root matrix
    public static void printMatrix(double[][] root, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((int)root[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of keys: ");
        int n = sc.nextInt();

        int[] keys = new int[n];
        double[] freq = new double[n];

        System.out.println("Enter the keys and their frequencies:");
        for (int i = 0; i < n; i++) {
            keys[i] = sc.nextInt();
            freq[i] = sc.nextDouble();
        }

        // Calculate and print the optimal cost and the root matrix
        optimalCost(keys, freq, n);

        sc.close();
    }
}

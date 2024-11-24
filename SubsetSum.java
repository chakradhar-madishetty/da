import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSum {

    public static void findSubsets(int[] arr, int target, List<Integer> subset, int index) {
        if (target == 0) {
            System.out.println(subset);
            return;
        }

        if (target < 0 || index == arr.length) {
            return;
        }

        subset.add(arr[index]);
        findSubsets(arr, target - arr[index], subset, index + 1);

        subset.remove(subset.size() - 1);
        findSubsets(arr, target, subset, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the set: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the set:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum: ");
        int target = sc.nextInt();

        System.out.println("Subsets that sum to " + target + ":");
        findSubsets(arr, target, new ArrayList<>(), 0);

        sc.close();
    }
}
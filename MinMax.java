import java.util.Scanner;
public class MinMaxAlgorithm {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the number of elements: ");
 int n = scanner.nextInt();
 int[] array = new int[n];
 System.out.println("Enter the array elements:");
 for (int i = 0; i < n; i++) {
 array[i] = scanner.nextInt();
 }
 int[] minMax = findMinMax(array);
 System.out.println("Minimum element: " + minMax[0]);
 System.out.println("Maximum element: " + minMax[1]);
 scanner.close();
 }
 public static int[] findMinMax(int[] array) {
 int[] minMax = new int[2];
 if (array.length == 0) {
 return minMax; 
 }
 minMax[0] = minMax[1] = array[0]; 
 for (int i = 1; i < array.length; i++) {
 if (array[i] < minMax[0]) {
 minMax[0] = array[i]; 
 }
 if (array[i] > minMax[1]) {
 minMax[1] = array[i]; 
 }
 }
 return minMax;
 }
}

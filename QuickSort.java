import java.util.Arrays;
import java.util.Scanner;
public class QuickSort {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the number of elements: ");
 int n = scanner.nextInt();
 int[] array = new int[n];
 System.out.println("Enter the array elements:");
 for (int i = 0; i < n; i++)
 array[i] = scanner.nextInt();
 quickSort(array, 0, array.length - 1);
 System.out.println("\nArray after sorting:");
 System.out.println(Arrays.toString(array));
 scanner.close();
 }
 public static void quickSort(int[] array, int low, int high) {
 if (low < high) {
 int pi = partition(array, low, high);
 quickSort(array, low, pi - 1);
 quickSort(array, pi + 1, high);
 }
 }
 public static int partition(int[] array, int low, int high) {
 int pivot = array[high];
 int i = low - 1;
 for (int j = low; j < high; j++) {
 if (array[j] < pivot) {
 i++;
 int temp = array[i];
 array[i] = array[j];
 array[j] = temp;
 }
 }
 int temp = array[i + 1];
 array[i + 1] = array[high];
 array[high] = temp;
 return i + 1;
 }
}
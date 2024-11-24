import java.util.Arrays;
import java.util.Scanner;
public class MergeSort {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the number of elements: ");
 int n = scanner.nextInt();
 int[] array = new int[n];
 System.out.println("Enter the array elements:");
 for (int i = 0; i < n; i++)
 array[i] = scanner.nextInt();
 mergeSort(array);
 System.out.println("\nArray after sorting:");
 System.out.println(Arrays.toString(array));
 scanner.close();
 }
 public static void mergeSort(int[] array) {
 if (array.length > 1) {
 int mid = array.length / 2;
 int[] left = Arrays.copyOfRange(array, 0, mid);
 int[] right = Arrays.copyOfRange(array, mid, array.length);
 mergeSort(left);
 mergeSort(right);
 merge(array, left, right);
 }
 }
 public static void merge(int[] array, int[] left, int[] right) {
 int i = 0, j = 0, k = 0;
 while (i < left.length && j < right.length) {
 if (left[i] <= right[j])
 array[k++] = left[i++];
 else
 array[k++] = right[j++];
 }
 while (i < left.length)
 array[k++] = left[i++];
 while (j < right.length)
 array[k++] = right[j++];
 }
}

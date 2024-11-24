import java.util.Scanner;
public class BinarySearch {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the number of elements: ");
 int n = scanner.nextInt();
 int[] array = new int[n];
 System.out.println("Enter the sorted array elements:");
 for (int i = 0; i < n; i++) {
 array[i] = scanner.nextInt();
 }
 System.out.print("Enter the element to search: ");
 int target = scanner.nextInt();
 int result = binarySearch(array, target);
 if (result == -1) {
 System.out.println("Element not found");
 } else {
 System.out.println("Element found at index: " + result);
 }
 scanner.close();
 }
 public static int binarySearch(int[] array, int target) {
 int left = 0;
 int right = array.length - 1;
 while (left <= right) {
 int mid = left + (right - left) / 2;
 if (array[mid] == target) {
 return mid;
 } else if (array[mid] < target) {
 left = mid + 1;
 } else {
 right = mid - 1;
 }
 }
 return-1;
 }
}

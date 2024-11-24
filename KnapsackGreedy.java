import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KnapsackGreedy {

    static class Item {
        int weight, value;
        double ratio;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    public static int knapsackGreedy(Item[] items, int capacity) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.ratio, o1.ratio); 
            }
        });

        int totalValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                break;
            }
        }

        return totalValue;
    }

    public static Item[] inputItems(Scanner sc, int numItems) {
        Item[] items = new Item[numItems];
        System.out.println("Enter the weight and value of each item:");

        for (int i = 0; i < numItems; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }
        return items;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of items: ");
        int numItems = sc.nextInt();

        Item[] items = inputItems(sc, numItems);

        System.out.println("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();

        int maxValue = knapsackGreedy(items, capacity);

        System.out.println("Maximum value achievable with Greedy approach: " + maxValue);

        sc.close();
    }
}
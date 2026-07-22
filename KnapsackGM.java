package mrk2;

import java.util.Scanner;

class Item {
    int weight, profit;
    double ratio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

public class GM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();

        // Create Item objects
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weight[i], value[i]);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort by profit/weight ratio (descending)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (items[i].ratio < items[j].ratio) {
                    Item temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }

        double maxProfit = 0;

        // Greedy selection
        for (int i = 0; i < n; i++) {
            if (capacity >= items[i].weight) {
                capacity -= items[i].weight;
                maxProfit += items[i].profit;
            } else {
                maxProfit += items[i].ratio * capacity;
                break;
            }
        }

        System.out.println("Maximum Profit = " + maxProfit);

        sc.close();
    }
}

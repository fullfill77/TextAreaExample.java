import java.util.Scanner;

public class TSP 
{

    static int n;
    static int[][] cost;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    static void tsp(int current, int count, int totalCost) {

        // If all cities are visited
        if (count == n) {
            if (cost[current][0] != 0) { // Return to starting city
                minCost = Math.min(minCost, totalCost + cost[current][0]);
            }
            return;
        }

        // Try all unvisited cities
        for (int i = 0; i < n; i++) {
            if (!visited[i] && cost[current][i] != 0) {
                visited[i] = true;
                tsp(i, count + 1, totalCost + cost[current][i]);
                visited[i] = false; // Backtrack
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        cost = new int[n][n];
        visited = new boolean[n];

        System.out.println("Enter the cost matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        visited[0] = true; // Start from city 0

        tsp(0, 1, 0);

        System.out.println("Minimum Tour Cost = " + minCost);

        sc.close();
    }
}

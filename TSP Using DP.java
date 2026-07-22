package mrk2;

import java.util.*;

public class TSPdp {

    static int n, cost[][], dp[][];

    static int tsp(int mask, int pos) {

        // If all cities are visited, return to starting city
        if (mask == (1 << n) - 1)
            return cost[pos][0];

        // Return already computed result
        if (dp[mask][pos] != -1)
            return dp[mask][pos];

        int ans = Integer.MAX_VALUE;

        // Try visiting every unvisited city
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                ans = Math.min(ans,
                        cost[pos][i] + tsp(mask | (1 << i), i));
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        n = sc.nextInt();

        cost = new int[n][n];
        dp = new int[1 << n][n];

        System.out.println("Enter cost matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Minimum Tour Cost = " + tsp(1, 0));

        sc.close();
    }
}
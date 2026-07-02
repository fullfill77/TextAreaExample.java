import java.util.Scanner;

public class FloydWarshall {

    static final int INF = 99999;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter Adjacency Matrix (Enter 99999 for INF):");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (graph[i][k] != INF &&
                        graph[k][j] != INF &&
                        graph[i][k] + graph[k][j] < graph[i][j]) {

                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        System.out.println("\nShortest Distance Matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
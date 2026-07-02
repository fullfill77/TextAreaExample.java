import java.util.*;

public class PrimMST {

    static int minKey(int key[], boolean mstSet[], int V) {
        int min = Integer.MAX_VALUE, index = -1;

        for (int i = 0; i < V; i++) {
            if (!mstSet[i] && key[i] < min) {
                min = key[i];
                index = i;
            }
        }
        return index;
    }

    static void primMST(int graph[][], char vertices[], int V, int start) {

        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[start] = 0;
        parent[start] = -1;

        for (int i = 0; i < V - 1; i++) {

            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int totalCost = 0;

        System.out.println("\nMinimum Spanning Tree:");
        System.out.println("Edge\tWeight");

        for (int i = 0; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println(vertices[parent[i]] + " - " + vertices[i] + "\t" + key[i]);
                totalCost += key[i];
            }
        }

        System.out.println("Total Cost = " + totalCost);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        char vertices[] = new char[V];
        HashMap<Character, Integer> map = new HashMap<>();

        System.out.println("Enter vertex names:");
        for (int i = 0; i < V; i++) {
            vertices[i] = sc.next().charAt(0);
            map.put(vertices[i], i);
        }

        int graph[][] = new int[V][V];

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges (Source Destination Weight):");
        for (int i = 0; i < E; i++) {
            char u = sc.next().charAt(0);
            char v = sc.next().charAt(0);
            int w = sc.nextInt();

            int src = map.get(u);
            int dest = map.get(v);

            graph[src][dest] = w;
            graph[dest][src] = w;
        }

        System.out.print("Enter starting vertex: ");
        char start = sc.next().charAt(0);

        primMST(graph, vertices, V, map.get(start));

        sc.close();
    }
}
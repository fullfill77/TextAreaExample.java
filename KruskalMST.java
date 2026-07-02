import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class KruskalMST {

    static int find(int parent[], int  i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    static void union(int parent[], int x, int y) {
        parent[find(parent, x)] = find(parent, y);
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

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();

        System.out.println("Enter edges (Source Destination Weight):");
        for (int i = 0; i < E; i++) {
            char u = sc.next().charAt(0);
            char v = sc.next().charAt(0);
            int w = sc.nextInt();
            edges.add(new Edge(map.get(u), map.get(v), w));
        }

        Collections.sort(edges);

        int parent[] = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        int totalCost = 0;

        System.out.println("\nMinimum Spanning Tree:");
        System.out.println("Edge\tWeight");

        for (Edge e : edges) {
            if (find(parent, e.src) != find(parent, e.dest)) {
                System.out.println(vertices[e.src] + " - " + vertices[e.dest] + "\t" + e.weight);
                totalCost += e.weight;
                union(parent, e.src, e.dest);
            }
        }

        System.out.println("Total Cost = " + totalCost);

        sc.close();
    }
}
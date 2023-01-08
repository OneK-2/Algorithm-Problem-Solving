import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    private int nodeA;
    private int nodeB;
    private int distance;

    public Edge(int nodeA, int nodeB, int distance) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.distance < o.distance) return -1;
        return 1;
    }
}

public class Main {
    public static int n, m;
    public static int[] parent = new int[100001];
    public static ArrayList<Edge> edges = new ArrayList<Edge>();
    public static int result;

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);
        int maxCost = 0;

        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();

            //사이클이 없을 때
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
                maxCost = cost;
            }
        }
        System.out.println(result - maxCost);
    }
}
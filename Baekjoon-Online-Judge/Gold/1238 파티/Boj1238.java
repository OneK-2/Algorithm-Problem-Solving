import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<ArrayList<Node>> backGraph;
    static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        backGraph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            backGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, time));
            backGraph.get(end).add(new Node(start, time));
        }

        int[] dist = dijkstra(graph);
        int[] backDist = dijkstra(backGraph);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i] + backDist[i]);
        }

        System.out.println(ans);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.end;

            if (!visited[cur]) {
                visited[cur] = true;
                for (Node tmp : graph.get(cur)) {
                    if (!visited[tmp.end] && dist[tmp.end] > dist[cur] + tmp.cost) {
                        dist[tmp.end] = dist[cur] + tmp.cost;
                        pq.add(new Node(tmp.end, dist[tmp.end]));
                    }
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
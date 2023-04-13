import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }
        int[] dist = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            dist[i] = 100000000;
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.offer(new Node(K, 0));
        dist[K] = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (dist[now.idx] < now.cost) {
                continue;
            }
            for (int i = 0; i < graph.get(now.idx).size(); i++) {
                Node next = graph.get(now.idx).get(i);
                if (dist[next.idx] > now.cost + next.cost) {
                    dist[next.idx] = now.cost + next.cost;
                    queue.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == 100000000) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}

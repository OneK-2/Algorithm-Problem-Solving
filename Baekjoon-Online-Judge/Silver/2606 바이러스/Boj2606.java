import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new boolean[n + 1];
        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int e1 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(e1);
            graph.get(e1).add(n1);
        }
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
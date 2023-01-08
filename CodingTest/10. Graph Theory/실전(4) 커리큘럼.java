import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int[] inDegree = new int[501];
    public static int[] times = new int[501];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            times[i] = x;
            while (true) {
                x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                inDegree[i] += 1;
                graph.get(x).add(i);
            }
        }
        topologySort();
    }

    private static void topologySort() {
        int[] result = new int[501];
        for (int i = 1; i <= n; i++) {
            result[i] = times[i];
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + times[graph.get(now).get(i)]);
                inDegree[graph.get(now).get(i)] -= 1;
                if (inDegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}
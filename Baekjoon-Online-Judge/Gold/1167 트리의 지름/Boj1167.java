import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int ans = 0;
    static int tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[idx].add(new Node(end, cost));
            }
        }

        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(tmp, 0);

        System.out.println(ans);
    }

    private static void dfs(int idx, int sum) {
        if (sum > ans) {
            ans = sum;
            tmp = idx;
        }
        visited[idx] = true;

        for (int i = 0; i < list[idx].size(); i++) {
            Node node = list[idx].get(i);
            if (!visited[node.end]) {
                dfs(node.end, node.cost + sum);
                visited[node.end] = true;
            }
        }
    }

}

class Node {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
}
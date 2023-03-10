import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] graph = new int[1001][1001];
    public static boolean check[] = new boolean[1001];
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int idx) {
        if (check[idx]) return;
        else {
            check[idx] = true;
            for (int i = 1; i <= n; i++) {
                if (graph[idx][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}

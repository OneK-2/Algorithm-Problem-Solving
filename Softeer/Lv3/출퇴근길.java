import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        ArrayList<Integer>[] graphReverse = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            graphReverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graphReverse[y].add(x);
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] fromS = new int[n + 1];
        fromS[t] = 1;
        dfs(s, graph, fromS);

        int[] fromT = new int[n + 1];
        fromT[s] = 1;
        dfs(t, graph, fromT);

        int[] toS = new int[n + 1];
        dfs(s, graphReverse, toS);

        int[] toT = new int[n + 1];
        dfs(t, graphReverse, toT);

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (fromS[i] == 1 && fromT[i] == 1 && toS[i] == 1 && toT[i] == 1)
                cnt++;
        }


        System.out.println(cnt - 2);
    }

    private static void dfs(int s, ArrayList<Integer>[] graph, int[] vis) {
        if (vis[s] == 1) return;
        vis[s] = 1;
        for (int x : graph[s]) {
            dfs(x, graph, vis);
        }
    }
}

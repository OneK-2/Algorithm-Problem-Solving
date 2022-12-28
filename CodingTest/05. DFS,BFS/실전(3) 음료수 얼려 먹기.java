import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= n || y <= -1 || y >= m) return false;

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x, y - 1);
            dfs(x, y + 1);
            dfs(x - 1, y);
            dfs(x + 1, y);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //세로길이 n 가로길이 m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(str.split("")[j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

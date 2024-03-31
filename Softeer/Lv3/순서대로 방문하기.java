import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visit;
    static Point[] des;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visit = new boolean[n][n];
        des = new Point[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            int x = Integer.parseInt(String.valueOf(str.charAt(0)));
            int y = Integer.parseInt(String.valueOf(str.charAt(2)));
            des[i] = new Point(x - 1, y - 1);
        }
        dfs(des[0], 1);

        System.out.println(cnt);
    }

    static void dfs(Point cur, int idx) {
        if (cur.equals(des[idx])) {
            if (idx == m - 1) {
                cnt++;
                return;
            }
            idx++;
        }
        int x = cur.x;
        int y = cur.y;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny] && arr[nx][ny] != 1) {
                dfs(new Point(nx, ny), idx);
            }
        }
        visit[x][y] = false;
        return;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point obj) {
            return this.x == obj.x && this.y == obj.y;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            if (inRange(curX, curY) && !visited[curX][curY]) {
                if (cnt == 2) { //ㅗ 모양 -> 2번째 칸에서 탐색 다시 진행
                    visited[curX][curY] = true;
                    dfs(x, y, sum + arr[curX][curY], cnt + 1);
                    visited[curX][curY] = false;
                }
                visited[curX][curY] = true;
                dfs(curX, curY, sum + arr[curX][curY], cnt + 1);
                visited[curX][curY] = false;
            }
        }
    }

    private static boolean inRange(int curX, int curY) {
        return curX >= 0 && curY >= 0 && curX < n && curY < m;
    }

}

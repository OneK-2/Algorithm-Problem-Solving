import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R, C;
    static int[][] arr;
    static boolean[] visited = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {
        if (visited[arr[x][y]]) {
            max = Math.max(max, cnt);
            return;
        } else {
            visited[arr[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (inRange(nx, ny)) {
                    dfs(nx, ny, cnt + 1);
                }
            }
            visited[arr[x][y]] = false;
        }
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < R && ny < C;
    }

}

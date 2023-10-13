import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {-1, 0, 0, 1}; //상 좌 우 하
    static int dy[] = {0, -1, 1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 격자크기

        arr = new int[n][n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > maxHeight) {
                    maxHeight = arr[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < maxHeight + 1; i++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && arr[j][k] > i) {
                        cnt += dfs(j, k, i);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y, int height) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny) && !visited[nx][ny] && arr[nx][ny] > height) {
                dfs(nx, ny, height);
            }
        }
        return 1;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        int nCnt = 0;
        int sCnt = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        //적록색약 아닌 사람
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    nCnt++;
                }
            }
        }

        //적록색약
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) { // G로 통일
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    sCnt++;
                }
            }
        }
        System.out.println(nCnt + " " + sCnt);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        char tmp = arr[i][j];
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (inRange(nx, ny) && !visited[nx][ny] && arr[nx][ny] == tmp) {
                dfs(nx, ny);
            }
        }
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}

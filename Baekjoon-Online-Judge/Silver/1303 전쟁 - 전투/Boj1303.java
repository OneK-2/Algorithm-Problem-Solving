import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cntW, cntB;
    static char[][] arr;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int maxW = 0, maxB = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, arr[i][j]);
                    maxW += cntW * cntW;
                    maxB += cntB * cntB;
                    cntW = 0;
                    cntB = 0;
                }
            }
        }
        System.out.println(maxW + " " + maxB);
    }

    private static void DFS(int i, int j, char c) {
        visited[i][j] = true;
        if (c == 'W') {
            cntW++;
        } else {
            cntB++;
        }
        for (int k = 0; k < 4; k++) {
            int curX = i + dx[k];
            int curY = j + dy[k];

            if (inRange(curX, curY) && !visited[curX][curY] && arr[curX][curY] == c) {
                DFS(curX, curY, c);
            }
        }
    }

    private static boolean inRange(int curX, int curY) {
        return curX >= 0 && curY >= 0 && curX < m && curY < n;
    }

}
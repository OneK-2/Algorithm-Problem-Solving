import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m, k, cnt, val;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            int startX = m - sy;
            int startY = sx;
            int endX = m - ey;
            int endY = ex;
            for (int j = endX; j < startX; j++) {
                for (int l = startY; l < endY; l++) {
                    arr[j][l] = 1;
                }
            }
        }
        List<Integer> area = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                    val = 0;
                    dfs(i, j);
                    area.add(val);
                }
            }
        }
        Collections.sort(area);
        System.out.println(cnt);
        for (int v :
                area) {
            System.out.print(v + " ");
        }

    }

    static void dfs(int x, int y) {
        arr[x][y] = 1;
        val++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (arr[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }

        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] land;
    public static boolean[][] isVisited;
    public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1}; //상 하 좌 우 대각(좌상 우상 좌하 우하)
    public static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            land = new int[h][w];
            isVisited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!isVisited[i][j] && land[i][j] == 1) {
                        cnt++;
                        DFS(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int x, int y) {
        isVisited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (!isVisited[nx][ny] && land[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }
}

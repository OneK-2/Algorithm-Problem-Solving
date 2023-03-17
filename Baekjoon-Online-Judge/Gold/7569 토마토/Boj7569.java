import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int n, m, h;
    static int[][][] board;
    static Queue<Tomato> queue = new LinkedList<Tomato>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 1) queue.add(new Tomato(i, j, k));
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            int x = tomato.x; //세로
            int y = tomato.y;
            int z = tomato.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
                    if (board[nz][nx][ny] == 0) {
                        queue.add(new Tomato(nz, nx, ny));
                        board[nz][nx][ny] = board[z][x][y] + 1;
                    }
                }
            }
        }
        int result = -10000000;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) return -1;
                    result = Math.max(result, board[i][j][k]);
                }
            }
        }
        if (result == 1) return 0;
        else return result - 1;
    }
}

class Tomato {
    int x;
    int y;
    int z;

    public Tomato(int z, int x, int y) {
        this.x = x; //세로
        this.y = y;
        this.z = z;
    }
}

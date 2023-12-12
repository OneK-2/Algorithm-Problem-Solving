import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;

            if (x == n - 1 && y == m - 1) {
                System.out.println(cur.distance);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (arr[nx][ny] == 0 && !visited[nx][ny][cur.destroyed]) {//벽x
                    visited[nx][ny][cur.destroyed] = true;
                    queue.add(new Node(nx, ny, cur.distance + 1, cur.destroyed));
                } else { //벽o
                    if (cur.destroyed == 0 && !visited[nx][ny][cur.destroyed + 1]) {
                        visited[nx][ny][cur.destroyed + 1] = true;
                        queue.add(new Node(nx, ny, cur.distance + 1, cur.destroyed + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}

class Node {
    int x, y;
    int distance;
    int destroyed;

    public Node(int x, int y, int distance, int destroyed) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.destroyed = destroyed;
    }
}
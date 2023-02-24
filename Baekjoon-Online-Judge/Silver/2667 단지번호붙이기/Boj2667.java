import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] arr = new int[25][25];
    public static boolean[][] visited = new boolean[25][25];
    public static int[] buildingCnt = new int[25 * 25];
    public static int n = 0;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        Arrays.sort(buildingCnt);
        System.out.println(cnt);
        for (int i = 0; i < buildingCnt.length; i++) {
            if (buildingCnt[i] != 0) System.out.println(buildingCnt[i]);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        buildingCnt[cnt]++;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        buildingCnt[cnt]++;
                    }
                }
            }
        }

    }
}

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
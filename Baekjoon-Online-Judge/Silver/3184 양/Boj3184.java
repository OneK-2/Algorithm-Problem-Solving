import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] visited;
    static int cntO = 0, cntV = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int sumO = 0, sumV = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && arr[i][j] != '#') {
                    dfs(i, j);
                    if (cntV >= cntO) {
                        sumV += cntV;
                    } else {
                        sumO += cntO;
                    }
                }
                cntO = 0;
                cntV = 0;
            }
        }
        System.out.println(sumO + " " + sumV);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        if (arr[x][y] == 'o') {
            cntO++;
        } else if (arr[x][y] == 'v') {
            cntV++;
        }
        for (int i = 0; i < 4; i++) {
            int curx = x + dx[i];
            int cury = y + dy[i];
            if (inRange(curx, cury) && !visited[curx][cury] && arr[curx][cury] != '#') {
                dfs(curx, cury);
            }
        }
    }

    private static boolean inRange(int curx, int cury) {
        return curx >= 0 && cury >= 0 && curx < r && cury < c;
    }

}
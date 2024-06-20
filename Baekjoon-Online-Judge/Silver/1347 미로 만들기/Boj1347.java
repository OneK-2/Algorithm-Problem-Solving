import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dir = 0; //남0 서1 북2 동3
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        //미로 안의 한 칸에 남쪽을 보며 서있다
        //이동 가능,or 벽 .은 이동 가능, #은 벽
        // F => 앞, L: 왼쪽 방향 전환, R: 오른쪽 방향 전환

        char arr[][] = new char[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++)
                arr[i][j] = '#';
        }

        int cx = 50;
        int cy = 50;
        int maxX = 50, maxY = 50, minX = 50, minY = 50;

        arr[cx][cy] = '.';
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'R') {
                turnRight();
            } else if (c == 'L') {
                turnLeft();
            } else { // F
                cx = cx + dx[dir];
                cy = cy + dy[dir];

                arr[cx][cy] = '.';
                maxX = Math.max(maxX, cx);
                maxY = Math.max(maxY, cy);
                minX = Math.min(minX, cx);
                minY = Math.min(minY, cy);
            }
        }
        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static void turnRight() {
        dir = (dir + 1) % 4;
    }

    static void turnLeft() {
        dir = (dir + 3) % 4;
    }
}


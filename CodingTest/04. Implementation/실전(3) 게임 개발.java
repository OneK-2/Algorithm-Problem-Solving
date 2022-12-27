import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int dir, x, y;

    public static void turnLeft() {
        dir -= 1;
        if (dir == -1) dir = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //세로크기 n 가로크기 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[][] visitArr = new int[n][m];
        visitArr[x][y] = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //북 동 남 서
        int dx[] = {0, 1, 0, -1};
        int dy[] = {-1, 0, 1, 0};

        int cnt = 1;
        int turnCnt = 0;
        while (true) {
            turnLeft();
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            //육지면 한칸 전진
            if (visitArr[nx][ny] == 0 && arr[nx][ny] == 0) {
                visitArr[nx][ny] = 1;
                cnt++;
                x = nx;
                y = ny;
            }
            //아니면 다시 회전하기 위해 카운트+
            else {
                turnCnt++;
            }
            //모두 막힌경우
            if (turnCnt == 4) {
                nx = x - dx[dir];
                ny = y - dy[dir];
                //뒤로 돌아갈 수 있으면 복귀
                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                //뒤가 막힌경우
                else break;
                turnCnt = 0;
            }
        }
        System.out.println(cnt);
    }
}

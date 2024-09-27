import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n * 2 + 1];
        boolean[] robot = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        while (true) {
            result++;
            //1. 벨트가 로봇과 함께 한칸 회전
            int tmp = arr[2 * n];
            for (int i = 2 * n; i > 1; i--) {
                arr[i] = arr[i - 1];
            }
            arr[1] = tmp;
            for (int i = n; i > 1; i--) {
                robot[i] = robot[i - 1];
            }
            robot[1] = false;
            robot[n] = false;

            //2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            //이동할수 없으면 가만히 있는다.
            //2.1 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for (int i = n; i > 1; i--) {
                if (robot[i - 1] && !robot[i] && arr[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    arr[i]--;
                    robot[n] = false;
                }
            }

            //3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (arr[1] > 0) {
                robot[1] = true;
                arr[1]--;
            }

            //4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료
            int cnt = 0;
            for (int i = 1; i <= 2 * n; i++) {
                if (arr[i] == 0) cnt++;
            }
            if (cnt >= k) break;
        }
        System.out.println(result);
    }

}


/**
 * 2 ≤ N ≤ 100
 * 1 ≤ K ≤ 2N
 * 1 ≤ Ai ≤ 1,000
 * 첫째 줄에 N, K가 주어진다. 둘째 줄에는 A1, A2, ..., A2N이 주어진다.
 */
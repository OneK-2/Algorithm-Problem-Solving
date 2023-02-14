import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            //사자x dp[n][0]
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            //왼쪽 방 사자 dp[n][1], 이전 방은 오른쪽 or 빈방
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            //오른쪽 방 사자 dp[n][2] 이전 방은 왼쪽 or 빈방
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += dp[n][i];
        }
        System.out.println(result % 9901);
    }
}
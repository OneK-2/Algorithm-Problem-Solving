import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[16];

        dp[0] = 2;
        int idx = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + idx;
            idx *= 2;
        }

        int result = dp[N] * dp[N];

        System.out.println(result);
    }
}
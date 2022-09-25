package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1003 {
    static Integer dp[][] = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int fib = Integer.parseInt(br.readLine());
            fibona(fib);
            sb.append(dp[fib][0] + " " + dp[fib][1] + "\n");
        }
        System.out.println(sb);
    }

    static Integer[] fibona(int fib) {
        if (dp[fib][0] == null || dp[fib][1] == null) {
            dp[fib][0] = fibona(fib - 1)[0] + fibona(fib - 2)[0];
            dp[fib][1] = fibona(fib - 1)[1] + fibona(fib - 2)[1];
        }
        return dp[fib];
    }
}

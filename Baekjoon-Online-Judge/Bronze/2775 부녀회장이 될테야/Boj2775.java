import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int dp[][] = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}
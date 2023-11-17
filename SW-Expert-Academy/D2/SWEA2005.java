
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] dp = new int[N][N];
            dp[0][0] = 1;
            for (int i = 1; i < N; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
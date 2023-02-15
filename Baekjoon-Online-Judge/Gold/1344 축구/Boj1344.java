import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double a = Integer.parseInt(br.readLine());
        double b = Integer.parseInt(br.readLine());

        double dp[][][] = new double[19][19][19];
        double result = 0;
        a /= 100;
        b /= 100;
        dp[0][0][0] = 1;

        for (int i = 1; i <= 18; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    //a만 득점
                    if (j > 0) dp[i][j][k] += dp[i - 1][j - 1][k] * a * (1 - b);
                    //b만 득점
                    if (k > 0) dp[i][j][k] += dp[i - 1][j][k - 1] * (1 - a) * b;
                    //둘다 득점
                    if (j > 0 && k > 0) dp[i][j][k] += dp[i - 1][j - 1][k - 1] * a * b;
                    //둘다 실패
                    dp[i][j][k] += dp[i - 1][j][k] * (1 - a) * (1 - b);
                }
            }
        }
        for (int i = 0; i <= 18; i++) {
            for (int j = 0; j <= 18; j++) {
                if (isPrime(i) || isPrime(j)) {
                    result += dp[18][i][j];
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
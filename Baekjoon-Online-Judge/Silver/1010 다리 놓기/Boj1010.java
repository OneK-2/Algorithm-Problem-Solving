import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(cir(m, n)).append("\n");
        }
        System.out.println(sb);
    }

    public static int cir(int n, int r) {
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        return dp[n][r] = cir(n - 1, r - 1) + cir(n - 1, r);
    }
}

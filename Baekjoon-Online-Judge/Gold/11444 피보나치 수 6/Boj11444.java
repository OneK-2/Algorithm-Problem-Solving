import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 1000000007;
    static long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long n = Long.parseLong(br.readLine());
        long[][] arr = {{1, 1}, {1, 0}};

        System.out.println(fibo(arr, n - 1)[0][0]);
    }

    private static long[][] fibo(long[][] arr, long l) {
        if (l == 1 || l == 0) {
            return arr;
        }

        long[][] tmp = fibo(arr, l / 2);
        tmp = multi(tmp, tmp);

        if (l % 2 == 1) {
            tmp = multi(tmp, origin);
        }
        return tmp;
    }

    private static long[][] multi(long[][] tmp, long[][] tmp1) {
        long[][] res = new long[2][2];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    res[i][j] += tmp[i][k] * tmp1[k][j];
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }

}
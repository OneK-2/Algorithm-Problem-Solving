import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long k = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        n *= 10;
        long sum = cirIncrease(p, n) * k;
        sum %= mod;

        System.out.println(sum);
    }

    private static long cirIncrease(long p, long n) {
        if (n == 1)
            return p;
        long tmp = cirIncrease(p, n / 2);
        if (n % 2 == 0)
            return (tmp * tmp) % mod;
        else {
            tmp *= tmp;
            tmp %= mod;
            return (tmp * p) % mod;
        }
    }
}
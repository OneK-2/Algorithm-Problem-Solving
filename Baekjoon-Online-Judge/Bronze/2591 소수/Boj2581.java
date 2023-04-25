import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = Integer.MAX_VALUE;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        isPrime = new boolean[m + 1];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) continue;
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }

        for (int i = n; i <= m; i++) {
            if (!isPrime[i]) {
                sum += i;
                if (min == Integer.MAX_VALUE) min = i;
            }
        }

        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

}

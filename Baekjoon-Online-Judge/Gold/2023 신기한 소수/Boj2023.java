import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sol(0, n);
        System.out.println(sb);
    }

    public static void sol(int num, int n) {
        if (n == 0) {
            if (isPrime(num)) {
                sb.append(num + "\n");
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) sol(next, n - 1);
        }

    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
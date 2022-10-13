import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isPrime = true;

            if (num == 1) continue;
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) isPrime = false;
            }
            if (isPrime) cnt++;
        }
        System.out.println(cnt);
    }
}

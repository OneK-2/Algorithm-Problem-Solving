import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        while (n > 1) {
            if (n % k != 0) {
                n = n - 1;
                cnt++;
            } else {
                n /= k;
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
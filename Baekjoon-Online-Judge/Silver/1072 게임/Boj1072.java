import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = 100 * y / x;
        int cnt = -1;

        int start = 0;
        int end = (int) 1e9;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = (int) ((y + mid) * 100 / (x + mid));
            if (sum != z) {
                cnt = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(cnt);
    }
}

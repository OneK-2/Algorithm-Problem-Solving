import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 2;
        int cnt = 1;

        if (n == 1) {
            System.out.print(cnt);
        } else {
            while (result <= n) {
                result = result + (6 * cnt);
                cnt++;
            }
            System.out.print(cnt);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 666; ; i++) {
            String s = Integer.toString(i);
            if (s.contains("666") == true) {
                cnt++;
            }
            if (cnt == n) {
                System.out.println(i);
                break;
            }
        }
    }
}

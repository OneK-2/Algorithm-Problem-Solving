import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] brokenButton = new boolean[10];

        if (m != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                brokenButton[tmp] = true;
            }
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            String str = String.valueOf(i);
            int targetCnt = str.length();
            boolean isBroke = false;
            for (int j = 0; j < targetCnt; j++) {
                if (brokenButton[str.charAt(j) - '0']) {
                    isBroke = true;
                    break;
                }
            }
            if (!isBroke) {
                int min = targetCnt + Math.abs(n - i);
                result = Math.min(min, result);
            }
        }
        System.out.print(result);
    }
}

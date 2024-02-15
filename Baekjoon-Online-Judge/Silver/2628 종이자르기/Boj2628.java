import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int[] cntR = new int[r + 1];
        int[] cntC = new int[c + 1];

        for (int i = 0; i < n; i++) {
            //0 가로 1 세로
            st = new StringTokenizer(br.readLine());
            int chk = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (chk == 1) {
                cntR[num] = 1;
            } else {
                cntC[num] = 1;
            }
        }

        int tmp = 0;
        int maxR = 0;
        int maxC = 0;
        for (int i = 1; i <= r; i++) {
            tmp++;
            if (cntR[i] == 1 || i == r) {
                maxR = Math.max(tmp, maxR);
                tmp = 0;
            }
        }
        tmp = 0;
        for (int i = 1; i <= c; i++) {
            tmp++;
            if (cntC[i] == 1 || i == c) {
                maxC = Math.max(tmp, maxC);
                tmp = 0;
            }
        }
        System.out.println(maxR * maxC);
    }
}
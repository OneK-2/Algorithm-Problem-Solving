import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arrLimit = new int[N][2];
        int[][] arrTest = new int[M][2];
        for (int i = 0; i < N; i++) { //구간의길이, 해당 제한 속도
            st = new StringTokenizer(br.readLine());
            arrLimit[i][0] = Integer.parseInt(st.nextToken());
            arrLimit[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arrTest[i][0] = Integer.parseInt(st.nextToken());
            arrTest[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i < M; i++) {
            for (int j = idx; j < M; j++) {
                if (arrLimit[i][0] < arrTest[j][0]) {
                    arrTest[j][0] -= arrLimit[i][0];
                    if (arrTest[j][1] > arrLimit[i][1]) max = Math.max(max, arrTest[j][1] - arrLimit[i][1]);
                    break;
                } else if (arrLimit[i][0] > arrTest[j][0]) {
                    arrLimit[i][0] -= arrTest[j][0];
                    if (arrTest[j][1] > arrLimit[i][1]) max = Math.max(max, arrTest[j][1] - arrLimit[i][1]);
                    idx++;
                } else {
                    if (arrTest[j][1] > arrLimit[i][1]) max = Math.max(max, arrTest[j][1] - arrLimit[i][1]);
                    idx++;
                    break;
                }
            }

        }
        System.out.println(max);
    }

}

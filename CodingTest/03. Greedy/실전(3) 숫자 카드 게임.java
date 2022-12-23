import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;
        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            int min = 10001;
            for (int k = 0; k < m; k++) {
                min = Math.min(min, arr[i][k]);
            }
            result = Math.max(result, min);
        }
        System.out.println(result);
    }
}

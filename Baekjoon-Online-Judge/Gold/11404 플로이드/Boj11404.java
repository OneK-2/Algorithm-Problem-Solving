import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = 99999001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INF;
            }
            arr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(c, arr[a][b]);
        }

        for (int i = 1; i <= n; i++) { //경유지
            for (int j = 1; j <= n; j++) { //출발
                for (int k = 1; k <= n; k++) { //도착
                    if (arr[j][k] > arr[j][i] + arr[i][k])
                        arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(arr[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
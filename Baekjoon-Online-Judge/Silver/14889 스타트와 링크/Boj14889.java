import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visit;
    static int[][] arr;
    static int min = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
        System.out.println(min);
    }

    public static void recur(int idx, int depth) {
        if (depth == n / 2) {
            cirMin();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                recur(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void cirMin() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    sum1 += arr[i][j] + arr[j][i];
                } else if (!visit[i] && !visit[j]) {
                    sum2 += arr[i][j] + arr[j][i];
                }
            }
        }
        int tmp = Math.abs(sum1 - sum2);
        min = Math.min(tmp, min);
    }

}

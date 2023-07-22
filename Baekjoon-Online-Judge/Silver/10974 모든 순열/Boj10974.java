import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] result;
    static boolean[] visit;

    // n개의 방에 한개의 컴퓨터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n + 1];
        visit = new boolean[n + 1];
        recur(0);

    }

    private static void recur(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = i;
                recur(depth + 1);
                visit[i] = false;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min;

        int[] pack = new int[m];
        int[] nat = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            nat[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pack);
        Arrays.sort(nat);

        min = Math.min((pack[0] * (n / 6 + 1)), n * nat[0]);
        min = Math.min(min, ((n / 6) * pack[0]) + (n % 6) * nat[0]);
        System.out.println(min);
    }
}
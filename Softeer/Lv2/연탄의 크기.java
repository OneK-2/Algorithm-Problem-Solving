import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= 100; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] >= i && arr[j] % i == 0) cnt++;
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}

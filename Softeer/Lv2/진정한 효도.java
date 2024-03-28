import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 100;

        for (int i = 0; i < 3; i++) {
            int max = 0;
            int min = 100;
            for (int j = 0; j < 3; j++) {
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
            ans = Math.min(ans, max - min);
        }
        for (int i = 0; i < 3; i++) {
            int max = 0;
            int min = 100;
            for (int j = 0; j < 3; j++) {
                max = Math.max(max, arr[j][i]);
                min = Math.min(min, arr[j][i]);
            }
            ans = Math.min(ans, max - min);
        }
        System.out.println(ans);
    }
}

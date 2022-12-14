package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
    public static boolean arr[][];
    public static int min = 64;

    public static void getSolution(int i, int j) {
        int i_row = i + 8;
        int j_col = j + 8;
        int cnt = 0;
        boolean BW = arr[i][j];

        for (int k = i; k < i_row; k++) {
            for (int l = j; l < j_col; l++) {
                if (arr[k][l] != BW) cnt++;
                BW = !BW;
            }
            BW = !BW;
        }
        cnt = Math.min(cnt, 64 - cnt);
        min = Math.min(cnt, min);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') arr[i][j] = true; //흰색 true
                else arr[i][j] = false;
            }
        }
        int row = n - 7;
        int col = m - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                getSolution(i, j);
            }
        }
        System.out.println(min);
    }
}

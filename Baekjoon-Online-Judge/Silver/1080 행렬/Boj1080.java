import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arrA[][] = new int[n][m];
        int arrB[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arrA[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arrB[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrA[i][j] != arrB[i][j] && i + 2 < n && j + 2 < m) {
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            arrA[k][l] = arrA[k][l] == 0 ? 1 : 0;
                        }
                    }
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrA[i][j] != arrB[i][j]) {
                    System.out.println("-1");
                    return;
                }
            }
        }

        System.out.println(cnt);
    }
}
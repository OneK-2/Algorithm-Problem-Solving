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
        char[][] arr = new char[n][m];
        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) rowCnt++;
        }
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) colCnt++;
        }
        System.out.println(Math.max(rowCnt, colCnt));
    }
}
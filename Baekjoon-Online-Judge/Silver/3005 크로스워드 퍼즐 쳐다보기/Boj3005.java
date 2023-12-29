import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        ArrayList<String> ans = new ArrayList<String>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int len = 0;
        for (int i = 0; i < r; i++) {
            String tmp = "";
            len = 0;
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '#') {
                    if (len >= 2) {
                        ans.add(tmp);
                    }
                    len = 0;
                    tmp = "";
                } else {
                    tmp += arr[i][j];
                    len++;
                }
            }
            if (tmp.length() >= 2) {
                ans.add(tmp);
            }
        }

        for (int i = 0; i < c; i++) {
            String tmp = "";
            len = 0;
            for (int j = 0; j < r; j++) {
                if (arr[j][i] == '#') {
                    if (len >= 2) {
                        ans.add(tmp);
                    }
                    len = 0;
                    tmp = "";
                } else {
                    tmp += arr[j][i];
                    len++;
                }
            }
            if (tmp.length() >= 2) {
                ans.add(tmp);
            }
        }

        Collections.sort(ans);
        System.out.println(ans.get(0));
    }
}
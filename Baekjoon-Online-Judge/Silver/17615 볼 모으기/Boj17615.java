import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        int min = 10000000;
        int rCnt = 0, bCnt = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'R')
                rCnt++;
            else
                bCnt++;
        }

        int tmp = 0;
        //왼쪽으로 R넘기기
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'R')
                tmp++;
            else break;
        }
        min = Math.min(min, rCnt - tmp);
        //왼쪽으로 B넘기기
        tmp = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'B')
                tmp++;
            else break;
        }
        min = Math.min(min, bCnt - tmp);
        //오른쪽으로 R넘기기
        tmp = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R')
                tmp++;
            else break;
        }
        min = Math.min(min, rCnt - tmp);
        //오른쪽으로 B넘기기
        tmp = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B')
                tmp++;
            else break;
        }
        min = Math.min(min, bCnt - tmp);

        System.out.println(min);
    }
}
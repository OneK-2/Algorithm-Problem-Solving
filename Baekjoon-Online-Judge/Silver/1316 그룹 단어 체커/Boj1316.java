import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (isGroup() == true) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean isGroup() throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            //앞 글자랑 다를 때
            if (prev != now) {
                //문자가 처음 나오는 경우
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

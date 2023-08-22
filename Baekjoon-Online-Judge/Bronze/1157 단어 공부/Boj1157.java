import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int[26];
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i);
            if ('a' <= tmp && 'z' >= tmp) {
                tmp -= 'a';
            } else if ('A' <= tmp && 'Z' >= tmp) {
                tmp -= 'A';
            }
            cnt[tmp]++;
        }
        int idx = 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }
        for (int i = 0; i < 26; i++) {
            if (max == cnt[i]) {
                count++;
                idx = i;
            }
        }
        if (count >= 2) {
            System.out.println("?");
        } else {
            System.out.println((char) (idx + 65));
        }

    }

}

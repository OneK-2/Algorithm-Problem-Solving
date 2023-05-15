import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        Character[] c = new Character[len];
        for (int i = 0; i < len; i++) {
            c[i] = str.charAt(i);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += c[i] - '0';
        }
        Arrays.sort(c, Collections.reverseOrder());
        if (sum % 3 != 0 || c[len - 1] != '0') {
            System.out.println(-1);
        } else {
            String sortStr = "";
            for (int i = 0; i < len; i++) {
                sortStr += c[i];
            }
            System.out.println(sortStr);
        }
    }
}

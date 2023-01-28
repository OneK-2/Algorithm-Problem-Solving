import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int cnt1 = 0;
        int cnt0 = 0;

        if (str.charAt(0) == '1') {
            cnt0++;
        } else {
            cnt1++;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '1') {
                    cnt0++;
                } else cnt1++;
            }
        }
        System.out.println(Math.min(cnt1, cnt0));
    }
}
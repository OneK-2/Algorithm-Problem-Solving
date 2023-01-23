import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        int len = str[0].length();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < n; j++) {
                set.add(str[j].substring(len - i));
            }
            if (set.size() == n) {
                System.out.println(i);
                return;
            }
            set.clear();
        }
    }
}
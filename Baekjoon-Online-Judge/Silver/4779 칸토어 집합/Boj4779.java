import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            sb = new StringBuilder();
            int len = (int) Math.pow(3, n);

            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            sol(0, len);
            System.out.println(sb);
        }
    }

    static void sol(int start, int len) {
        if (len == 1) return;
        int space = len / 3;
        for (int i = start + space; i < start + space * 2; i++) {
            sb.setCharAt(i, ' ');
        }
        sol(start, space);
        sol(start + space * 2, space);
    }
}

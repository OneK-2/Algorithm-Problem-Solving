import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - '0';
            String tmp = Integer.toBinaryString(n);
            if (tmp.length() == 3) {
                sb.append(tmp);
            } else if (tmp.length() == 2 && i != 0) {
                sb.append("0" + tmp);
            } else if (tmp.length() == 1 && i != 0) {
                sb.append("00" + tmp);
            } else
                sb.append(tmp);
        }
        System.out.println(sb);
    }
}
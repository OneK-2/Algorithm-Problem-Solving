import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            String s = Integer.toString(n);
            StringBuilder sb = new StringBuilder(s);
            String rev = sb.reverse().toString();

            if (s.equals(rev)) System.out.println("yes");
            else System.out.println("no");
            st= new StringTokenizer(br.readLine());
        }
    }
}

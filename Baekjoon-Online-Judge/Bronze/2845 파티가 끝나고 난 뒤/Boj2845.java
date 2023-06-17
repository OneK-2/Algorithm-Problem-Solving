import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = n * m;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(st.nextToken());
            System.out.print(a - result + " ");
        }
    }

}
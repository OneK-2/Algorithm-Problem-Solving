import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        long[] len = new long[num - 1];
        long[] oilPrice = new long[num];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num - 1; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            oilPrice[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        long minPrice = oilPrice[0];
        for (int i = 0; i < num - 1; i++) {
            if (oilPrice[i] < minPrice) {
                minPrice = oilPrice[i];
            }
            sum += minPrice * len[i];
        }
        System.out.println(sum);
    }
}

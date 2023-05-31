import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j <= i; j++) {
                arr.add(i + 1);
            }
        }
        int sum = 0;
        for (int i = a - 1; i <= b - 1; i++) {
            sum += arr.get(i);
        }
        System.out.println(sum);
    }
}

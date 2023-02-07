import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1<=n<=10
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[26];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int len = str.length();
            int mul = (int) Math.pow(10, len - 1);
            for (int j = 0; j < len; j++) {
                arr[str.charAt(j) - 'A'] += mul;
                mul /= 10;
            }
        }
        Arrays.sort(arr);

        int result = 0;
        for (int i = 25; i >= 17; i--) {
            result += arr[i] * (i - 16);
        }
        System.out.println(result);

    }
}
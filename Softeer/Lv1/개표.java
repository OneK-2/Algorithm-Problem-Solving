import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[101];
        String[] ans = new String[101];

        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            ans[i] = "0";
        }

        for (int i = 1; i <= T; i++) {
            int num = arr[i];
            int p = num / 5;
            int c = num % 5;
            for (int j = 0; j < p; j++) {
                ans[i] += "++++ ";
            }
            for (int j = 0; j < c; j++) {
                ans[i] += "|";
            }
            if (!ans[i].equals("0")) ans[i] = ans[i].substring(1);
        }

        for (int i = 1; i <= T; i++) {
            System.out.println(ans[i]);
        }
    }
}

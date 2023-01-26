import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int arr[] = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == 6) {
                arr[9]++;
            } else {
                arr[num]++;
            }
        }
        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, arr[i]);
        }
        max = Math.max(max, (arr[9]+1) / 2);
        System.out.println(max);
    }
}
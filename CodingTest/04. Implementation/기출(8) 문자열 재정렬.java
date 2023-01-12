import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        int sum = 0;
        ArrayList<Character> arr = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                arr.add(s.charAt(i));
            } else
                sum += s.charAt(i) - '0';
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        sb.append(sum);
        System.out.println(sb.toString());
    }
}

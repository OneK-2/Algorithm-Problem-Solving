import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        List<String> arr = new ArrayList<>();

        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                StringBuilder s1 = new StringBuilder(str.substring(0, i));
                StringBuilder s2 = new StringBuilder(str.substring(i, j));
                StringBuilder s3 = new StringBuilder(str.substring(j));
                StringBuilder sb = new StringBuilder();
                sb.append(s1.reverse()).append(s2.reverse()).append(s3.reverse());
                arr.add(sb.toString());
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));
    }

}
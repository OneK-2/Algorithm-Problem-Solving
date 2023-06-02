import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String A = "AAAA";
        String B = "BB";
        str = str.replaceAll("XXXX", A);
        str = str.replaceAll("XX", B);
        if (str.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(str);
        }
    }
}

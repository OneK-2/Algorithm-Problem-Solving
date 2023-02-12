import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long result = 1;

        while (n >= 5) {
            result = (3 * result) % 10007;
            n -= 3;
        }
        result = n * result % 10007;
        System.out.println(result);
    }
}
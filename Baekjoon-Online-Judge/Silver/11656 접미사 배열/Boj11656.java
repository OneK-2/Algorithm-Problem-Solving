import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] sortArr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            sortArr[i] = str.substring(i);
        }
        Arrays.sort(sortArr);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.println(sortArr[i]);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int res = 0;

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        char[] arr = new char[n];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j < 0 || j >= n) continue;
                    if (arr[j] == 'H') {
                        arr[j] = 'x';
                        res++;
                        break;
                    }
                }
            }
        }
        System.out.println(res);

    }

}
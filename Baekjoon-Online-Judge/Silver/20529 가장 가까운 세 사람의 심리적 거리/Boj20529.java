import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            if (n > 32) {
                System.out.println(0);
                continue;
            }

            String[] arr = new String[n];
            for (int j = 0; j < n; j++) {
                arr[j] = st.nextToken();
            }
            int min = 987665423;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        int cnt = 0;
                        for (int m = 0; m < 4; m++) {
                            cnt += arr[j].charAt(m) != arr[k].charAt(m) ? 1 : 0;
                            cnt += arr[j].charAt(m) != arr[l].charAt(m) ? 1 : 0;
                            cnt += arr[k].charAt(m) != arr[l].charAt(m) ? 1 : 0;
                        }
                        min = Math.min(cnt, min);
                        if (min == 0) break;
                    }
                }
            }

            System.out.println(min);
        }

    }

}
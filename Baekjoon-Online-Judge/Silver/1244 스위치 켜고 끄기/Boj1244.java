import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = 0; j < n; j++) {
                    if ((j + 1) % number == 0) {
                        arr[j] = arr[j] == 0 ? 1 : 0;
                    }
                }
            } else {
                arr[number - 1] = arr[number - 1] == 0 ? 1 : 0;
                for (int j = 1; j < n / 2; j++) {
                    if (number - 1 + j >= n || number - 1 - j < 0)
                        break;
                    if (arr[number - 1 - j] == arr[number - 1 + j]) {
                        arr[number - 1 - j] = arr[number - 1 - j] == 0 ? 1 : 0;
                        arr[number - 1 + j] = arr[number - 1 + j] == 0 ? 1 : 0;
                    } else break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}
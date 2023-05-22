import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        change();
    }

    public static void change() {
        for (int i = 0; i < 4; i++) {
            int tmp = 0;
            if (arr[i] > arr[i + 1]) {
                tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                for (int j = 0; j < 5; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
        boolean check = false;
        for (int i = 0; i < 5; i++) {
            if (arr[i] != i + 1) {
                check = true;
            }
        }
        if (check) change();
    }
}
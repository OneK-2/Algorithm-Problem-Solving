import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (checkAsc()) {
            System.out.print("ascending");
        } else if (checkDes()) {
            System.out.print("descending");
        } else {
            System.out.print("mixed");
        }

    }

    public static boolean checkAsc() {
        for (int i = 1; i < 8; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDes() {
        for (int i = 0; i < 7; i++) {
            if (arr[i + 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
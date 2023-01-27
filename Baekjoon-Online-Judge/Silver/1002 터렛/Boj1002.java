import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(solution(x1, y1, r1, x2, y2, r2));
        }
    }

    //두개의 원이 같을 때, 외부, 외접, 내접, 내부
    public static int solution(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        //같은 원
        if (x2 == x1 && y1 == y2 && r1 == r2) {
            return -1;
        }
        //외부
        else if (distance > Math.pow(r2 + r1, 2)) {
            return 0;
        }
        //외접
        else if (distance == Math.pow(r2 + r1, 2)) {
            return 1;
        }
        //내접
        else if (distance == Math.pow(r2 - r1, 2)) {
            return 1;
        }
        //내부
        else if (distance < Math.pow(r2 - r1, 2)) {
            return 0;
        }
        else return 2;

    }
}
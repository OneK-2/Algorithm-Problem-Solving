import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //0< n,m <=50
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        //책 위치 -10000<= location <=10000, 0이 아님
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                plusQ.offer(num);
            } else {
                minusQ.offer(Math.abs(num));
            }
        }

        if (plusQ.isEmpty()) {
            max = minusQ.peek();
        } else if (minusQ.isEmpty()) {
            max = plusQ.peek();
        } else {
            max = Math.max(minusQ.peek(), plusQ.peek());
        }

        while (!plusQ.isEmpty()) {
            int tmp = plusQ.peek();
            for (int i = 0; i < m; i++) {
                plusQ.poll();
            }
            result += tmp * 2;
        }

        while (!minusQ.isEmpty()) {
            int tmp = minusQ.peek();
            for (int i = 0; i < m; i++) {
                minusQ.poll();
            }
            result += tmp * 2;
        }
        result -= max;

        System.out.println(result);
    }
}
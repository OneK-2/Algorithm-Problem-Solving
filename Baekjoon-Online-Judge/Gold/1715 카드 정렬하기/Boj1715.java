import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() >= 2) {
            int sum = pq.poll() + pq.poll();
            result += sum;
            pq.add(sum);
        }

        System.out.println(result);
    }
}
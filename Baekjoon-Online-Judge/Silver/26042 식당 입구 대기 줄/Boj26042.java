import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int maxNum = 0;
        int minStd = 100001;
        int prevMax = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int student = Integer.parseInt(st.nextToken());
                queue.add(student);

                prevMax = maxNum;

                if (maxNum <= queue.size()) {
                    maxNum = queue.size();
                    if (prevMax == maxNum) {
                        minStd = Math.min(minStd, student);
                    } else {
                        minStd = student;
                    }
                }

            } else if (type == 2) {
                queue.poll();
            }
        }
        sb.append(maxNum).append(" ").append(minStd);
        System.out.println(sb);
    }
}
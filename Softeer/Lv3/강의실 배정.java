import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Cla[] arr = new Cla[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            arr[i] = new Cla(s, f);
        }
        Arrays.sort(arr);
        int ans = 0;
        int curTime = 0;
        for (Cla c : arr) {
            if (c.s < curTime) {
                continue;
            } else {
                ans++;
                curTime = c.f;
            }
        }
        System.out.println(ans);
    }

    static class Cla implements Comparable<Cla> {
        int s, f;

        public Cla(int s, int f) {
            this.s = s;
            this.f = f;
        }

        public int compareTo(Cla o) {
            return this.f - o.f;
        }
    }

}

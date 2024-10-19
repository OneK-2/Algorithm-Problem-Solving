import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Time[] times = new Time[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 일처리시간
            int s = Integer.parseInt(st.nextToken()); // 끝나는 시간
            times[i] = new Time(t, s);
        }
        Arrays.sort(times);

        int result = times[0].S - times[0].T;
        for (int i = 1; i < n; i++) {
            if (times[i].S < result) {
                result = times[i].S;
            }
            result -= times[i].T;
        }
        if (result > 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}

class Time implements Comparable<Time> {
    int T;
    int S;

    public Time(int t, int s) {
        this.T = t;
        this.S = s;
    }

    @Override
    public int compareTo(Time o) {
        if (this.S == o.S) {
            return this.T - o.T;
        }
        return o.S - this.S;
    }
}

/**
 *
 */
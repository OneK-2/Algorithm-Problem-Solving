import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arrP = new int[1001];

        Answer[] ans = new Answer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ans[i] = new Answer(num, i);
        }
        Arrays.sort(ans);
        for (int i = 0; i < n; i++) {
            arrP[ans[i].idx] = i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arrP[i] + " ");
        }
    }
}

class Answer implements Comparable<Answer> {
    int num;
    int idx;

    public Answer(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Answer a) {
        return this.num - a.num;
    }
}

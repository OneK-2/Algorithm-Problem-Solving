import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static String str;
    public static int count0 = 0;// 전부 0으로 바꾸는 경우
    public static int count1 = 0;// 전부 1으로 바꾸는 경우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        if (str.charAt(0) == '1') {
            count0 += 1;
        } else {
            count1 += 1;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                //다음 수에서 1로 바뀜
                if (str.charAt(i + 1) == '1') count0 += 1;
                    //다음 수에서 0으로 바뀜
                else count1 += 1;
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        boolean check = false;

        int lenS = S.length();
        int lenT = T.length();
        for (int i = lenT - 1; i > 0; i--) {
            StringBuilder tmp = new StringBuilder();
            if (T.charAt(i) == 'A') {
                for (int j = 0; j < T.length() - 1; j++) {
                    tmp.append(T.charAt(j));
                }
                T = tmp.toString();
            } else {
                for (int j = 0; j < T.length() - 1; j++) {
                    tmp.append(T.charAt(j));
                }
                T = tmp.toString();
                T = new StringBuffer(T).reverse().toString();
            }

            if (S.equals(T)) {
                check = true;
                break;
            }
        }
        if (check) System.out.println(1);
        else System.out.println(0);
    }
}
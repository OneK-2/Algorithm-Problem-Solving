import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;

        String[] divide = br.readLine().split("-");
        for (int i = 0; i < divide.length; i++) {
            int temp = 0;
            String[] add = divide[i].split("\\+");
            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}

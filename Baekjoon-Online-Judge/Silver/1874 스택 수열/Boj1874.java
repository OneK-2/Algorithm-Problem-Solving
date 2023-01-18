import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int check = 0;

        while (n-- > 0) {
            int val = Integer.parseInt(br.readLine());

            if (val > check) {
                for (int i = check + 1; i <= val; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                check = val;
            } else if (stack.peek() != val) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
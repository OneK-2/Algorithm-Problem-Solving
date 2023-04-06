import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) isValid = false;

            if (isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}

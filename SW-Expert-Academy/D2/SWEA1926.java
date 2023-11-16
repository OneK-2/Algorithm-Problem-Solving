import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String strNum = String.valueOf(i);
            String tmp = "";
            for (int j = 0; j < strNum.length(); j++) {
                char c = strNum.charAt(j);
                if (c == '3')
                    tmp += "-";
                if (c == '6')
                    tmp += "-";
                if (c == '9')
                    tmp += "-";
            }
            if (!tmp.contains("-"))
                sb.append(strNum).append(" ");
            else sb.append(tmp).append(" ");
        }

        System.out.println(sb);
    }

}
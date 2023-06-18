import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //R L B T RT LT RB LB
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
        String king = st.nextToken();
        int kingX = king.charAt(0) - 'A' + 1;
        int kingY = king.charAt(1) - '0';

        String stone = st.nextToken();
        int stoneX = stone.charAt(0) - 'A' + 1;
        int stoneY = stone.charAt(1) - '0';

        int cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            int idx = 0;
            int curX = kingX, curY = kingY;
            switch (str) {
                case "R":
                    idx = 0;
                    break;
                case "L":
                    idx = 1;
                    break;
                case "B":
                    idx = 2;
                    break;
                case "T":
                    idx = 3;
                    break;
                case "RT":
                    idx = 4;
                    break;
                case "LT":
                    idx = 5;
                    break;
                case "RB":
                    idx = 6;
                    break;
                case "LB":
                    idx = 7;
                    break;
            }
            curX += dx[idx];
            curY += dy[idx];
            if (curX >= 1 && curX <= 8 && curY >= 1 && curY <= 8) {
                if (curX == stoneX && curY == stoneY) {
                    if (stoneX + dx[idx] >= 1 && stoneX + dx[idx] <= 8 && stoneY + dy[idx] >= 1 && stoneY + dy[idx] <= 8) {
                        stoneX += dx[idx];
                        stoneY += dy[idx];
                    } else continue;
                }
                kingX = curX;
                kingY = curY;
            }
        }
        king = "";
        stone = "";
        king += Character.toString((char) (kingX + 'A' - 1)) + kingY;
        stone += Character.toString((char) (stoneX + 'A' - 1)) + stoneY;
        System.out.println(king);
        System.out.println(stone);

    }
}

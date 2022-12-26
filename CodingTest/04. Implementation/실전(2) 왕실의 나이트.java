import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int row = str.charAt(1) - '0';
        int column = str.charAt(0) - 'a' + 1;

        int cnt = 0;
        //x 수평이동 y 수직이동
        int dx[] = {-2, -2, 2, 2, -1, 1, -1, 1};
        int dy[] = {-1, 1, -1, 1, -2, -2, 2, 2};

        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

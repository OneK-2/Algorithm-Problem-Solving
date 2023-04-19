import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int cross = 1;
        int crossSum = 0;
        while (true) {
            if (num <= cross + crossSum) {
                if (cross % 2 == 1) {
                    System.out.println((cross - (num - crossSum - 1)) + "/" + (num - crossSum));
                } else {
                    System.out.println((num - crossSum) + "/" + (cross - (num - crossSum - 1)));
                }
                break;
            } else {
                crossSum += cross;
                cross++;
            }
        }
    }
}

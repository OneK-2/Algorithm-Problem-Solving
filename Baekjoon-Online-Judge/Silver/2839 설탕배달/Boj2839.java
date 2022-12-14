package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        while (n >= 0) {
            if (n % 5 == 0) {
                sum += n / 5;
                System.out.println(sum);
                return;
            }
            n -= 3;
            sum++;
        }
        System.out.println(-1);
    }
}

//좀더 정갈해 보이는 코드
//
// 	while(true) {
// 			if(N%5 ==0) {
// 				System.out.println(N/5 + sum);
// 				break;
// 			}else if(N < 0) {
// 				System.out.println(-1);
// 				break;
// 			}
// 			N = N-3;
// 		    sum++;
// 		}

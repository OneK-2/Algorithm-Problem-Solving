
public class Solution {
    public int solution(int n) {
        int ans = 0;
        //k칸 앞으로 점프 -> 건전지 사용
        // 온거리 * 2 순간이동 -> 건전지 사용x
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}
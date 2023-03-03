class Solution {
    public static int cnt = 0;
    public static boolean[] isVisited;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        isVisited = new boolean[dungeons.length];
        play(dungeons, k, 0);
        return answer = cnt;
    }

    public static void play(int[][] dungeons, int k, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && dungeons[i][0] <= k) {
                isVisited[i] = true;
                play(dungeons, k - dungeons[i][1], depth + 1);
                isVisited[i] = false;
            }
        }
        cnt = Math.max(cnt, depth);
    }
}
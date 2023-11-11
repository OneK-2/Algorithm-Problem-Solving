class Solution {
    static boolean[] visited;
    static int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        return answer;
    }

    private static void dfs(String cur, String target, String[] words, int cnt) {
        if (cur.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            int num = 0;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) != words[i].charAt(j)) {
                    num++;
                }
            }
            if (num == 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
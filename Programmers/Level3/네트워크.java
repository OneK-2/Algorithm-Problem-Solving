class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                dfs(computers, i, isVisit);
                answer++;
            }
        }
        return answer;
    }

    public static boolean[] dfs(int[][] computers, int i, boolean[] isVisit) {
        isVisit[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && !isVisit[j]) {
                isVisit = dfs(computers, j, isVisit);
            }
        }
        return isVisit;
    }
}
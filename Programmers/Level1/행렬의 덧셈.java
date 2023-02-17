class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int lenC = arr1[0].length;
        int lenR = arr1.length;
        int[][] answer = new int[lenR][lenC];

        for (int i = 0; i < lenR; i++) {
            for (int j = 0; j < lenC; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}

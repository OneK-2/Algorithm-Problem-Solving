import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];

        for (int m = 0; m < len; m++) {
            int i = 0, j = 0, k = 0;
            for (int l = 0; l < 3; l++) {
                i = commands[m][0];
                j = commands[m][1];
                k = commands[m][2];
            }
            answer[m] = commandSort(array, i, j, k);
        }

        return answer;
    }

    public int commandSort(int[] arr, int i, int j, int k) {
        int[] tmp = new int[j - i + 1];
        int idx = 0;
        for (int m = i - 1; m < j; m++) {
            tmp[idx++] = arr[m];
        }
        Arrays.sort(tmp);
        return tmp[k - 1];
    }
}
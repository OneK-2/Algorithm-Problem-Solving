import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int row = board.length; //세로 길이
        int col = board[0].length; //가로 길이

        if (row < 2 || col < 2) return 1;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] != 0) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j - 1], board[i][j - 1]), board[i - 1][j]) + 1;
                    if (answer < board[i][j]) answer = board[i][j];
                }
            }
        }

        return answer * answer;
    }
}

/**
 * bfs로 구현했는데, 효율성 테스트 실패함
 * 조건문 좀 바꿔보고 하다가 검색해보니
 * set쓰라고 되어있어서 바꿈
 */
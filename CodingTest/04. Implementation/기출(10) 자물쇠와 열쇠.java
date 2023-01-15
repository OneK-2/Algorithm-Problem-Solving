public class solution {
    public static boolean solution(int[][] key, int[][] lock) {
        int n = key.length;
        int m = lock.length;

        //자물쇠 크기를 3배로 변환하여 중앙에 기존 자물쇠 넣기
        int[][] newLock = new int[m * 3][m * 3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                newLock[i + m][j + m] = lock[i][j];
            }
        }

        //4방향 확인
        for (int i = 0; i < 4; i++) {
            key = turnRight(key);
            for (int x = 0; x < m * 2; x++) {
                for (int y = 0; y < m * 2; y++) {
                    //자물쇠에 키 맞추기
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            newLock[x + j][y + k] += key[j][k];
                        }
                    }
                    if (check(newLock)) return true;
                    //아니면 다시 제거
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            newLock[x + j][y + k] -= key[j][k];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int[][] turnRight(int[][] key) {
        int n = key.length; //세로길이
        int m = key[0].length; //가로길이
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][n - i - 1] = key[i][j];
            }
        }
        return temp;
    }

    public static boolean check(int[][] newLock) {
        int len = newLock.length / 3;
        for (int i = len; i < len * 2; i++) {
            for (int j = len; j < len * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    //확인용
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        if (solution(key, lock)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

}

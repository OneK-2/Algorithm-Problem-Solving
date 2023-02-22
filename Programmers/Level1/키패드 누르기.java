import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int len = numbers.length;
        int leftLocation = 10;
        int rightLocation = 12;

        for (int i = 0; i < len; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                leftLocation = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                rightLocation = numbers[i];
            } else {
                int leftLen = Distance(leftLocation, numbers[i]);
                int rightLen = Distance(rightLocation, numbers[i]);
                if (leftLen > rightLen) {
                    answer.append("R");
                    rightLocation = numbers[i];
                } else if (leftLen < rightLen) {
                    answer.append("L");
                    leftLocation = numbers[i];
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftLocation = numbers[i];
                    } else {
                        answer.append("R");
                        rightLocation = numbers[i];
                    }
                }

            }

        }
        return answer.toString();
    }

    public int Distance(int location, int num) {
        if (location == 0) location = 11;
        if (num == 0) num = 11;
        int x = (location - 1) / 3;
        int y = (location - 1) % 3;
        int numX = num / 3;
        int numY = 1;

        return Math.abs(x - numX) + Math.abs(y - numY);
    }
}
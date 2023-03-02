import java.util.*;

class Solution {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static boolean[] isVisited = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length(); i++) {
            makeNum(numbers, "", i + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) answer++;
        }
        return answer;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void makeNum(String numbers, String tmp, int depth) {
        if (tmp.length() == depth) {
            int num = Integer.parseInt(tmp);
            if (!list.contains(num)) list.add(num);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                tmp += numbers.charAt(i);
                makeNum(numbers, tmp, depth);
                isVisited[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }
}
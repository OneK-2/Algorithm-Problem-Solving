import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<Set<Integer>> setList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            setList.add(new HashSet<>());
        }
        setList.get(1).add(N);
        if (N == number) return 1;

        for (int i = 2; i < 9; i++) {
            Set<Integer> set = setList.get(i);

            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for (int j = 1; j <= i; j++) {
                Set<Integer> set1 = setList.get(j);
                Set<Integer> set2 = setList.get(i - j);
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        set.add(num1 + num2);
                        set.add(num1 - num2);
                        set.add(num1 * num2);
                        if (num2 != 0) {
                            set.add(num1 / num2);
                        }
                    }
                }
            }
            if (set.contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
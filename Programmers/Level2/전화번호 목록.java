import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();

        for (String str : phone_book) {
            set.add(str);
        }

        for (String str : phone_book) {
            for (int i = 1; i < str.length(); i++) {
                if (set.contains(str.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            arr.add(strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = arr.get(i).substring(1);
        }

        return answer;
    }
}
//다른 풀이. 시간 더 짧음.
/*
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) > s2.charAt(n)) return 1;
                else if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if (s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        return strings;
    }
}*/

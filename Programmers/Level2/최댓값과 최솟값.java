import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (String str : arr) {
            arrayList.add(Integer.parseInt(str));
        }
        Collections.sort(arrayList);
        answer += arrayList.get(0);
        answer += " ";
        answer += arrayList.get(arrayList.size() - 1);
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> num = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                num.get(genres[i]).put(i, plays[i]);
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                HashMap<Integer, Integer> tmp = new HashMap<>();
                tmp.put(i, plays[i]);
                num.put(genres[i], tmp);
                map.put(genres[i], plays[i]);
            }
        }

        List<String> musics = new ArrayList<>(map.keySet());
        musics.sort((m1, m2) -> map.get(m2) - map.get(m1));

        for (String m : musics) {
            HashMap<Integer, Integer> tmp = num.get(m);
            List<Integer> tmpNum = new ArrayList<>(tmp.keySet());

            tmpNum.sort((t1, t2) -> tmp.get(t2) - tmp.get(t1));

            result.add(tmpNum.get(0));
            if (tmpNum.size() > 1) {
                result.add(tmpNum.get(1));
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
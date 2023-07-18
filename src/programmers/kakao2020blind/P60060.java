package programmers.kakao2020blind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P60060 {
    Map<Integer, List<String>> frontMap = new HashMap<>();
    Map<Integer, List<String>> backMap = new HashMap<>();
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for(String word: words) {
            String reversed = new StringBuilder(word).reverse().toString();
            frontMap.computeIfAbsent(word.length(), i -> new ArrayList<>()).add(reversed);
            backMap.computeIfAbsent(word.length(), i -> new ArrayList<>()).add(word);
        }

        for(Integer key: frontMap.keySet()){
            Collections.sort(frontMap.get(key));
            Collections.sort(backMap.get(key));
        }
        for(int i=0; i<queries.length; i++) {
            if(!frontMap.keySet().contains(queries[i].length())){
                answer[i] = 0;
                continue;
            }
            String key = queries[i];
            if(queries[i].charAt(0)=='?'){
                key = new StringBuilder(key).reverse().toString();
                List<String> list = frontMap.get(key.length());
                String start = key.replace("?", "a");
                String end = key.replace("?", "z");
                answer[i] = lowerBound(end, list) - lowerBound(start, list);
            } else {
                List<String> list = backMap.get(queries[i].length());
                String start = key.replace("?", "a");
                String end = key.replace("?", "z");
                answer[i] = lowerBound(end, list) - lowerBound(start, list);
            }
        }

        return answer;
    }

    public int lowerBound(String target, List<String> list) {
        int start = 0, end = list.size()-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(target.compareTo(list.get(mid)) <= 0) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

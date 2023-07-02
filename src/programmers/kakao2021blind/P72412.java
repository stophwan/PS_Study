package programmers.kakao2021blind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P72412 {
    Map<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        int[] answer = new int[query.length];
        for(String s: info) {
            String[] arr = s.split(" ");
            makeAllInfo(arr, 0, "");
        }

        for (String key : map.keySet())
            Collections.sort(map.get(key));

        for(int i=0; i<query.length; i++) {
            String q = query[i].replace(" and ", "");
            String[] arr = q.split(" ");
            String key = arr[0];
            int score = Integer.parseInt(arr[1]);
            if(map.get(key)!=null) {
                answer[i] = binarySearch(key, score);
            }
            else{
                answer[i] = 0;
            }
        }
        return answer;
    }

    private int binarySearch(String key, int score) {
        List<Integer> scoreList = map.get(key);
        int left = 0;
        int right = scoreList.size()-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(scoreList.get(mid) < score) {
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return scoreList.size() - left;
    }

    private void makeAllInfo(String[] arr, int cnt, String key) {
        if(cnt==4) {
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.valueOf(arr[4]));
            return;
        }
        makeAllInfo(arr, cnt+1, key + "-");
        makeAllInfo(arr, cnt+1, key + arr[cnt]);
    }
}

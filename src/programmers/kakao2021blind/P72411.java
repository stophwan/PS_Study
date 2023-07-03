package programmers.kakao2021blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P72411 {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for(int n: course) {
            map = new HashMap<>();
            for(String order: orders) {
                if(order.length() < n) {
                    continue;
                }
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                order = new String(chars);
                findCombi(order, "", 0, n);
            }
            int max = 0;
            for(int i: map.values()) {
                if(i>max) max = i;
            }
            if(max<2){
                continue;
            }
            for(String k: map.keySet()){
                if(map.get(k)==max){
                    list.add(k);
                }
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void findCombi(String order, String menu, int idx, int n) {
        if(menu.length()==n){
            map.put(menu, map.getOrDefault(menu, 0)+1);
            return;
        }
        for(int i=idx; i<order.length(); i++) {
            findCombi(order, menu+order.charAt(i), i+1, n);
        }
    }
}

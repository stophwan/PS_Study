package programmers.highscorekit.hash;

import java.util.HashMap;

public class P42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        for (String[] s : clothes){
            String type = s[1];
            hash.put(type, hash.getOrDefault(type,1)+1);
        }

        for (String key : hash.keySet()){
            answer *= hash.get(key);
        }
        return answer-1;
    }
}

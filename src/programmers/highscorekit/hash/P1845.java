package programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;

public class P1845 {
    public int solution(int[] nums) {
        Map<Integer, Integer> poketmons = new HashMap<>();
        for(int num : nums){
            poketmons.put(num, poketmons.getOrDefault(num,0)+1);
        }

        int answer = poketmons.keySet().size();

        if(answer > nums.length/2){
            answer = nums.length/2;
        }
        return answer;
    }
}

package programmers.devmatching;

import java.util.HashMap;
import java.util.Map;

public class P77486 {
    Map<String, String> map = new HashMap<>();
    Map<String, Integer> position = new HashMap<>();
    int[] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], referral[i]);
            position.put(enroll[i], i);
        }
        for(int i=0; i<seller.length; i++){
            int total = amount[i] * 100;
            cal(seller[i], total);
        }
        return answer;
    }

    public void cal(String now, int money){
        if(money==0){
            return;
        }
        if(now.equals("-")){
            return;
        }
        int giveMoney = (int)(money*0.1);
        int getMoney = money - giveMoney;
        answer[position.get(now)] += getMoney;
        cal(map.get(now), giveMoney);
    }
}

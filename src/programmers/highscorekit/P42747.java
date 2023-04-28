package programmers.highscorekit;

import java.util.Arrays;

// H-Index, 정렬, 프로그래머스 고득점 kit
public class P42747 {
    public int solution(int[] citations) {

        Arrays.sort(citations);
        int h = 0;
        int len = citations.length;
        for(int i = 0; i<len; i++) {
            h = Math.max(h,Math.min(len - i, citations[i]));
        }
        return h;
        /**
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);
        for(int i=0; i<len; i++) {
            if(citations[i]>=len-i){
                answer = len - i;
                break;
            }
        }
        return answer;
         **/
    }
}

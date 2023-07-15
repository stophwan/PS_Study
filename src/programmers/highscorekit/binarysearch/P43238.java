package programmers.highscorekit.binarysearch;

import java.util.Arrays;

// 이분탐색 , 입국심사
public class P43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1] * (long) n;
        while(left<=right) {
            long mid = (left + right)/2;
            long tmp = 0;
            for(int t : times){
                tmp +=  mid/t;
            }
            if(tmp < n){
                left = mid+1;
            }
            else{
                right = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
}

package programmers;

import java.util.Arrays;

// 징검다리
// 이분탐색
public class P43236 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        while(left<=right) {
            int mid = (left+right)/2;
            int removed = 0;
            int current = 0;
            for(int i=0; i< rocks.length; i++) {
                int diff = rocks[i] - current;
                if(mid <= diff){
                    current = rocks[i];
                }
                else{
                    removed++;
                }
            }
            if(distance - current < mid) removed++;
            if(removed <= n){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid - 1;
            }
        }
        return answer;
    }
}

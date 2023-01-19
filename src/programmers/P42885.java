package programmers;

import java.util.Arrays;


// 코딩 고득점 kit, 그리디, 구명보트, ***
public class P42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int tmp = limit;
        Arrays.sort(people);

        int min_idx = 0;
        int max_idx = people.length-1;
        while(min_idx<=max_idx) {
            if(people[min_idx] + people[max_idx] <= limit){
                min_idx++;
            }
            max_idx--;
            answer++;
        }
        return answer;
    }
}

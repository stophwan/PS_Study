package programmers.highscorekit.dfsbfs;

import java.util.Arrays;

public class P43165 {
    int answer = 0;
    int maximum;

    public int solution(int[] numbers, int target) {
        maximum = Arrays.stream(numbers).sum();
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int idx, int now) {
        if(idx == numbers.length){
            if(now == target){
                answer++;
            }
            return;
        }

        if(now - maximum > target || now + maximum <target){
            return;
        }

        dfs(numbers, target, idx+1, now + numbers[idx]);
        dfs(numbers, target, idx+1, now - numbers[idx]);

    }
}

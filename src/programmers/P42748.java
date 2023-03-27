package programmers;

import java.util.Arrays;

// 정렬, K번째 수, 프로그래머스 고득점 kit
public class P42748 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i=0; i<commands.length; i++) {
                int[] copyArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(copyArray);
                answer[i] = copyArray[commands[i][2]-1];
            }
            return answer;
        }

    }
}

package programmers;

import java.util.Arrays;
import java.util.Comparator;

// greedy 단속카메라
public class P42884 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int camera = 30001;
        for(int[] route : routes){
            int start = route[0];
            int end = route[1];
            if(start<=camera && camera<=end){
                continue;
            }
            camera = end;
            answer++;
        }

        return answer;
    }
}

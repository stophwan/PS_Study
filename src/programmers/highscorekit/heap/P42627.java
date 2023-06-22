package programmers.highscorekit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P42627 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int idx = 0;
        int end = 0;
        int count = 0;

        //Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while(count<jobs.length){

            while(idx < jobs.length && end >= jobs[idx][0]) {
                q.offer(jobs[idx++]);
            }

            if(q.size() == 0 && idx < jobs.length) {
                end = jobs[idx][0];
            }

            if(q.size() > 0){
                int[] out = q.poll();
                end += out[1];
                answer += (end - out[0]);
                count++;
            }
        }


        return answer/jobs.length;
    }
}

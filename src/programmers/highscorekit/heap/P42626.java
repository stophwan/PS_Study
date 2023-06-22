package programmers.highscorekit.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class P42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();
        for(int s : scoville){
            q.offer(s);
        }
        while(q.peek() < K && q.size()>=2){
            int first = q.poll();
            int second = q.poll();
            q.offer(first + second*2);
            answer++;
        }
        if(q.peek() < K){
            return -1;
        }
        return answer;
    }
}

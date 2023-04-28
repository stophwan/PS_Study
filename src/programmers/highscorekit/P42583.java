package programmers.highscorekit;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭, 스택/큐
public class P42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{truck_weights[0], 1+bridge_length});
        int tmp_w = truck_weights[0];
        int answer = 1;
        int idx = 1;
        while(!q.isEmpty()) {
            answer+=1;

            if(q.peek()[1] == answer){
                tmp_w -= q.poll()[0];
            }

            if(idx<truck_weights.length && tmp_w + truck_weights[idx] <= weight && q.size() < bridge_length) {
                tmp_w += truck_weights[idx];
                q.offer(new int[]{truck_weights[idx], answer+bridge_length});
                idx++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P42583 p42583 = new P42583();
        System.out.println(p42583.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}

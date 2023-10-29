package programmers.highscorekit.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭, 스택/큐
public class P42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        int currentIdx = 0;
        int currentWeight = 0;
        while(currentIdx < truck_weights.length) {
            if(q.size() == bridge_length) {
                currentWeight -= q.poll();
            }
            if(currentWeight + truck_weights[currentIdx] > weight) {
                q.offer(0);
            } else {
                q.offer(truck_weights[currentIdx]);
                currentWeight += truck_weights[currentIdx];
                currentIdx++;
            }
            time++;
        }
        return time + bridge_length;
    }

    public static void main(String[] args) {
        P42583 p42583 = new P42583();
        System.out.println(p42583.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}

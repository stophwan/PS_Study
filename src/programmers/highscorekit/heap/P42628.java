package programmers.highscorekit.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class P42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> q1 = new PriorityQueue<>();
        Queue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.charAt(0) == 'I') {
                q1.offer(Integer.valueOf(operation.substring(2)));
                q2.offer(Integer.valueOf(operation.substring(2)));
            }

            if (operation.equals("D -1") && q1.size() > 0) {
                int min = q1.poll();
                q2.remove(min);
            }

            if (operation.equals("D 1") && q2.size() > 0) {
                int max = q2.poll();
                q1.remove(max);
            }
        }

        if(q1.size() != 0) {
            answer[0] = q2.peek();
            answer[1] = q1.peek();
        }

        return answer;
    }
}

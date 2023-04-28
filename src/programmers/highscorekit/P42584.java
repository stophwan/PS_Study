package programmers.highscorekit;

import java.util.ArrayDeque;
import java.util.Deque;

// 스택/큐, 주식가격
public class P42584 {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<len-1; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.peek()] = len - 1 - stack.peek();
            stack.pop();
        }
        return answer;
    }
}

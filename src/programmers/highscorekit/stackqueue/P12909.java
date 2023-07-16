package programmers.highscorekit.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

// 스택/큐, 올바른 괄호
public class P12909 {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i< s.length(); i++) {
            if(s.charAt(i)=='(') {
                stack.push(1);
            }
            else{
                if(stack.peek()==null){
                    answer = false;
                    return answer;
                }
                if(stack.peek()==1){
                    stack.pop();
                }
            }
        }
        if(stack.size() != 0) {
            answer = false;
        }

        return answer;
    }
}

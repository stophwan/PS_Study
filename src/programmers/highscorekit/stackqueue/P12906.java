package programmers.highscorekit.stackqueue;

import java.util.Stack;

public class P12906 {
    public int[] solution(int [] arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty() || stack.peek() != arr[i]){
                stack.push(arr[i]);
            }

        }
        answer = new int[stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}

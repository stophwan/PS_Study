package programmers.highscorekit.bruteforce;

import java.util.ArrayList;
import java.util.List;

// 모의고사, 완전탐색, 프로그래머스 고득점 Kit
public class P42840 {
    public int[] solution(int[] answers) {
        int[] p = new int[3];
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<answers.length; i++) {
            p[0] = arr1[i%5]==answers[i] ? p[0]+1 : p[0];
            p[1] = arr2[i%8]==answers[i] ? p[1]+1 : p[1];
            p[2] = arr3[i%10]==answers[i] ? p[2]+1 : p[2];
        }
        int max = Math.max(p[0], Math.max(p[1],p[2]));
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(p[i] == max){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}

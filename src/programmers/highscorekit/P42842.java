package programmers.highscorekit;

// 카펫, 완전탐색 , *
public class P42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int s = (brown+4)/2;
        for(int i=3; i<s/2+1; i++) {
            if((i-2)*(s-i-2) == yellow){
                answer[0]=s-i;
                answer[1]=i;
            }
        }
        return answer;
    }
}

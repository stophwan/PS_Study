package programmers.devmatching;

public class P77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6,6,5,4,3,2,1};
        int cnt = 0;
        int zero = 0;
        for(int lotto: lottos) {
            if(lotto==0){
                zero++;
            }
            for(int win_num: win_nums) {
                if(lotto == win_num){
                    cnt++;
                }
            }
        }
        int[] answer = {rank[cnt+zero], rank[cnt]};
        return answer;
    }
}

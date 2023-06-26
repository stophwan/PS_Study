package programmers.highscorekit.greedy;


import java.util.Arrays;

// greedy 체육복
public class P42862 {

    static int[] clothes;
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        clothes = new int[n+1];
        for(int l: lost) {
            clothes[l]--;
        }
        for(int r: reserve) {
            clothes[r]++;
        }

        for(int i=1; i<n; i++) {
            if(clothes[i]==-1 && clothes[i+1]>0) {
                clothes[i]++;
                clothes[i+1]--;
            }
            if(clothes[i]>0 && clothes[i+1]==-1) {
                clothes[i+1]++;
                clothes[i]--;
            }
        }

        for(int i=1; i<=n; i++) {
            if(clothes[i]>-1){
                answer++;
            }
        }
        
        return answer;
    }
}

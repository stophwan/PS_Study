package programmers.kakao2022blind;


public class P92342 {
    int n;
    int[] info;
    int tmp = 0;
    int[] answer= {-1};
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        dfs(0, new int[11]);
        if(tmp==0) {
            return new int[]{-1};
        }
        return answer;
    }

    private void dfs(int cnt, int[] score) {
        if(cnt == n) {
            int diff = calculateDiff(score, info);
            if (diff >= tmp) {
                tmp = diff;
                answer = score.clone();
            }
            return;
        }

        for(int i=0; i<=10 && score[i]<=info[i]; i++) {
            score[i]++;
            dfs(cnt+1, score);
            score[i]--;
        }
    }

    private int calculateDiff(int[] score, int[] info) {
        int lion = 0;
        int apeach = 0;
        for(int i=0; i<=10; i++) {
            if(score[i] > info[i]) {
                lion += 10-i;
            } else {
                if(info[i] != 0) {
                    apeach += 10-i;
                }
            }
        }
        return lion - apeach;
    }
}

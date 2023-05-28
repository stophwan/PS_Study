package programmers.highscorekit;

// 네트워크, dfs, 프로그래머스 고득점 kit
public class P43162 {
    int[][] computers;
    int n;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.computers = computers;
        this.n = n;
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
        return answer;
    }

    public void dfs(int tmp){
        visited[tmp] = true;
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[tmp][i]==1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}

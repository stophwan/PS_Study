package programmers;

// 네트워크, dfs, 프로그래머스 고득점 kit
public class P43162 {
    int[][] computers;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]){
                answer++;
            }
            visited[i] = true;
            dfs(i, n);
        }
        return answer;
    }

    public void dfs(int now, int n){
        for(int i=0; i<n; i++) {
            if(computers[now][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, n);
            }
        }
    }
}

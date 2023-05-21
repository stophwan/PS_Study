package programmers.highscorekit.bruteforce;

public class P87946 {
    int res = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return res;
    }

    public void dfs(int idx, int k, int[][] dungeons) {
        for(int i=0; i<dungeons.length ; i++) {
            if(k>=dungeons[i][0] && !visited[i]){
                visited[i]=true;
                dfs(idx+1, k-dungeons[i][1], dungeons);
                visited[i]=false;
            }
        }
        res = Math.max(res, idx);
    }
}

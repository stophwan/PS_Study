package programmers.kakao2020blind;

public class P60061 {
    int[][] build_frame;
    int n;
    boolean[][][] graph;
    int cnt = 0;
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        this.build_frame = build_frame;
        graph = new boolean[2][n+1][n+1];
        for(int[] frame: build_frame) {
            int x = frame[0];
            int y = frame[1];
            if(frame[2]==0) {
                if(frame[3]==1) {
                    if(checkGi(x,y)){
                        graph[0][x][y] = true;
                        cnt++;
                    }
                }
                else{
                    if(canDelete(x,y,0)){
                        cnt--;
                    }
                }
            }
            else {
                if(frame[3]==1) {
                    if(checkBo(x,y)){
                        graph[1][x][y] = true;
                        cnt++;
                    }
                }
                else{
                    if(canDelete(x,y,1)){
                        cnt--;
                    }
                }
            }
        }

        int[][] answer = new int[cnt][3];
        int idx = 0;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(graph[0][i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 0;
                    idx++;
                }

                if(graph[1][i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 1;
                    idx++;
                }
            }
        }

        return answer;
    }

    public boolean checkGi(int x, int y) {
        if(y==0) return true;
        if(y>0 && graph[0][x][y-1]) return true;
        if((x>0 && graph[1][x-1][y]) || graph[1][x][y]) return true;
        return false;
    }

    public boolean checkBo(int x, int y) {
        if((y>0 && graph[0][x][y-1]) || (x<n && y>0 && graph[0][x+1][y-1])) return true;
        if((x>0 && graph[1][x-1][y]) && (x<n && graph[1][x+1][y])) return true;
        return false;
    }

    public boolean canDelete(int x, int y, int a) {
        graph[a][x][y] = false;
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                if(graph[0][i][j] && !checkGi(i,j)){
                    graph[a][x][y] = true;
                    return false;
                }
                if(graph[1][i][j] && !checkBo(i,j)){
                    graph[a][x][y] = true;
                    return false;
                }
            }
        }
        return true;
    }
}

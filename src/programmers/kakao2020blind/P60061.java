package programmers.kakao2020blind;

public class P60061 {
    boolean[][][] board;
    public int[][] solution(int n, int[][] build_frame) {
        board = new boolean[2][n+1][n+1];
        int cnt = 0;
        for(int[] arr: build_frame) {
            int x=arr[0], y=arr[1], a=arr[2], b=arr[3];
            if(b==0) {
                board[a][x][y] = false;
                if(checkDelete(n)) {
                    cnt--;
                    continue;
                }
                board[a][x][y] = true;
            } else {
                if(a==0 && checkGi(x,y,n)){
                    board[0][x][y] = true;
                    cnt++;
                }
                if(a==1 && checkBo(x,y,n)){
                    board[1][x][y] = true;
                    cnt++;
                }
            }
        }

        int[][] answer = new int[cnt][3];
        int idx = 0;
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                if(board[0][i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    idx++;
                }
                if(board[1][i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 1;
                    idx++;
                }
            }
        }

        return answer;
    }

    private boolean checkDelete(int n) {
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                if(board[0][i][j] && !checkGi(i,j,n)) {
                    return false;
                }
                if(board[1][i][j] && !checkBo(i,j,n)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBo(int x, int y, int n) {
        if((x>0 && board[1][x-1][y]) && (x<n && board[1][x+1][y])) {
            return true;
        }
        if((y>0 && board[0][x][y-1]) || (x<n && y>0 && board[0][x+1][y-1])) {
            return true;
        }
        return false;
    }

    private boolean checkGi(int x, int y, int n) {
        if(y==0) {
            return true;
        }
        if((x>0 && board[1][x-1][y]) || (x<=n && board[1][x][y])) {
            return true;
        }
        if(y>0 && board[0][x][y-1]) {
            return true;
        }
        return false;
    }
}

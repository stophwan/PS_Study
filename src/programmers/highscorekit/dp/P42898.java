package programmers.highscorekit.dp;

public class P42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = 1;
            }
        }

        for(int[] puddle: puddles) {
            board[puddle[0]][puddle[1]] = 0;
        }

        boolean check = false;
        for(int i=0; i<m; i++) {
            if(board[i][0] == 0) check=true;
            if(check){
                board[i][0] = 0;
            }
        }

        check = false;
        for(int i=0; i<n; i++) {
            if(board[0][i] == 0) check=true;
            if(check){
                board[0][i] = 0;
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(board[i][j]>0) {
                    board[i][j] = (board[i-1][j] + board[i][j-1])%1000000007;
                }
            }
        }
        return board[m-1][n-1];
    }
}

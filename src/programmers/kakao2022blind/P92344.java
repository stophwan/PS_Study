package programmers.kakao2022blind;

public class P92344 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] preSum = new int[row+1][col+1];
        for(int[] arr: skill) {
            int type = arr[0], r1 = arr[1], c1 = arr[2], r2 = arr[3], c2 = arr[4], degree = arr[5];
            if(type==1) {
                preSum[r1][c1] -= degree;
                preSum[r1][c2+1] += degree;
                preSum[r2+1][c1] += degree;
                preSum[r2+1][c2+1] -= degree;
            } else{
                preSum[r1][c1] += degree;
                preSum[r1][c2+1] -= degree;
                preSum[r2+1][c1] -= degree;
                preSum[r2+1][c2+1] += degree;
            }

        }

        for(int i=0; i<row; i++) {
            for(int j=1; j<col; j++) {
                preSum[i][j] += preSum[i][j-1];
            }
        }

        for(int i=1; i<row; i++) {
            for(int j=0; j<col; j++) {
                preSum[i][j] += preSum[i-1][j];
            }
        }


        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j] + preSum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

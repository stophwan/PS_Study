package basiccode;

import java.util.Arrays;

//2차원 배열 회전
public class Basic2 {
    static int n;

    public static int[][] rotateToRight(int[][] board) {
        int[][] rotated = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                rotated[i][j] = board[j][n-1-i];
            }
        }
        return rotated;
    }

    public static int[][] rotateToLeft(int[][] board) {
        int[][] rotated = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                rotated[i][j] = board[n-1-j][i];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        n = 3;
        int[][] board = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        System.out.println("rotated to right");
        int[][] rightRotated = rotateToRight(board);
        System.out.println(Arrays.deepToString(rightRotated));
        System.out.println("-------------------");

        System.out.println("rotated to left");
        int[][] leftRotated = rotateToLeft(board);
        System.out.println(Arrays.deepToString(leftRotated));
        System.out.println("-------------------");
    }
}

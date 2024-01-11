package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

public class B2580 {
	static int[][] board = new int[9][9];
	static List<int[]> zero = new ArrayList<>();
	static int zeroCnt = 0;
	static boolean finished = false;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j] == 0) {
					zero.add(new int[]{i,j});
					zeroCnt++;

				}
			}
		}

		dfs(0);
	}

	public static void dfs(int cnt) {
		if(cnt == zeroCnt) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
				finished = true;
			}
			return;
		}

		for(int i=1; i<=9; i++) {
			if(!check(zero.get(cnt)[0], zero.get(cnt)[1], i)) {
				continue;
			}
			board[zero.get(cnt)[0]][zero.get(cnt)[1]] = i;
			dfs(cnt+1);
			board[zero.get(cnt)[0]][zero.get(cnt)[1]] = 0;
			if(finished) {
				return;
			}
		}
	}

	public static boolean check(int x, int y, int value) {
		for(int i=0; i<9; i++) {
			if(board[x][i] == value) {
				return false;
			}
		}
		for(int i=0; i<9; i++) {
			if(board[i][y] == value) {
				return false;
			}
		}

		for(int i=(x/3)*3; i<(x/3)*3 + 3; i++) {
			for(int j=(y/3)*3; j<(y/3)*3 + 3; j++) {
				if(board[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}

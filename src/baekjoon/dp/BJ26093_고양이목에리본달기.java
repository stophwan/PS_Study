package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ26093_고양이목에리본달기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] board = new int[n+1][k];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<k; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		int[][] dp = new int[n+1][k];
		int first = 0;
		int second = 0;
		int firstIdx = -1;
		for(int i=1; i<=n; i++) {

			for(int j=0; j<k; j++) {
				if(firstIdx != j) {
					dp[i][j] = Math.max(first + board[i][j], dp[i][j]);
				} else {
					dp[i][j] = Math.max(second + board[i][j], dp[i][j]);
				}
			}

			for(int j=0; j<k; j++) {
				if(dp[i][j] > first) {
					second = first;
					first = dp[i][j];
					firstIdx = j;
				} else if(dp[i][j] > second) {
					second = dp[i][j];
				}
			}
		}

		int max = 0;
		for(int i=0; i<k; i++) {
			max = Math.max(dp[n][i], max);
		}
		System.out.println(max);
	}
}

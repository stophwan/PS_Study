package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B25682 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] board = new int[n+1][m+1];
		int[][] arr1 = new int[n+1][m+1];
		int[][] arr2 = new int[n+1][m+1];
		int[][] dp1 = new int[n+1][m+1];
		int[][] dp2 = new int[n+1][m+1];

		for(int i=1; i<=n; i++) {
			String[] s = br.readLine().split("");
			for(int j=1; j<=m; j++) {
				if(s[j-1].equals("B")) {
					board[i][j] = 1;
				} else {
					board[i][j] = 0;
				}
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if((i+j)%2 == 0) {
					arr1[i][j] = 1;
					arr2[i][j] = 0;
				} else {
					arr1[i][j] = 0;
					arr2[i][j] = 1;
				}
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(arr1[i][j] != board[i][j]) {
					dp1[i][j]++;
				}
				if(arr2[i][j] != board[i][j]) {
					dp2[i][j]++;
				}
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				dp1[i][j] += dp1[i][j-1] + dp1[i-1][j] - dp1[i-1][j-1];
				dp2[i][j] += dp2[i][j-1] + dp2[i-1][j] - dp2[i-1][j-1];
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i=1; i+k-1<=n; i++) {
			for(int j=1; j+k-1<=m; j++) {
				int a = dp1[i+k-1][j+k-1] - dp1[i+k-1][j-1] - dp1[i-1][j+k-1] + dp1[i-1][j-1];
				int b = dp2[i+k-1][j+k-1] - dp2[i+k-1][j-1] - dp2[i-1][j+k-1] + dp2[i-1][j-1];
				min = Math.min(a, min);
				min = Math.min(b, min);
			}
		}
		System.out.println(min);
 	}
}

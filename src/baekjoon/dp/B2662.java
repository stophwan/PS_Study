package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2662 {
	static int[] path;
	static int[][] invest;
	public static void getPath(int m, int n) {
		if(m == 0) {
			return;
		}
		path[m] = invest[m][n];
		getPath(m-1, n-path[m]);

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] benefit = new int[m+1][n+1];
		invest = new int[m+1][n+1];
		path = new int[m+1];

		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int money = Integer.parseInt(st.nextToken());
			for(int j=1; j<=m; j++) {
				benefit[j][money] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[m+1][n+1];

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				for(int k=0; k<=j; k++) {
					if(dp[i-1][j-k] + benefit[i][k] > dp[i][j]) {
						dp[i][j] = dp[i-1][j-k] + benefit[i][k];
						invest[i][j] = k;
					}
				}
			}
		}
		getPath(m, n);

		System.out.println(dp[m][n]);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=m; i++) {
			sb.append(path[i]).append(" ");
		}
		System.out.println(sb);
	}
}

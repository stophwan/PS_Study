package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1256_사전 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			dp[i][0] = 1;
		}
		for(int i = 1; i <= m; i++) {
			dp[0][i] = 1;
		}
		dp[0][0] = 0;

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				if(dp[i][j] > 1000000000) {
					dp[i][j] = 1000000000;
				}
			}
		}

		if(k > dp[n][m]) {
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		int acnt = n;
		int zcnt = m;

		for(int i = 1; i <= n+m; i++) {
			if(acnt == 0) {
				sb.append("z");
				continue;
			}
			if(zcnt == 0) {
				sb.append("a");
				continue;
			}
			if(k <= dp[acnt-1][zcnt]) {
				acnt--;
				sb.append("a");
			} else {
				k -= (int)dp[acnt-1][zcnt];
				zcnt--;
				sb.append("z");
			}
		}
		System.out.println(sb);
	}
}

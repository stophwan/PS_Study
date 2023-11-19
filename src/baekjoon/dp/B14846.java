package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14846 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][][] dp = new int[n+1][n+1][11];
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				int num = Integer.parseInt(st.nextToken());
				for(int k=1; k<=10; k++) {
					dp[i][j][k] = dp[i-1][j][k] + dp[i][j-1][k] - dp[i-1][j-1][k];
				}
				dp[i][j][num] ++;
			}
		}

		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for(int k=1; k<=10; k++) {
				if(dp[x2][y2][k] - dp[x2][y1-1][k] -dp[x1-1][y2][k] + dp[x1-1][y1-1][k]> 0) {
					cnt++;
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
}

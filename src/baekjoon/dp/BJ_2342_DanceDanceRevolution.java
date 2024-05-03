package baekjoon.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2342_DanceDanceRevolution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();

		int input;
		int len = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while((input = Integer.parseInt(st.nextToken())) != 0) {
			list.add(input);
			len++;
		}

		int[][][] dp = new int[len+1][5][5];
		for(int i=0; i<=len; i++) {
			for(int j=0; j<=4; j++) {
				for(int k=0; k<=4; k++) {
					dp[i][j][k] = len*3+1;
				}
			}
		}
		dp[0][0][0] = 0;
		for(int i=1; i<=len; i++) {
			int target = list.get(i-1);
			for(int j=0; j<=4; j++) {
				for(int k=0; k<=4; k++) {
					if(target != k) {
						dp[i][target][k] = Math.min(dp[i][target][k], dp[i-1][j][k] + calculate(j, target));
					}
					if(target != j) {
						dp[i][j][target] = Math.min(dp[i][j][target], dp[i-1][j][k] + calculate(k, target));
					}
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		int lastTarget = list.get(len-1);
		for(int i=0; i<5; i++) {
			ans = Math.min(dp[len][lastTarget][i], ans);
			ans = Math.min(dp[len][i][lastTarget], ans);
		}
		System.out.println(ans);
	}

	public static int calculate(int now, int target) {
		if(now == target) return 1;
		else if(now == 0) return 2;
		else if(Math.abs(now - target) == 2) return 4;
		else return 3;
	}
}

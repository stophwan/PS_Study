package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//틀림... 이분탐색이라는 것도 생각 못했고, 마지막 개수 구현에서도 한참 헤맸다.
//굳이 시작부터 부분합으로 할 필요가 없다.
public class BJ2613_숫자구슬 {
	static int max = 0;
	static int min = 0;
	static int[] dp;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] balls = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			balls[i] = Integer.parseInt(st.nextToken());
			max += balls[i];
			min = Math.max(balls[i], min);
		}
		dp = new int[n+1];
		for(int i = 1; i <= n; i++) {
			dp[i] = dp[i-1] + balls[i];
		}
		int res = binarySearch();
		StringBuilder sb = new StringBuilder();
		int s = 0;
		int tmp = 0;
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(dp[i] - dp[s] > res) {
				sb.append(i-1-s).append(" ");
				s = i-1;
				cnt++;
			}
			if(n-i+1 == m-cnt) {
				tmp = i - s;
				break;
			}
		}
		while(cnt < m) {
			sb.append(tmp).append(" ");
			cnt++;
			tmp = 1;
		}
		System.out.println(res);
		System.out.println(sb);
	}

	public static int binarySearch() {
		int left = min; int right = max;
		int mid;

		while(left <= right) {
			mid = (left + right) / 2;
			if(calculate(mid) <= m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static int calculate(int mid) {
		int s = 0;
		int group = 1;
		for(int i = 1; i <= n; i++) {
			if(dp[i] - dp[s] > mid) {
				group++;
				s = i-1;
			}
		}
		return group;
	}
}

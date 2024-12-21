package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://oculis.tistory.com/149
//어려운 문제.. 직접 시뮬레이션을 한번 해보면서 감을 찾아야한다.
public class BJ26156_나락도락이다 {
	static int div = (int)1e9 + 7;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();

		long r = 0;
		long o = 0;
		long c = 0;
		long k = 0;

		long[] dp = new long[n];
		dp[0] = 1;
		for (int i=1; i<n; i++) {
			dp[i] = (dp[i-1]*2)%div;
		}

		for(int i=0; i<n; i++) {
			if(s.charAt(i) == 'R') {
				r = (r + dp[i])%div;
			} else if(s.charAt(i) == 'O') {
				o = (o + r)%div;
			} else if(s.charAt(i) == 'C') {
				c = (c + o)%div;
			} else if(s.charAt(i) == 'K') {
				k = (k + c)%div;
			}
		}
		System.out.println(k);
	}
}

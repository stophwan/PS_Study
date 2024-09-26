package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//아이디어만 가져가면 되는 문제, 실제 문제는 BigInteger를 사용해야한다.
public class BJ27377_읽씹멈춰 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int c = 0; c < cases; c++){
			long n = Long.parseLong(br.readLine());
			st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long t = Long.parseLong(st.nextToken());
			System.out.println(solve(n, s, t));
		}
	}

	public static long solve(long n, long s, long t) {
		long now = n;
		long time = 0;
		while(now > 0) {
			if(now%2 == 1) {
				now --;
				time += s;
			} else {
				now /= 2;
				time += Math.min(now*s, t);
			}
		}
		return time;
	}
}

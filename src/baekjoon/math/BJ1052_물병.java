package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1052_물병 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int answer;
		int now = n;
		while(true) {
			int cnt = 0;
			int tmp = now;
			while(tmp > 0) {
				if(tmp%2==1) {
					cnt++;
				}
				tmp/=2;
			}
			if(cnt <= k) {
				answer = now - n;
				break;
			}
			now++;
		}
		System.out.println(answer);
	}

	public static boolean calculate(int n, int k) {
		while(n > k) {
			if(n%2==1) return false;
			n /= 2;
		}
		return n % 2 == 0;
	}

}

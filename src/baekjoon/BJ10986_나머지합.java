package baekjoon;

import java.util.*;
import java.io.*;

public class BJ10986_나머지합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long result = 0;
		long[] arr = new long[n + 1];
		long[] cnt = new long[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % m;
			// 0~i까지의 합을 M으로 나눈 나머지가 0인 경우의 수 카운팅
			if(arr[i] == 0) {
				result++;
			}
			// 나머지가 같은 인덱스의 수 카운팅
			cnt[(int) arr[i]]++;
		}

		//S[j] % M == S[i-1] % M 을 만족하는 (i,j)의 수를 결과값에 더한다.
		for(int i=0; i<m; i++) {
			if(cnt[i] > 1) {
				result += (cnt[i]* (cnt[i]-1) / 2); //cnt[i]C2 이다.
			}
		}
		System.out.println(result);
	}
}

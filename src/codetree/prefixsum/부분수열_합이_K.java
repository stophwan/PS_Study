package codetree.prefixsum;

import java.io.*;
import java.util.*;

public class 부분수열_합이_K {
	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] prefix = new int[n+1];
		for(int i=0; i<n; i++) {
			prefix[i+1] = prefix[i] + arr[i];
		}

		int cnt = 0;

		for(int i=1; i<=n; i++) {
			for(int j=0; j<i; j++) {
				if(prefix[i] - prefix[j] == k) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}

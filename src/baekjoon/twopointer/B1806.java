package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {

	public static int subSum(int n, int m, int[] arr) {
		int l1 = 0, l2 = 0;
		int min = Integer.MAX_VALUE;
		while(l1 <= l2 && l2 <= n) {
			if(arr[l2] - arr[l1] < m) {
				l2++;
			} else {
				min = Math.min(min, l2 - l1);
				l1++;
			}
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			arr[i] += arr[i-1];
		}
		int ans = subSum(n, m, arr);
		if(ans == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(ans);
	}
}

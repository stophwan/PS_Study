package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {

	public static int subSum(int n, int m, int[] arr) {
		int l1 = 0;
		int l2 = 1;
		int min = n+1;
		while(l1 <= n && l2 <= n) {
			int tmp = arr[l2] - arr[l1];
			if(tmp < m) {
				l2++;
			} else {
				min = Math.min(min, l2 - l1);
				l1++;
			}
		}
		if(min==n+1) {
			return 0;
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
		System.out.println(ans);
	}
}

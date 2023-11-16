package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {

	static int cnt = 0;

	public static void dfs(int idx, int n, int target, int sum, int[] arr) {
		if(idx==n) {
			if(target == sum) {
				cnt++;
			}
			return;
		}

		dfs(idx + 1, n, target, sum + arr[idx], arr);
		dfs(idx + 1, n, target, sum, arr);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, n, m, 0, arr);
		if(m==0) {
			cnt--;
		}
		System.out.println(cnt);
	}
}

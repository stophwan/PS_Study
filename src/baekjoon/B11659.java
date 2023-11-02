package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659 {

	public static int calculate(int[] arr, int start, int end) {
		return arr[end] - arr[start-1];
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
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(calculate(arr, start, end)).append('\n');
		}
		System.out.println(sb);
	}
}

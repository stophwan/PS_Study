package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
			int[] arr = new int[n];
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int[] max = arr.clone();
			for(int k=n-2; k>=0; k--) {
				max[k] = Math.max(arr[k], max[k+1]);
			}
			long sum = 0;
			for(int k=0; k<n; k++) {
				sum += max[k] - arr[k];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}

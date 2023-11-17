package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dist = new int[n-1];
		int[] cost = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		long sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n-1; i++) {
			min = Math.min(cost[i], min);
			sum += (long) min * dist[i];
		}
		System.out.println(sum);
	}
}

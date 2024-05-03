package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ16562_친구비 {

	static boolean[] visited;
	static int[] money;
	static List<Integer>[] graph;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		visited = new boolean[n+1];
		money = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		int sum = 0;
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				dfs(i);
				sum+=min;
				min = Integer.MAX_VALUE;
			}
		}

		if(sum <= k) {
			System.out.println(sum);
		} else {
			System.out.println("Oh no");
		}
	}

	public static void dfs(int n) {
		if(visited[n]) return;
		visited[n] = true;
		min = Math.min(min, money[n]);
		for(int friend: graph[n]) {
			dfs(friend);
		}
	}
}

package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15270 {
	static int n;
	static int m;
	static int[][] friends;
	static boolean[] visited;
	static int maxConnections = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		friends = new int[m][2];
		visited = new boolean[n+1];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[i][0] = a;
			friends[i][1] = b;
		}
		dfs(0, 0);
		int res = 0;
		if(maxConnections*2 < n) {
			res += 1;
		}
		maxConnections *= 2;
		res += maxConnections;
		System.out.println(res);
	}

	public static void dfs(int idx, int cnt) {
		if(idx == m) {
			maxConnections = Math.max(maxConnections, cnt);
			return;
		}

		if(visited[friends[idx][0]] || visited[friends[idx][1]]) {
			dfs(idx+1, cnt);
			return;
		}
		visited[friends[idx][0]] = true;
		visited[friends[idx][1]] = true;
		dfs(idx+1, cnt+1);
		visited[friends[idx][0]] = false;
		visited[friends[idx][1]] = false;
		dfs(idx+1, cnt);
	}
}

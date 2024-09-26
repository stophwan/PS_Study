package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//큰 고민없이 맞은 문제
public class B1976_여행가자 {
	static int[][] graph;
	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] plan = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		boolean res = true;

		for(int i = 1; i < m; i++) {
			int start = plan[i-1]-1;
			int end = plan[i]-1;
			//System.out.println(start + " " + end);
			if(!bfs(start, end)) {
				res = false;
				break;
			}
		}
		System.out.println(res ? "YES" : "NO");
	}

	static public boolean bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.add(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			//System.out.println(cur);
			if(cur == end) return true;
			visited[cur] = true;
			for(int i=0; i<n; i++) {
				if(graph[cur][i] == 1 && !visited[i]){
					q.add(i);
				}
			}
		}
		return false;
	}
}

package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5214_환승 {

	static int n, k, m;
	static List<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n+m+1];

		for(int i=1; i<=n+m; i++) {
			graph[i] = new ArrayList<>();
		}

		for(int i=1; i<=m; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<k; j++){
				int tmp = Integer.parseInt(st.nextToken());
				graph[n+i].add(tmp);
				graph[tmp].add(n+i);
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n+m+1];
		q.add(new int[]{1, 1});
		visited[1] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int t = tmp[1];
			if(x == n) {
				return t;
			}

			for(int nx: graph[x]) {
				if (!visited[nx]) {
					visited[nx] = true;
					if(nx <= n) q.add(new int[]{nx, t+1});
					if(nx > n) q.add(new int[]{nx, t});
				}
			}
		}
		return -1;
	}
}

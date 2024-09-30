package baekjoon.dijkstrea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ10282_해킹 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for(int t=0; t<test; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			List<Edge>[] graph = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				graph[b].add(new Edge(a,s));
			}
			Queue<Edge> pq = new PriorityQueue<>((Comparator.comparingInt(e -> e.w)));
			pq.add(new Edge(c, 0));
			int[] dist = new int[n+1];
			boolean[] visited = new boolean[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[c] = 0;
			while(!pq.isEmpty()) {
				Edge e = pq.poll();
				if(visited[e.v]) continue;
				visited[e.v] = true;
				for(Edge next: graph[e.v]) {
					if(dist[e.v] + next.w < dist[next.v]) {
						dist[next.v] = dist[e.v] + next.w;
						pq.add(new Edge(next.v, dist[next.v]));
					}
				}
			}
			int cnt = 0;
			int max = 0;
			for(int i=1; i<=n; i++) {
				if(dist[i] != Integer.MAX_VALUE){
					cnt++;
					max = Math.max(max, dist[i]);
				}
			}
			System.out.println(cnt + " " + max);
		}
	}

	static class Edge {
		int v;
		int w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}

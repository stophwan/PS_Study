package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ4386_별자리 {
	static double[][] stars;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stars = new double[n][2];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}

		parents = new int[n];
		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}

		List<Edge> edges = new ArrayList<>();

		for(int i = 0; i < n-1; i++) {
			for(int j = i + 1; j < n; j++) {
				edges.add(new Edge(i, j, calculate(i, j)));
			}
		}

		Collections.sort(edges, (o1, o2) -> {
			if(o1.weight - o2.weight > 0) return 1;
			return -1;
		});

		double sum = 0;
		for(Edge e : edges) {
			if(find(e.start) != find(e.end)) {
				union(e.start, e.end);
				sum += e.weight;
			}
		}
		System.out.println(Math.round(sum * 100) / 100.0);
	}

	public static int find(int node) {
		if(parents[node] == node) return node;
		return parents[node] = find(parents[node]);
	}

	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA <= rootB) {
			parents[rootB] = rootA;
		} else {
			parents[rootA] = rootB;
		}
	}

	public static double calculate(int a, int b) {
		return Math.sqrt(
			Math.pow(Math.abs(stars[a][0] - stars[b][0]),2)
			+ Math.pow(Math.abs(stars[a][1] - stars[b][1]), 2)
		);
	}

	static class Edge {
		int start;
		int end;
		double weight;

		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
}

package programmers.kakao2022tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P118669 {
	List<List<Node>> graph;
	boolean[] gateCheck;
	boolean[] summitCheck;
	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		graph = new ArrayList<>();
		gateCheck = new boolean[n+1];
		summitCheck = new boolean[n+1];
		for(int gate: gates) {
			gateCheck[gate] = true;
		}
		for(int summit: summits) {
			summitCheck[summit] = true;
		}
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		for(int[] path: paths) {
			int start = path[0], end = path[1], weight = path[2];
			if(gateCheck[start] || summitCheck[end] ) {
				graph.get(start).add(new Node(end, weight));
			} else if(summitCheck[start] || gateCheck[end]) {
				graph.get(end).add(new Node(start, weight));
			} else {
				graph.get(start).add(new Node(end, weight));
				graph.get(end).add(new Node(start, weight));
			}
		}
		int[] intensity = bfs(n, gates);
		int min = Integer.MAX_VALUE;
		int mount = Integer.MAX_VALUE;
		Arrays.sort(summits);
		for(int summit: summits) {
			if(intensity[summit] < min) {
				min = intensity[summit];
				mount = summit;
			}
		}
		return new int[]{mount, min};
	}

	public int[] bfs(int n, int[] gates) {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
		int[] intensity = new int[n+1];
		Arrays.fill(intensity, Integer.MAX_VALUE);
		for(int gate: gates) {
			intensity[gate] = 0;
			pq.add(new Node(gate, 0));
		}
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int from = tmp.to;
			if(tmp.weight > intensity[from]) {
				continue;
			}
			for(Node node: graph.get(from)){
				if(intensity[node.to] > Math.max(node.weight, intensity[from])){
					intensity[node.to] = Math.max(node.weight, intensity[from]);
					pq.add(new Node(node.to, node.weight));
				}
			}
		}
		return intensity;
	}

	static class Node {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] paths = new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
		int[] gates = new int[]{1, 3};
		int[] summits = new int[]{5};
		System.out.println(Arrays.toString(new P118669().solution(n, paths, gates, summits)));
	}
}

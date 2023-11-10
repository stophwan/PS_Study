package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1753 {

	public static int[] calculatePath(int v, int start, List<List<Node>> board) {
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
		pq.add(new Node(start, 0));
		int[] dist = new int[v+1];
		boolean[] visited = new boolean[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int s = node.end;
			if(visited[s]) {
				continue;
			}
			visited[s] = true;
			List<Node> list = board.get(s);
			for(Node n : list) {
				if(n.weight + dist[s] < dist[n.end]) {
					dist[n.end] = n.weight + dist[s];
					pq.add(new Node(n.end, dist[n.end]));
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		List<List<Node>> board = new ArrayList<>();
		for(int i=0; i<=v; i++) {
			board.add(new ArrayList<>());
		}

		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			board.get(a).add(new Node(b, w));
		}
		int[] dists = calculatePath(v, k, board);
		for(int i=1; i<=v; i++) {
			if(dists[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dists[i]);
		}
	}

	static class Node {
		int end;
		int weight;
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}

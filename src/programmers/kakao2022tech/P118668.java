package programmers.kakao2022tech;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P118668 {
	int max_alp = 0;
	int max_cop = 0;
	boolean[][] visited;
	public int solution(int alp, int cop, int[][] problems) {

		for(int[] problem: problems) {
			max_alp = Math.max(max_alp, problem[0]);
			max_cop = Math.max(max_cop, problem[1]);
		}
		visited = new boolean[max_alp+1][max_cop+1];
		return bfs(alp, cop, problems);
	}

	public int bfs(int alp, int cop, int[][] problems) {
		Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
		q.add(new Node(alp, cop, 0));

		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp.alp>= max_alp && tmp.cop >= max_cop) {
				return tmp.time;
			}
			if(tmp.alp >= max_alp) {
				tmp.alp = max_alp;
			}
			if(tmp.cop >= max_cop) {
				tmp.cop = max_cop;
			}
			if(visited[tmp.alp][tmp.cop]) {
				continue;
			}
			visited[tmp.alp][tmp.cop] = true;
			q.offer(new Node(tmp.alp+1, tmp.cop, tmp.time+1));
			q.offer(new Node(tmp.alp, tmp.cop+1, tmp.time+1));
			for(int[] problem: problems) {
				if(tmp.alp >= problem[0] && tmp.cop >= problem[1]) {
					q.offer(new Node(tmp.alp+problem[2], tmp.cop+problem[3], tmp.time+problem[4]));
				}
			}
		}
		return 0;

	}

	static class Node {
		int alp;
		int cop;
		int time;

		Node(int alp, int cop, int time) {
			this.alp = alp;
			this.cop = cop;
			this.time = time;
		}
	}
}

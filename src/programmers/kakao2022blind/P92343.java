package programmers.kakao2022blind;

import java.util.ArrayList;
import java.util.List;

public class P92343 {
	int[] info;
	int[][] graph;
	int len;
	int answer = 0;
	boolean[][][] visited;
	public int solution(int[] info, int[][] edges) {
		len = info.length;
		this.info = info;
		graph = new int[len][len];
		visited = new boolean[len][len+1][len+1];

		for(int[] edge: edges) {
			graph[edge[0]][edge[1]] = 1;
			graph[edge[1]][edge[0]] = 1;
		}

		dfs(0, 0, 0);

		return answer;
	}

	public void dfs(int now, int sheep, int wolf) {
		System.out.println("now: " + now + " sheep: " + sheep + " wolf: " + wolf);
		if(info[now]==0) {
			sheep++;
		}
		else if(info[now]==1) {
			wolf++;
		}

		if(sheep <= wolf) return;

		answer = Math.max(sheep, answer);

		for(int i=0; i<len; i++) {
			if(graph[now][i]==1 && !visited[i][sheep][wolf]) {
				int tmp = info[now];
				info[now] = -1;
				visited[now][sheep][wolf] = true;
				dfs(i, sheep, wolf);
				visited[now][sheep][wolf] = false;
				info[now] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] info = new int[]{0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = new int[][] {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
		System.out.println(new P92343().solution(info, edges));
	}
}

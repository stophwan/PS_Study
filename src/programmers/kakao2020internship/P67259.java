package programmers.kakao2020internship;

import java.util.LinkedList;
import java.util.Queue;

public class P67259 {
	int[] dx = new int[]{-1, 1, 0, 0};
	int[] dy = new int[]{0, 0, -1, 1};
	int len;
	int[][] board;
	public int solution(int[][] board) {
		len = board.length;
		this.board = board;
		return Math.min(bfs(1), bfs(3));
	}

	private int bfs(int s) {
		int[][] visited = new int[len][len];
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(board[i][j] == 1) {
					visited[i][j] = -1;
				}
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,s,0));
		visited[0][0] = -1;
		while(!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
			int d = node.d;
			int cost = node.cost;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(checkRange(nx, ny) && visited[nx][ny] >= 0) {
					int sum = cost+100;
					if(d != i) {
						sum += 500;
					}
					if(visited[nx][ny]==0 || visited[nx][ny] > sum) {
						visited[nx][ny] = sum;
						q.add(new Node(nx, ny, i, sum));
					}
				}
			}
		}
		return visited[len-1][len-1];
	}

	private boolean checkRange(int x, int y) {
		return x>=0 && x<len && y>=0 && y<len;
	}

	static class Node {
		int x;
		int y;
		int d;
		int cost;
		Node(int x, int y, int d, int cost) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cost = cost;
		}
	}
}

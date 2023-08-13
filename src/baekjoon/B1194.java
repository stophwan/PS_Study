package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194 {
	char[][] graph;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	boolean[][][] visited;

	private int bfs(int sx, int sy, int row, int col) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, 0, 0));
		visited[sx][sy][0] = true;
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(graph[now.x][now.y] == '1') {
				return now.cnt;
			}
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(!checkRange(nx, ny, row, col) || visited[nx][ny][now.key]) {
					continue;
				}
				if(graph[nx][ny] == '#') {
					continue;
				}
				if(graph[nx][ny] >= 'a' && graph[nx][ny] <= 'f') {
					int nextKey = now.key | 1 << (graph[nx][ny] - 'a');
					visited[nx][ny][nextKey] = true;
					q.add(new Node(nx, ny, nextKey, now.cnt+1));
					continue;
				}
				if(graph[nx][ny] >= 'A' && graph[nx][ny] <= 'F') {
					if((now.key & 1 << (graph[nx][ny] - 'A')) == (int)Math.pow(2, graph[nx][ny] - 'A')) {
						visited[nx][ny][now.key] = true;
						q.add(new Node(nx, ny, now.key, now.cnt+1));
						continue;
					}
				}
				if(graph[nx][ny]=='0' || graph[nx][ny]=='.' || graph[nx][ny]=='1') {
					visited[nx][ny][now.key] = true;
					q.add(new Node(nx, ny, now.key, now.cnt+1));
				}
			}
		}
		return -1;
	}

	private boolean checkRange(int x, int y, int row, int col) {
		if(x<0 || x>=row || y<0 || y>=col) {
			return false;
		}
		return true;
	}

	private int solution(int row, int col, char[][] graph) {
		this.graph = graph;
		this.visited = new boolean[row][col][64];
		int x=0, y=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(graph[i][j] == '0') {
					x = i;
					y = j;
				}
			}
		}
		return bfs(x, y, row, col);
	}

	static class Node {
		int x;
		int y;
		int key;
		int cnt;

		public Node(int x, int y, int key, int cnt) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] graph = new char[row][col];
		for(int i=0; i<row; i++) {
			String[] arr = br.readLine().split("");
			for(int j=0; j<col; j++) {
				graph[i][j] = arr[j].charAt(0);
			}
		}
		System.out.println(new B1194().solution(row, col, graph));
	}
}

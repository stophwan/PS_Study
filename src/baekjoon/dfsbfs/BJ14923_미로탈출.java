package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 초과
//접근 방식이 미묘하게 틀렸다.
public class BJ14923_미로탈출 {

	static int[] dx = new int[] {-1, 1, 0, 0};
	static int[] dy = new int[] {0, 0, -1, 1};
	static int n, m;
	static int hx, hy;
	static int ex, ey;
	static int[][] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		hx = Integer.parseInt(st.nextToken()) - 1;
		hy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		boolean[][][] visited = new boolean[n][m][2];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{hx, hy, 1, 0});
		visited[hx][hy][1] = true;
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			int x = cur[0], y = cur[1];
			int wall = cur[2], cnt = cur[3];

			if(x == ex && y == ey) {
				return cnt;
			}

			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(checkRange(nx, ny)) {
					if(graph[nx][ny] == 0 && !visited[nx][ny][wall]) {
						q.add(new int[]{nx, ny, wall, cnt+1});
						visited[nx][ny][wall] = true;
					} else if(graph[nx][ny] == 1 && wall == 1 && !visited[nx][ny][1]) {
						q.add(new int[]{nx, ny, 0, cnt+1});
						visited[nx][ny][0] = true;
					}
				}
			}
		}
		return -1;
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}

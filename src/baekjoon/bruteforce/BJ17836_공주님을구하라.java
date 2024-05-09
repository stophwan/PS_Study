package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17836_공주님을구하라 {
	static int n,m,t;
	static int[][] board;
	static int[] dx = new int[]{-1,1,0,0};
	static int[] dy = new int[]{0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		int[] sword = new int[2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					sword = new int[]{i,j};
				}
			}
		}

		int minTime = Integer.MAX_VALUE;
		int time = bfs(0,0, sword[0], sword[1]);
		if(time != -1) minTime = Math.min(minTime, time + n + m - sword[0] - sword[1] - 2);
		time = bfs(0,0,n-1,m-1);
		if(time != -1) minTime = Math.min(minTime, time);
		if(minTime > t) {
			System.out.println("Fail");
		} else {
			System.out.println(minTime);
		}
	}

	public static int bfs(int sx, int sy, int ex, int ey) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{sx, sy});
		boolean[][] visited = new boolean[n][m];
		visited[sx][sy] = true;

		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				int[] tmp = q.remove();
				if(tmp[0] == ex && tmp[1] == ey) {
					return time;
				}

				int nx, ny;
				for(int j=0; j<4; j++) {
					nx = tmp[0] + dx[j];
					ny = tmp[1] + dy[j];
					if(checkRange(nx, ny) && board[nx][ny] != 1 && !visited[nx][ny]) {
						q.add(new int[]{nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
			time++;
			if(time > t) {
				return -1;
			}
		}
		return -1;
	}

	public static boolean checkRange(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
}

package codetree.samsung;

import java.io.*;
import java.util.*;
public class 마법의_숲_탐색 {
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};
	static int r,c,k;
	static int[][] board;
	static int color = 1;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[r+3][c];
		int cnt = 0;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			down(1, start, d);
			color++;
		}

		System.out.println(ans);
	}

	static void down(int nx, int ny, int d) {
		if(check(nx+2, ny) && check(nx+1, ny-1) && check(nx+1, ny+1)) {
			down(nx+1, ny, d);
		} else if(check(nx-1, ny-1) && check(nx, ny-2) && check(nx+1, ny-1) && check(nx+1, ny-2) && check(nx+2, ny-1)) {
			down(nx+1, ny-1, (d+3)%4);
		} else if(check(nx-1, ny+1) && check(nx, ny+2) && check(nx+1, ny+1) && check(nx+1, ny+2) && check(nx+2, ny+1)) {
			down(nx+1, ny+1, (d+1)%4);
		} else {
			if(nx < 4) {
				clear();
			} else {
				paint(nx ,ny, d);
				ans += move(nx, ny);
			}
		}
	}

	static int move(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		int max = sx;
		q.add(new int[]{sx, sy});
		boolean[][] visited = new boolean[r+3][c];
		while(!q.isEmpty()) {
			int[] tmp = q.remove();
			int x = tmp[0];
			int y = tmp[1];
			if(visited[x][y]) continue;
			visited[x][y] = true;
			max = Math.max(x, max);
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(checkRange(nx, ny)) {
					if(Math.abs(board[nx][ny]) == board[x][y]) q.add(new int[]{nx, ny});
					if(board[x][y] < 0 && board[nx][ny] != 0) q.add(new int[]{nx, ny}); //출구일경우
				}
			}
		}
		return max-2;
	}

	static void paint(int x, int y, int d) {
		board[x][y] = color;
		board[x-1][y] = color;
		board[x+1][y] = color;
		board[x][y+1] = color;
		board[x][y-1] = color;
		board[x + dx[d]][y + dy[d]] = -color;
	}

	static void clear() {
		board = new int[r+3][c];
	}

	static boolean check(int x, int y) {
		return x>=0 && x<=r+2 && y>=0 && y<c && board[x][y] == 0;
	}

	static boolean checkRange(int x, int y) {
		return x>=3 && x<=r+2 && y>=0 && y<c;
	}
}

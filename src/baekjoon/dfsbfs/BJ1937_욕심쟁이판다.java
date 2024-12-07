package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//생각을 못했다.. bfs+dp는 알았어도 dfs+dp 문제라니...! 여러번 다시 풀어보자.
public class BJ1937_욕심쟁이판다 {

	static int n;
	static int[][] dp;
	static int[][] board;
	static int[] dx = new int[]{-1,1,0,0};
	static int[] dy = new int[]{0,0,-1,1};
	static int max = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}
		System.out.println(max);
	}

	public static int dfs(int x, int y) {
		if(dp[x][y] > 0) return dp[x][y];
		dp[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(checkRange(nx, ny) && board[nx][ny] > board[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			}
		}
		return dp[x][y];
	}

	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}

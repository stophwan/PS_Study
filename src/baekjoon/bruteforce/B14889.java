package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {
	static int n;
	static int[][] board;
	static boolean[] visited;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		visited = new boolean[n];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(res);
	}

	public static void dfs(int idx, int cnt) {
		if(cnt == n/2) {
			res = Math.min(res, calculate());
			return;
		}

		for(int i=idx; i<n; i++) {
			visited[i] = true;
			dfs(i+1, cnt+1);
			visited[i] = false;
		}
	}

	public static int calculate() {
		int start = 0;
		int link = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(visited[i] && visited[j]) {
					start += board[i][j];
					start += board[j][i];
				} else if(!visited[i] && !visited[j]) {
					link += board[i][j];
					link += board[j][i];
				}
			}
		}
		return Math.abs(start - link);
	}
}

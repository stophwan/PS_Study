package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int minTime = Integer.MAX_VALUE;
		int maxHeight = 0;

		for(int h=0; h<=256; h++) {
			int time = 0;
			int plus = 0;
			int minus = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[i][j] > h) {
						plus += board[i][j] - h;
					} else {
						minus += h - board[i][j];
					}
				}
			}

			if(minus - plus > b) {
				continue;
			}
			time += plus*2;
			time += minus;
			if(minTime >= time) {
				minTime = time;
				maxHeight = h;
			}
		}

		System.out.println(minTime + " " + maxHeight);

	}
}

package programmers.kakao2020internship;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//어려움 제대로 풀러면 3차원이다.
public class P67259_경주로건설 {
	public int solution(int[][] board) {
		int result = 10000;
		int N = board.length;
		int[][] direction = {{0, 1, 0}, {1, 0, 1}, {0, -1, 2}, {-1, 0, 3}};
		int[][][] dp = new int[4][N][N];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], 10000);
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0, 0, 0});
		queue.offer(new int[]{0, 0, 0, 1});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1], m = cur[2], d = cur[3];

			for (int i = 0; i < 4; i++) {
				int new_x = x + direction[i][0];
				int new_y = y + direction[i][1];

				if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N && board[new_x][new_y] == 0) {
					int new_m = m + 1;
					if (d != direction[i][2]) {
						new_m += 5;
					}
					if (new_m < dp[direction[i][2]][new_x][new_y]) {
						dp[direction[i][2]][new_x][new_y] = new_m;
						if (new_x == N - 1 && new_y == N - 1) {
							continue;
						}
						queue.offer(new int[]{new_x, new_y, new_m, direction[i][2]});
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			result = Math.min(result, dp[i][N - 1][N - 1]);
		}
		return result * 100;
	}
}

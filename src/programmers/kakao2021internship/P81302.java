package programmers.kakao2021internship;

import java.util.LinkedList;
import java.util.Queue;

public class P81302 {
	int[] dx = new int[]{-1, 1, 0, 0};
	int[] dy = new int[]{0, 0, -1, 1};
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		int idx = 0;
		for(String[] place: places) {
			int cnt = 0;
			char[][] board = new char[5][5];
			for(String s: place) {
				char[] carr = s.toCharArray();
				for(int i=0; i<carr.length; i++) {
					board[cnt][i] = carr[i];
				}
				cnt++;
			}
			answer[idx] = check(board);
			idx++;
		}
		return answer;
	}

	private int check(char[][] board) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(board[i][j] == 'P') {
					if(!bfs(i, j, board)) {
						return 0;
					}
				}
			}
		}
		return 1;
	}

	private boolean bfs(int x, int y, char[][] board) {
		boolean[][] visited = new boolean[5][5];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		int cnt = 0;
		while(!q.isEmpty()) {
			if(cnt >= 2) {
				return true;
			}
			int len = q.size();
			for(int i=0; i<len; i++) {
				int[] tmp = q.remove();
				x = tmp[0];
				y = tmp[1];
				visited[x][y] = true;
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					if(checkRange(nx, ny) && !visited[nx][ny]) {
						if(board[nx][ny] == 'P') {
							return false;
						}
						if(board[nx][ny] == 'O') {
							q.add(new int[]{nx, ny});
						}
					}
				}
			}
			cnt++;
		}
		return true;
	}

	private boolean checkRange(int x, int y) {
		return x>=0 && x<5 && y>=0 && y<5;
	}
}

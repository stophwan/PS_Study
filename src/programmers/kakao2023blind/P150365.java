package programmers.kakao2023blind;

public class P150365 {
	int n; int m; int r; int c; int k;
	int[][] graph;
	int[] dx = new int[]{1, 0, 0 , -1};
	int[] dy = new int[]{0, -1, 1, 0};
	String[] name = new String[]{"d", "l", "r", "u"};
	String ans = "impossible";
	boolean check = false;
	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		this.n = n; this.m = m; this.r = r-1; this.c = c-1; this.k = k;
		graph = new int[n][m];
		dfs(0, x-1, y-1, "");
		return ans;
	}

	public void dfs(int cnt, int x, int y, String way) {
		int toTarget = Math.abs(r-x) + Math.abs(c-y);
		if(toTarget > k-cnt) {
			return;
		}
		if((k-cnt -toTarget)%2==1) {
			return;
		}

		if(cnt==k) {
			if(x==r && y==c) {
				ans = way;
				check = true;
			}
			return;
		}

		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(checkRange(nx, ny)) {
				dfs(cnt+1, nx, ny, way+name[i]);
				if(check) {
					return;
				}
			}
		}
	}

	private boolean checkRange(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}
}

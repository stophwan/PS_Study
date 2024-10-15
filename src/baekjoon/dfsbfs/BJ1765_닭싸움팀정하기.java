package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1765_닭싸움팀정하기 {
	static int n;
	static List<Integer>[] friends;
	static List<Integer>[] enemies;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;

		friends = new ArrayList[n+1];
		enemies = new ArrayList[n+1];

		for(int i=1; i<=n; i++) {
			friends[i] = new ArrayList<>();
			enemies[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(s.equals("E")) {
				enemies[a].add(b);
				enemies[b].add(a);
			} else {
				friends[a].add(b);
				friends[b].add(a);
			}
		}

		for(int i=1; i<=n; i++) {
			enemyToFriend(0, i, i);
		}

		int ans = 0;
		for(int i=1; i<=n; i++) {
			if(visited[i]) continue;
			dfs(i);
			ans++;
		}
		System.out.println(ans);
	}

	public static void dfs(int now) {
		if(visited[now]) return;
		visited[now] = true;
		for(int next: friends[now]) {
			dfs(next);
		}
	}

	public static void enemyToFriend(int cnt, int root, int now) {
		if(cnt == 2) {
			if(root == now) return;
			friends[root].add(now);
			friends[now].add(root);
			return;
		}

		for(int next: enemies[now]) {
			enemyToFriend(cnt+1, root, next);
		}
	}
}

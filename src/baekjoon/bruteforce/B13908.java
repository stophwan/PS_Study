package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13908 {
	static int n;
	static int m;
	static boolean visited[] = new boolean[10];
	static int count = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		if(m>0) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) {
				visited[Integer.parseInt(st.nextToken())] = true;
			}
		}
		dfs(0, 0);
		System.out.println(count);

	}

	public static void dfs(int len, int knowCnt) {
		if(len == n) {
			if(knowCnt == m) {
				count++;
			}
			return;
		}

		for(int i=0; i<=9; i++) {
			if(visited[i]) {
				visited[i] = false;
				dfs(len+1, knowCnt+1);
				visited[i] = true;
			} else {
				dfs(len+1, knowCnt);
			}
		}
	}
}

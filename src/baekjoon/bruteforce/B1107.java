package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1107 {
	static int move = Integer.MAX_VALUE;
	static int n;
	static int m;
	static boolean[] buttons;
	static Set<Integer> visitNums = new HashSet();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		buttons = new boolean[10];
		if(m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) {
				buttons[Integer.parseInt(st.nextToken())] = true;
			}
		}
		dfs(0, new StringBuilder());
		move = Math.min(move, Math.abs(n - 100));
		System.out.println(move);

	}

	public static void dfs(int cnt, StringBuilder sb) {
		if(cnt > 1 && sb.charAt(0) == '0') {
			return;
		}
		if(sb.length() == 7) {
			return;
		}
		if(cnt > 0) {
			int tmp = Integer.parseInt(sb.toString());
			if(visitNums.contains(tmp)) {
				return;
			}
			visitNums.add(tmp);
			move = Math.min(Math.abs(n - tmp) + String.valueOf(tmp).length(), move);
		}

		for(int i=0; i<=9; i++) {
			if(buttons[i]) {
				continue;
			}
			sb.append(i);
			dfs(cnt+1, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}

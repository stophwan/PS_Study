package baekjoon.bruteforce;

import java.util.*;
import java.io.*;

public class B2661 {
	static int n;
	static boolean find = false;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dfs(0, 0, new StringBuilder());
	}

	public static void dfs(int cnt, int last, StringBuilder sb) {
		if(findRepeat(sb)) {
			return;
		}
		if(cnt == n) {
			System.out.println(sb.toString());
			find = true;
			return;
		}

		for(int i=1; i<=3; i++) {
			if(last == i) {
				continue;
			}
			sb.append(String.valueOf(i));
			dfs(cnt+1, i, sb);
			sb.deleteCharAt(cnt);
			if(find) {
				return;
			}
		}
	}

	public static boolean findRepeat(StringBuilder sb) {
		for(int i=2; i<=sb.length()/2; i++) {
			String back = sb.substring(sb.length() - i, sb.length());
			String front = sb.substring(sb.length() - (2*i), sb.length() - i);
			if(front.equals(back)) {
				return true;
			}
		}
		return false;
	}
}

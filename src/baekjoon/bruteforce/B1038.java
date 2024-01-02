package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1038 {
	static List<Long> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n > 1022) {
			System.out.println(-1);
			return;
		}
		for(int i=0; i<=9; i++) {
			dfs(i);
		}
		Collections.sort(list);
		System.out.println(list.get(n));
	}

	public static void dfs(long num) {
		list.add(num);
		long mod = num % 10;
		for(long i=mod-1; i>=0; i--) {
			dfs(num*10+i);
		}
	}
}

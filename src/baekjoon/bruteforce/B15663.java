package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B15663 {
	static int n;
	static int m;
	static int[] nums;
	static boolean[] visited;
	static Set<Integer> permute = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		visited = new boolean[n];
		nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		dfs(0, new int[m]);

	}

	public static void dfs(int cnt, int[] arr) {
		if(cnt==m) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		int last = 0;
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				continue;
			}
			if(last == nums[i]) {
				continue;
			}
			last = nums[i];
			arr[cnt] = nums[i];
			visited[i] = true;
			dfs(cnt+1, arr);
			visited[i] = false;
		}
	}
}

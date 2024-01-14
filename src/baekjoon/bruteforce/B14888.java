package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
	static int n;
	static int[] nums;
	static int[] ops;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		ops = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, nums[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int cnt, int res) {
		if(cnt == n) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		for(int i=0; i<4; i++) {
			if(ops[i] <= 0) {
				continue;
			}
			ops[i]--;
			switch(i) {
				case 0: dfs(cnt+1, res + nums[cnt]); break;
				case 1: dfs(cnt+1, res - nums[cnt]); break;
				case 2: dfs(cnt+1, res * nums[cnt]); break;
				case 3: dfs(cnt+1, res / nums[cnt]);
			}
			ops[i]++;
		}
	}

}

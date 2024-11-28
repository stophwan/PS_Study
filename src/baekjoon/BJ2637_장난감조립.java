package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2637_장난감조립 {

	static List<int[]>[] toys;
	static int[] inDegree;
	static int[] outDegree;
	static int n, m;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		toys = new ArrayList[n + 1];
		inDegree = new int[n + 1];
		outDegree = new int[n + 1];
		dp = new int[n + 1];

		for(int i = 1; i <= n; i++) {
			toys[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			toys[x].add(new int[] {y, k});
			inDegree[y]++;
			outDegree[x]++;
		}
		calculate();
		for(int i=1; i<=n; i++) {
			if(outDegree[i] == 0) {
				System.out.println(i + " " + dp[i]);
			}
		}
	}

	public static void calculate() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		dp[n] = 1;
		while(!q.isEmpty()) {

			int x = q.poll();

			for(int[] toy: toys[x]) {
				inDegree[toy[0]]--;
				if(inDegree[toy[0]] == 0) {
					q.add(toy[0]);
				}
				dp[toy[0]] += dp[x] * toy[1];
			}
		}
	}
}

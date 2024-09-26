package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//아이디어 생각은 했지만 세부 구현이 어려웠던 문제
public class BJ22866_탑보기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] h = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[n+1];
		int[] near = new int[n+1];
		Arrays.fill(near, -100001);
		Stack<Integer> stack = new Stack<>();
		for(int i = 1; i <= n; i++) {
			while(!stack.isEmpty() && h[stack.peek()] <= h[i]) {
				stack.pop();
			}
			cnt[i] += stack.size();
			if(cnt[i] > 0) near[i] = stack.peek();
			stack.push(i);
		}
		stack = new Stack<>();
		for(int i = n; i >= 1; i--) {
			while(!stack.isEmpty() && h[stack.peek()] <= h[i]) {
				stack.pop();
			}
			int size = stack.size();
			cnt[i] += size;
			if(size > 0 && stack.peek()-i < i-near[i]) {
				near[i] = stack.peek();
			}
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(cnt[i] == 0) {
				sb.append("0\n");
				continue;
			}
			sb.append(cnt[i]).append(" ").append(near[i]).append("\n");
		}
		System.out.println(sb);
	}
}

package programmers.kakao2023blind;

import java.util.Stack;

public class P150369 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		Stack<int[]> dStack = new Stack<>();
		Stack<int[]> pStack = new Stack<>();

		for(int i=0; i<n; i++) {
			if(deliveries[i] != 0) {
				dStack.push(new int[]{i, deliveries[i]});
			}
			if(pickups[i] != 0) {
				pStack.push(new int[]{i, pickups[i]});
			}
		}

		while(!dStack.isEmpty() || !pStack.isEmpty()) {
			int cnt = cap;
			int a = dStack.isEmpty() ? 0 : dStack.peek()[0];
			int b = pStack.isEmpty() ? 0 : pStack.peek()[0];
			int dist = Math.max(a, b) + 1;
			answer += dist  * 2L;
			while(cnt > 0 && !dStack.isEmpty()) {
				int[] d = dStack.pop();
				if(d[1] <= cnt) {
					cnt -= d[1];
				} else {
					dStack.push(new int[]{d[0], d[1] - cnt});
					break;
				}

			}
			cnt = cap;
			while(cnt > 0 && !pStack.isEmpty()) {
				int[] p = pStack.pop();
				if(p[1] <= cnt) {
					cnt -= p[1];
				} else {
					pStack.push(new int[]{p[0], p[1] - cnt});
					break;
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new P150369().solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
	}
}

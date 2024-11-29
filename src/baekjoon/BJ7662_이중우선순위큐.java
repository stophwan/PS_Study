package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7662_이중우선순위큐 {

	static Map<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int test=0; test<t; test++) {
			int input = Integer.parseInt(br.readLine());

			Queue<Integer> min = new PriorityQueue<>();
			Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			map = new HashMap<>();
			for(int i=0; i<input; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();

				if(op.equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					max.add(num);
					min.add(num);
					map.put(num, map.getOrDefault(num, 0)+1);
				} else {
					int type = Integer.parseInt(st.nextToken());
					if(map.isEmpty()) continue;
					if(type == 1) {
						delete(max);
					}else {
						delete(min);
					}
				}
			}

			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				int res = delete(max);
				sb.append(res).append(" ");
				if(!map.isEmpty()) res = delete(min);
				sb.append(res).append("\n");
			}
		}
		System.out.println(sb);
	}

	static int delete(Queue<Integer> q) {
		int res = 0;
		while(!q.isEmpty()) {
			res = q.poll();
			int cnt = map.getOrDefault(res, 0);
			if(cnt >= 1) {
				if(cnt ==1) map.remove(res);
				else map.put(res, cnt-1);
				break;
			}
		}

		return res;
	}
}

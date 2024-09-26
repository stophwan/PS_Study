package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

//맞았지만, 다시 볼만한 문제
public class B18513_샘터 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<int[]> q = new LinkedList<>();
		Set<Integer> points = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			q.add(new int[]{x,0});
			points.add(x);
		}
		long res = 0;
		int cnt = -n;
		while(!q.isEmpty()) {
			int[] now = q.remove();
			int p = now[0];
			int dist = now[1];
			res += dist;
			cnt++;
			if(cnt >= k) break;

			if(!points.contains(p-1)) {
				points.add(p-1);
				q.add(new int[]{p-1,dist+1});
			}
			if(!points.contains(p+1)) {
				points.add(p+1);
				q.add(new int[]{p+1,dist+1});
			}
		}
		System.out.println(res);
	}
}

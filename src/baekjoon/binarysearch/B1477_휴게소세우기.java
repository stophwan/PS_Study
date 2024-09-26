package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//아이디어는 생각했지만 틀렸던 문제
public class B1477_휴게소세우기 {
	static int n, m, l;
	static int[] roads;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		roads = new int[n+1];
		if(n > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				roads[i] = Integer.parseInt(st.nextToken());
			}
		}
		roads[n] = l;

		Arrays.sort(roads);
		System.out.println(binarySearch());
	}

	public static int binarySearch() {
		int left = 1;
		int right = l-1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (calculate(mid) <= m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static int calculate(int dist) {
		int cnt = 0;
		int now = 0;
		for(int i=0; i<=n; i++) {
			cnt += (roads[i]-now-1)/dist;
			now = roads[i];
		}
		return cnt;
	}
}

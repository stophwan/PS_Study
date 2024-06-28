package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_공유기 {

	static int n, m;
	static int[] houses;
	public static int search() {
		int left = 0;
		int right = houses[n-1] - houses[0];

		while(left <= right) {
			int mid = (left+right)/2;
			if(calculate(mid) >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	public static int calculate(int val) {
		int now = houses[0];
		int cnt = 1;
		for(int i=1; i<n; i++) {
			if(houses[i] - now >= val) {
				cnt++;
				now = houses[i];
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		houses = new int[n];
		for(int i=0; i<n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		System.out.println(search());
	}
}

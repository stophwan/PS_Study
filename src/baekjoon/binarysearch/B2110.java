package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {

	public static int search(int n, int m, int[] houses) {
		int left = 1;
		int right = houses[n-1] - houses[0] + 1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(calculate(mid, n, houses) < m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	public static int calculate(int dist, int n, int[] houses) {
		int cnt = 1;
		int lastLocate = houses[0];

		for(int i=1; i<n; i++) {
			if(houses[i] - lastLocate >= dist) {
				lastLocate = houses[i];
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] houses = new int[n];
		for(int i=0; i<n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		System.out.println(search(n, m, houses));
	}
}

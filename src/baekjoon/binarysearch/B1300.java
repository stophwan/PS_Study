package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1300 {

	public static int search(int n, int k) {
		int left = 1;
		int right = k;
		while(left <= right) {
			int mid = (left + right)/2;

			if(calculate(n, mid) < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static int calculate(int n, int mid) {
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			cnt += Math.min(mid/i, n);
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		System.out.println(search(n, k));
	}
}

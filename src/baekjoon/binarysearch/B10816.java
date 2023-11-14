package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816 {

	public static int upperBound(int n, int[] now, int target) {
		int left = 0;
		int right = n-1;

		while(left <= right) {
			int mid = (left + right)/2;
			if(now[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	public static int lowerBound(int n, int[] now, int target) {
		int left = 0;
		int right = n-1;

		while(left <= right) {
			int mid = (left + right)/2;
			if(now[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] now = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			now[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] targets = new int[m];
		for(int i=0; i<m; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(now);
		StringBuilder sb = new StringBuilder();
		for(int target: targets) {
			int max = upperBound(n, now, target);
			int min = lowerBound(n, now, target);
			sb.append(max - min + 1).append(" ");
		}
		System.out.println(sb);
	}
}

//System.out.println(max + " " + min);

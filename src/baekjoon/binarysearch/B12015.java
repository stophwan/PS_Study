package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B12015 {
	static List<Integer> list = new ArrayList<>();

	public static int binarySearch(int len, int num) {
		int left = 0;
		int right = len-1;

		while(left <= right) {
			int mid = (left + right)/2;
			if(list.get(mid) >= num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int len = 1;
		list.add(0);
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(list.get(len-1) < num) {
				list.add(num);
				len++;
				continue;
			}
			int compareIdx= binarySearch(len, num);
			list.set(compareIdx, num);
		}
		System.out.println(len-1);
	}
}

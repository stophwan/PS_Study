package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1365 {
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		list.add(nums[0]);
		int lastIdx = 0;
		for(int i=1; i<n; i++) {
			if(nums[i] > list.get(lastIdx)) {
				list.add(nums[i]);
				lastIdx++;
			} else {
				int idx = binarySearch(nums[i]);
				list.set(idx, nums[i]);
			}
		}

		int minNum = n - list.size();
		System.out.println(minNum);
	}

	public static int binarySearch(int target) {
		int left = 0;
		int right = list.size()-1;
		int mid;
		while(left <= right) {
			mid = (left + right)/2;
			if(list.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}

package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2531 {
	
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + k - 1];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=n; i<n+k-1; i++) {
			arr[i] = arr[i-n];
		}
		int[] nums = new int[d+1];

		int cnt = 0;
		for(int i=0; i<k; i++) {
			if(nums[arr[i]] == 0) {
				cnt++;
			}
			nums[arr[i]]++;
		}
		if(nums[c] == 0) {
			cnt++;
		}
		nums[c]++;

		int res = cnt;
		int start = 0;
		for(int end=k; end<arr.length; end++) {
			if(nums[arr[end]] == 0) {
				cnt++;
			}
			nums[arr[end]]++;
			nums[arr[start]]--;
			if(nums[arr[start]] == 0) {
				cnt--;
			}
			start++;
			res = Math.max(res, cnt);
		}
		System.out.println(res);
	}
}

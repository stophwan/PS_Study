package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {

	public static int[] twoPoint(int n, int[] arr) {
		int left = 0;
		int right = n-1;
		int min = Integer.MAX_VALUE;
		int ans_left = arr[0];
		int ans_right = arr[n-1];
		while(left < right) {
			int tmp = arr[left] + arr[right];
			if(min > Math.abs(tmp)) {
				ans_left = arr[left];
				ans_right = arr[right];
				min = Math.abs(tmp);
			}
			if(tmp < 0) {
				left++;
			} else if(tmp > 0) {
				right--;
			} else {
				break;
			}
		}
		return new int[]{ans_left, ans_right};
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] ans = twoPoint(n, arr);
		System.out.println(ans[0] + " " + ans[1]);
	}
}

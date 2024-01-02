package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1244 {

	static int max = 0;
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t=0; t < testCase; t++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int[] arr = new int[s.length()];
			for(int i=0; i<s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}
			int[] arr2 = arr.clone();
			for(int i=0; i<arr.length; i++) {
				Arrays.sort(arr2);
			}
			int a = 1;
			int maxNum = 0;
			for(int i=0; i<arr.length; i++) {
				maxNum += arr2[i] * a;
				a *= 10;
			}
			int change = Integer.parseInt(st.nextToken());
			dfs(0, arr, 0, change, maxNum);
			check = false;
			System.out.println("#" + (t+1) + " " + max);
			max = 0;
		}
	}

	public static void dfs(int idx, int[] num, int cnt, int change, int maxNum) {
		if(cnt == change) {
			int a = 1;
			int res = 0;
			for(int i=num.length-1; i>=0; i--) {
				res += num[i] * a;
				a *= 10;
			}
			max = Math.max(max, res);
			if(maxNum == max && change%2 == 0) {
				check = true;
			}
			return;
		}

		for(int i=idx; i<num.length; i++) {
			for(int j=i+1; j<num.length; j++) {
				swap(num, i, j);
				dfs(i, num, cnt+1, change, maxNum);
				if(check) {
					return;
				}
				swap(num, j, i);
			}
		}
	}

	public static void swap(int[] num, int a, int b) {
		int tmp = num[a];
		num[a] = num[b];
		num[b] = tmp;
	}
}

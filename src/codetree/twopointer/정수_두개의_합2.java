package codetree.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정수_두개의_합2 {
	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성해주세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int r = n-1;
		int ans = 0;
		for(int l=0; l<n; l++) {
			while(r != 0 && arr[l] + arr[r] > k) {
				r--;
			}
			if(l >= r) break;
			ans += r-l;
		}
		System.out.println(ans);
	}
}

package basiccode;

import java.util.Arrays;

public class BruteForce {
	public static void search(int cnt, int idx, int[] arr) {
		System.out.println(Arrays.toString(arr));
		if(cnt == 5) {
			return;
		}

		for(int i=idx; i<5; i++) {
			arr[i]++;
			search(cnt+1, i+1, arr);
			arr[i]--;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[5];
		search(0, 0, arr);
	}
}

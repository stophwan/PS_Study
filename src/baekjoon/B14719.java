package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] block = new int[w];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<w; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}

		int area = 0;
		for(int i=1; i<w-1; i++) {
			int leftMax = getMax(block, 0, i-1);
			int rightMax = getMax(block, i+1, w-1);

			int max = Math.min(leftMax, rightMax);
			if(max - block[i] > 0) {
				area += max - block[i];
			}
		}
		System.out.println(area);
	}

	public static int getMax(int[] block, int w1, int w2) {
		int max = 0;
		for(int i=w1; i<=w2; i++) {
			max = Math.max(max, block[i]);
		}
		return max;
	}
}

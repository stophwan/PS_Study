package basiccode;

import java.util.Arrays;

public class ChooseArr {
	static int cnt;

	static void choose1(int cnt, int idx, int[] res) {
		if(cnt==5) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i=idx; i<res.length; i++) {
			res[i]++;
			choose1(cnt+1, i, res);
			res[i]--;
		}
	}
	static void choose2(int idx, int[] res, int[] info) {
		if(idx==2) {
			cnt++;
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i=0; i<3; i++) {
			//System.out.println("idx:" + idx+ " i:" + i + " " + Arrays.toString(res));
			if(res[i]>info[i]) {
				break;
			}
			res[i]++;
			choose2(idx+1, res, info);
			res[i]--;
		}
	}

	public static void main(String[] args) {
		choose1(0, 0, new int[]{0,0,0});
	}
}

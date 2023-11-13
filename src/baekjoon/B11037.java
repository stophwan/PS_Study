package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B11037 {
	static List<Integer> list = new ArrayList<>();
	public static int binarySearch(int num, int len) {
		int start = 0;
		int end = len-1;
		while(start<=end) {
			int mid = (start + end)/2;
			if(list.get(mid) > num) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static void makeAllCases(int max, int bit, StringBuilder sb) {
		if(sb.length()==max) {
			list.add(Integer.valueOf(sb.toString()));
			return;
		}
		for(int i=1; i<=9; i++) {
			if(((1 << i) & bit) == 0) {
				makeAllCases(max, (1 << i) | bit, sb.append(i));
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		for(int i=1; i<=9; i++) {
			makeAllCases(i, 0, new StringBuilder());
		}
		int len = list.size();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				int num = Integer.parseInt(br.readLine());
				if(num >= 987654321) {
					System.out.println(0);
					continue;
				}
				System.out.println(list.get(binarySearch(num, len)));
			} catch (NumberFormatException e) {
				break;
			}

		}
	}
}

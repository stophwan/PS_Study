package programmers.kakao2023blind;

import java.util.Arrays;

public class P150367 {
	boolean check = true;
	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];
		int idx = 0;
		for(long number: numbers) {
			String binary = Long.toBinaryString(number);
			binary = addZero(binary);
			if(binary.length()==1) {
				if(binary.equals("0")) {
					check = false;
				}
			}
			check(binary);
			answer[idx] = check ? 1 : 0;
			idx++;
			check = true;

		}
		return answer;
	}

	private void check(String binary) {
		int len = binary.length();
		if(len==1) {
			return;
		}
		int root = len/2;
		int lc = (root-1)/2;
		int rc = (root+len)/2;
		if(binary.charAt(lc)=='1' || binary.charAt(rc)=='1') {
			if(binary.charAt(root)=='0') {
				check = false;
				return;
			}
		}
		check(binary.substring(0, root));
		check(binary.substring(root+1, len));

	}

	private String addZero(String binary) {
		int cnt = 0;
		int len = binary.length();
		while(len != 0) {
			cnt++;
			len /= 2;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<(Math.pow(2, cnt)-1 - binary.length()); i++){
			sb.append("0");
		}
		sb.append(binary);
		return sb.toString();
	}

	public static void main(String[] args) {
		long[] numbers = new long[]{10000000000L};
		System.out.println(Arrays.toString(new P150367().solution(numbers)));
	}
}

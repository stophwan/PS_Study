package programmers.kakao2021internship;

import java.util.Stack;

public class P81303 {
	public String solution(int n, int k, String[] cmd) {
		int[] arr = new int[n];
		Stack<Integer> delete = new Stack<>();
		int now = k;
		int size = n;
		for(String s: cmd) {
			String[] s_arr = s.split(" ");
			if(s_arr[0].equals("U")) {
				now -= Integer.parseInt(s_arr[1]);
				if(now<0) {
					now += size;
				}
			}
			if(s_arr[0].equals("D")) {
				now += Integer.parseInt(s_arr[1]);
				if(now >= size) {
					now -= size;
				}
			}
			if(s_arr[0].equals("C")) {
				delete.push(now);
				if(now == size-1) {
					now--;
				}
				size--;
			}
			if(s_arr[0].equals("Z")) {
				if(delete.pop() <= now) {
					now++;
				}
				size++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			sb.append("O");
		}
		while(!delete.isEmpty()) {
			sb.insert(delete.pop(), "X");
		}
		return sb.toString();
	}
}

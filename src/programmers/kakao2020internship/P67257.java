package programmers.kakao2020internship;

import java.util.ArrayList;
import java.util.List;

public class P67257 {
	public long solution(String expression) {
		String[][] cases = new String[][] {{"+","-","*"}, {"+","*","-"},
			{"-","+","*"}, {"-","*","+"},
			{"*","+","-"}, {"*","-","+"}};

		long answer = 0;
		List<String> list = new ArrayList<>();
		StringBuilder tmp = new StringBuilder();
		for(int i=0; i<expression.length(); i++) {
			char c = expression.charAt(i);
			if(c =='*' || c =='+' ||  c =='-') {
				if(tmp.length() > 0) {
					list.add(tmp.toString());
					tmp = new StringBuilder();
				}
				list.add(String.valueOf(c));
			} else {
				tmp.append(expression.charAt(i));
			}
		}
		list.add(tmp.toString());
		for(String[] cas: cases) {
			List<String> subList = new ArrayList<>(list);
			for(String s: cas) {
				for(int i=0; i<subList.size(); i++) {
					if(subList.get(i).equals(s)) {
						subList.set(i-1, String.valueOf(calculate(subList, i)));
						subList.remove(i);
						subList.remove(i);
						i--;
					}
				}
			}
			answer = Math.max(Math.abs(Long.valueOf(subList.get(0))), answer);
		}

		return answer;
	}

	private long calculate(List<String> list, int idx) {
		long a = Long.parseLong(list.get(idx-1));
		long b = Long.parseLong(list.get(idx+1));
		if(list.get(idx).equals("*")) {
			return a * b;
		} else if(list.get(idx).equals("+")) {
			return a + b;
		}
		return a - b;
	}
}

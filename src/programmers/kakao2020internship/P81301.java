package programmers.kakao2020internship;

import java.util.HashMap;
import java.util.Map;

public class P81301 {
	Map<String, String> map = new HashMap<>(){{
		put("zero", "0");
		put("one", "1");
		put("two", "2");
		put("three", "3");
		put("four", "4");
		put("five", "5");
		put("six", "6");
		put("seven", "7");
		put("eight", "8");
		put("nine", "9");
	}};
	public int solution(String s) {
		char[] arr = s.toCharArray();
		StringBuilder res = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for(char c: arr) {
			if(c >= '0' && c <= '9') {
				res.append(c);
				continue;
			}
			sb.append(c);
			if(map.get(sb.toString())!=null) {
				res.append(map.get(sb.toString()));
				sb = new StringBuilder();
			}
		}
		return Integer.parseInt(res.toString());
	}
}

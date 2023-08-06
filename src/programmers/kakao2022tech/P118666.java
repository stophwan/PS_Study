package programmers.kakao2022tech;

import java.util.HashMap;
import java.util.Map;

public class P118666 {
	public String solution(String[] survey, int[] choices) {
		String answer = "";
		Character[] arr = new Character[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
		String[] categories = new String[]{"RT", "CF", "JM", "AN"};
		Map<Character, Integer> map = new HashMap();
		for(Character s: arr) {
			map.put(s, 0);
		}
		for(int i=0; i<choices.length; i++) {
			String sur = survey[i];
			if(choices[i] < 4) {
				map.put(sur.charAt(0), map.get(sur.charAt(0)) + 4-choices[i]);
			} else {
				map.put(sur.charAt(1), map.get(sur.charAt(1)) + choices[i]-4);
			}
		}
		return new StringBuilder()
			.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
			.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
			.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
			.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N')
			.toString();
	}
}

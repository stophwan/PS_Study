package programmers.kakao2020internship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P67258 {
	public int[] solution(String[] gems) {
		int kind = new HashSet<>(Arrays.asList(gems)).size();
		int l = 0;
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];
		Map<String, Integer> map = new HashMap<>();
		for(int r=0; r<gems.length; r++) {
			map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);

			while(map.get(gems[l]) > 1) {
				map.put(gems[l], map.get(gems[l]) - 1);
				l++;
			}
			if(map.size() == kind && min > r-l) {
				min = r - l;
				answer[0] = l+1;
				answer[1] = r+1;
			}
		}
		return answer;
	}
}

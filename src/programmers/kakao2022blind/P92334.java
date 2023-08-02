package programmers.kakao2022blind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P92334 {
	public int[] solution(String[] id_list, String[] report, int k) {

		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();
		Set<String> out = new HashSet<>();
		int[] mail = new int[id_list.length];

		for(String s: report) {
			String[] arr = s.split(" ");
			String user = arr[0];
			String target = arr[1];
			map.putIfAbsent(user, new ArrayList<>());
			if(!map.get(user).contains(target)) {
				map.get(user).add(target);
				count.put(target, count.getOrDefault(target, 0) + 1);
			}
		}

		for(String target: count.keySet()) {
			if(count.get(target) >= k) {
				out.add(target);
			}
		}

		for(int i=0; i<id_list.length; i++) {
			List<String> list = map.get(id_list[i]);
			if(list!=null) {
				for(String s: list) {
					if(out.contains(s)) {
						mail[i]++;
					}
				}
			}
		}

		return mail;
	}
}

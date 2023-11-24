package programmers.kakao2019internship;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P64063 {
	Map<Long, Long> map = new HashMap<>();
	Set<Long> set = new HashSet<>();
	public long[] solution(long k, long[] room_number) {
		int len = room_number.length;
		long[] answer = new long[len];


		for(int i=0; i<len; i++) {
			answer[i] = findNextNum(room_number[i]);
		}
		return answer;
	}

	public long findNextNum(long roomNum) {
		if(!map.containsKey(roomNum)) {
			map.put(roomNum, roomNum+1);
			return roomNum;
		}

		long num = findNextNum(map.get(roomNum));
		map.put(roomNum, num);
		return num;
	}
}

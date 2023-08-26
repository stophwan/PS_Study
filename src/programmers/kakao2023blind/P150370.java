package programmers.kakao2023blind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P150370 {
	public int[] solution(String today, String[] terms, String[] privacies) {
		int[] expiredDays = new int[privacies.length];
		List<Integer> list = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();

		for(String term: terms) {
			String[] arr = term.split(" ");
			String type = arr[0];
			int period = Integer.parseInt(arr[1]);
			map.put(type, period);
		}

		for(int i=0; i<privacies.length; i++) {
			String[] arr = privacies[i].split(" ");
			String date = arr[0];
			String type = arr[1];
			expiredDays[i] = convertToDays(date) + map.get(type)*28;
		}

		int todayDays = convertToDays(today);
		for(int i=0; i<expiredDays.length; i++) {
			if(todayDays > expiredDays[i]) {
				list.add(i+1);
			}
		}

		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public int convertToDays(String date) {
		String[] arr = date.split("\\.");
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int day = Integer.parseInt(arr[2]);

		return (year-2000)*28*12 + (month-1)*28 + (day-1);
	}


	public static void main(String[] args) {
		String[] terms = new String[]{"Z 3", "D 5"};
		String[] privacies = new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		System.out.println(new P150370().solution("2020.01.01", terms, privacies));
	}
}

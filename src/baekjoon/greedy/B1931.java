package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Meeting> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Meeting(start, end));
		}
		Collections.sort(list, (o1, o2) -> {
			if(o1.end == o2.end) {
				return o1.start - o2.start;
			}
			return o1.end - o2.end;
		});

		int time = 0;
		int cnt = 0;
		for(int i=0; i<list.size(); i++) {
			Meeting meeting = list.get(i);
			if(time <= meeting.start) {
				time = meeting.end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static class Meeting {
		int start;
		int end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}

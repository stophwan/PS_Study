package programmers.kakao2022tech;

import java.util.LinkedList;
import java.util.Queue;

public class P118667 {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long s1 = 0, s2 = 0;
		Queue<Long> q1 = new LinkedList<>();
		Queue<Long> q2 = new LinkedList<>();
		for(long n: queue1) {
			s1 += n;
			q1.offer(n);
		}

		for(long n: queue2) {
			s2 += n;
			q2.offer(n);
		}

		if(s1==s2) {
			return 0;
		}

		while(s1 != s2) {
			if(answer > queue1.length*3) {
				answer = -1;
				break;
			}
			if(q1.isEmpty() || q2.isEmpty()){
				answer = -1;
				break;
			}
			if(s1 > s2) {
				long tmp = q1.poll();
				q2.offer(tmp);
				s2 += tmp;
				s1 -= tmp;
			} else {
				long tmp = q2.poll();
				q1.offer(tmp);
				s1 += tmp;
				s2 -= tmp;
			}
			answer++;
		}

		return answer;
	}
}

package programmers.kakao2023blind;

import java.util.ArrayList;
import java.util.List;

public class P150368 {
	int[] discountRate = new int[]{10, 20, 30, 40};
	int ecount;
	List<int[]> list = new ArrayList<>();
	int[][] users;
	int[] emoticons;
	public int[] solution(int[][] users, int[] emoticons) {
		this.users = users;
		this.emoticons = emoticons;
		ecount = emoticons.length;
		permute(0, new int[ecount]);
		list.sort((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o2[0] - o1[0];
		});
		return list.get(0);
	}

	public void permute(int cnt, int[] discount) {
		if(cnt==ecount) {
			int person = 0;
			int sales = 0;
			for(int[] user: users) {
				int money = 0;
				for(int i=0; i<ecount; i++) {
					if(user[0] <= discount[i]) {
						money += emoticons[i]*(100-discount[i])*0.01;
					}
				}
				if(money >= user[1]) {
					person++;
					money = 0;
				}
				sales += money;
			}
			list.add(new int[]{person, sales});
			return;
		}

		for(int i=0; i<4; i++) {
			discount[cnt] = discountRate[i];
			permute(cnt+1, discount);
			discount[cnt] = 0;
		}
	}
}

package programmers.kakao2019internship;

public class B64062 {
	int[] stones;
	int k;
	
	public int solution(int[] stones, int k) {
		this.stones = stones;
		this.k = k;
		int answer = binarySearch();
		return answer;
	}

	public int binarySearch() {
		int left = 0;
		int right = 200000000;
		int mid;
		while(left <= right) {
			mid = (left+right)/2;
			if(calculate(mid) > k) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	public int calculate(int num) {
		int skip = 0;
		int max = 0;
		for(int i=0; i<stones.length; i++) {
			if(stones[i] - num < 0) {
				skip++;
			} else {
				max = Math.max(max, skip);
				skip = 0;
			}
		}
		max = Math.max(max, skip);
		return max + 1;
	}
}

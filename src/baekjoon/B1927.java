package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class B1927 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(q.remove());
				}
			} else {
				q.add(x);
			}
		}
	}
}

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr1 = s.split("-");
		List<Integer> list = new ArrayList<>();
		for (String value : arr1) {
			String[] arr2 = value.split("\\+");
			int sum = 0;
			for (String item : arr2) {
				sum += Integer.parseInt(item);
			}
			list.add(sum);
		}
		int ans = list.get(0);
		for(int i=1; i<list.size(); i++) {
			ans -= list.get(i);
		}
		System.out.println(ans);
	}
}

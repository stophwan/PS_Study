package basiccode;

import java.util.Arrays;

public class PermutationCombinationArray {

	static int[] arr = {1,2,3,4};
	static int n = 4, r = 3;
	static boolean[] visited = new boolean[n];

	//순열
	public static void permutation(int dep, int[] res) {
		if(dep == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				res[dep] = arr[i];
				visited[i] = true;
				permutation(dep+1, res);
				visited[i] = false;
			}
		}
	}

	//중복순열
	public static void duplicatePermutation(int dep, int[] res) {
		if(dep == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i=0; i<n; i++) {
			res[dep] = arr[i];
			duplicatePermutation(dep+1, res);
		}
	}

	//조합
	public static void combination(int idx, int dep, int[] res) {
		if(dep == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i=idx; i<n; i++) {
			res[dep] = arr[i];
			combination(i+1, dep+1, res);
		}
	}

	//중복조합
	public static void duplicateCombination(int idx, int dep, int[] res) {
		if(dep == r) {
			System.out.println(Arrays.toString(res));
			return;
		}
		for(int i=idx; i<n; i++) {
			res[dep] = arr[i];
			duplicateCombination(i, dep+1, res);
		}
	}


	public static void main(String[] args) {
		System.out.println("순열");
		permutation(0, new int[r]);
		System.out.println("-------------------");

		System.out.println("중복순열");
		duplicatePermutation(0, new int[r]);
		System.out.println("-------------------");

		System.out.println("조합");
		combination(0, 0, new int[r]);
		System.out.println("-------------------");

		System.out.println("중복 조합");
		duplicateCombination(0, 0, new int[r]);
		System.out.println("-------------------");
	}
}

package programmers.kakao2023blind;

import java.util.ArrayList;
import java.util.List;

public class P150366 {
	String[][] board = new String[51][51];
	Node[][] merged = new Node[51][51];
	public String[] solution(String[] commands) {
		for(int i=1; i<51; i++) {
			for(int j=1; j<51; j++) {
				board[i][j] = "EMPTY";
				merged[i][j] = new Node(i,j);
			}
		}
		List<String> res = new ArrayList<>();
		for(String command: commands) {
			String[] arr = command.split(" ");
			String control = arr[0];
			if(control.equals("UPDATE")) {
				if(arr.length==4) {
					update(arr);
				}
				if(arr.length==3) {
					updateAll(arr);
				}
			}
			if(control.equals("MERGE")) {
				merge(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
					Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
			}
			if(control.equals("UNMERGE")) {
				unmerge(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			}
			if(control.equals("PRINT")) {
				Node node =
					merged[Integer.parseInt(arr[1])][Integer.parseInt(arr[2])];
				res.add(board[node.r][node.c]);
			}
		}
		String[] answer = new String[res.size()];
		for(int i=0; i<res.size(); i++) {
			answer[i] = res.get(i);
		}
		return answer;
	}

	private void merge(int r1, int c1, int r2, int c2) {
		if(r1==r2 && c1==c2) {
			return;
		}
		if(merged[r1][c1].equals(merged[r2][c2])) {
			return;
		}
		Node node1 = merged[r1][c1];
		Node node2 = merged[r2][c2];
		for(int i=1; i<51; i++) {
			for(int j=1; j<51; j++) {
				if(merged[i][j].equals(node2)) {
					merged[i][j] = merged[r1][c1];
				}
			}
		}
		if(board[node1.r][node1.c].equals("EMPTY")) {
			board[node1.r][node1.c] = board[node2.r][node2.c];
		} else {
			board[node2.r][node2.c] = board[node1.r][node1.c];
		}
	}

	private void unmerge(int r, int c) {
		Node node = merged[r][c];
		String content = board[node.r][node.c];
		for(int i=1; i<51; i++) {
			for(int j=1; j<51; j++) {
				if(merged[i][j].equals(node)) {
					merged[i][j] = new Node(i,j);
					board[i][j] = "EMPTY";
				}
			}
		}
		board[r][c] = content;
	}


	private void update(String[] arr) {
		int r = Integer.parseInt(arr[1]);
		int c = Integer.parseInt(arr[2]);
		String value = arr[3];
		Node node = merged[r][c];
		board[node.r][node.c] = value;
	}

	private void updateAll(String[] arr) {
		String target = arr[1];
		String change = arr[2];
		for(int i=1; i<51; i++) {
			for(int j=1; j<51; j++) {
				if(board[i][j].equals(target)) {
					board[i][j] = change;
				}
			}
		}
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Node node = (Node)o;
			return r == node.r && c == node.c;
		}
	}
}

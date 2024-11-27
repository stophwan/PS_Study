package basiccode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
	public static void main(String[] args) {
		// 그래프 정의
		int vertices = 6; // 노드 개수
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 추가 (예제 그래프)
		addEdge(graph, 5, 2);
		addEdge(graph, 5, 0);
		addEdge(graph, 4, 0);
		addEdge(graph, 4, 1);
		addEdge(graph, 2, 3);
		addEdge(graph, 3, 1);

		// 위상 정렬 실행
		List<Integer> result = topologicalSort(graph, vertices);
		System.out.println("위상 정렬 결과: " + result);
	}

	// 간선을 그래프에 추가
	private static void addEdge(List<List<Integer>> graph, int from, int to) {
		graph.get(from).add(to);
	}

	// 위상 정렬 함수
	private static List<Integer> topologicalSort(List<List<Integer>> graph, int vertices) {
		// 1. 각 노드의 진입 차수 계산
		int[] inDegree = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			for (int neighbor : graph.get(i)) {
				inDegree[neighbor]++;
			}
		}

		// 2. 진입 차수가 0인 노드를 큐에 삽입
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < vertices; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		// 3. 위상 정렬 수행
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int current = queue.poll();
			result.add(current);

			// 현재 노드와 연결된 노드들의 진입 차수 감소
			for (int neighbor : graph.get(current)) {
				inDegree[neighbor]--;
				if (inDegree[neighbor] == 0) {
					queue.add(neighbor);
				}
			}
		}

		// 그래프에 사이클이 존재하는 경우 처리
		if (result.size() != vertices) {
			throw new RuntimeException("사이클이 존재하여 위상 정렬 불가능!");
		}

		return result;
	}
}

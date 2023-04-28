package programmers.highscorekit;

import java.util.Arrays;
import java.util.Comparator;

// greedy 섬 연결하기, MST, 크루스칼 알고리즘, Union에 대해 공부
public class P42861 {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        for(int i=0; i<costs.length ; i++) {
            if(findParent(costs[i][0]) == findParent(costs[i][1])){
                continue;
            }
            answer += costs[i][2];
            union(costs[i][0], costs[i][1]);
        }
        return answer;
    }

    public void union(int node1, int node2) {
        int p1 = findParent(node1);
        int p2 = findParent(node2);

        if(p1 <= p2) {
            parent[p2] = p1;
        }
        else{
            parent[p1] = p2;
        }
    }

    public int findParent(int node) {
        if(node == parent[node]){
            return node;
        }
        return findParent(parent[node]);
    }
}

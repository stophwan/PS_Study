package programmers.highscorekit.greedy;

import java.util.Arrays;
import java.util.Comparator;

// greedy 섬 연결하기, MST, 크루스칼 알고리즘, Union에 대해 공부
public class P42861 {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (o1,o2) -> o1[2]-o2[2]);

        for(int[] cost : costs){
            int p1 = findParent(cost[0]);
            int p2 = findParent(cost[1]);
            if(p1==p2){
                continue;
            }
            union(p1,p2);
            answer += cost[2];
        }
        return answer;
    }

    private void union(int p1, int p2) {
        if(p1<=p2){
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    private int findParent(int n) {
        if(parent[n]==n){
            return n;
        }
        return findParent(parent[n]);
    }
}

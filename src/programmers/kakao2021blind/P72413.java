package programmers.kakao2021blind;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P72413 {
    int[][] graph;
    int n;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new int[n+1][n+1];
        this.n = n;
        for(int[] fare: fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }
        int answer = Integer.MAX_VALUE;

        int[] together = dijkstra(s);
        for(int i=1; i<=n; i++) {
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a] + alone[b];
            answer = Math.min(answer, cost);
        }

        return answer;
    }

    public int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0], v = cur[1];
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            for(int i=1; i<=n; i++) {
                if(graph[u][i]>0) {
                    if(dist[u] + graph[u][i] < dist[i]) {
                        dist[i] = dist[u] + graph[u][i];
                        pq.add(new int[]{i, dist[i]});
                    }
                }
            }
        }
        return dist;
    }
}

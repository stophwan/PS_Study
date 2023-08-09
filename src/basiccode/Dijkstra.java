package basiccode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    private static int[] solve(int start, int n, int[][] graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0];
            if(visited[node]) {
                continue;
            }
            visited[node] = true;
            for(int i=1; i<=n; i++) {
                if(graph[node][i] > 0  && dist[node] + graph[node][i] > dist[i]) {
                    dist[i] = dist[node] + graph[node][i];
                    pq.offer(new int[]{i, dist[i]});
                }
            }
        }
        Arrays.sort(dist);
        return dist;
    }

    public static void main(String[] args) {
        int[][] fares = new int[][]{
                {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
        };
        int n = 6;
        int[][] graph = new int[n+1][n+1];
        for(int[] fare: fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }
        System.out.println(Arrays.toString(solve(1, n, graph)));
    }
}

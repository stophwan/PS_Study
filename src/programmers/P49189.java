package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class P49189 {
    int[] visited;
    ArrayList<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] e: edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        bfs();
        Integer[] w = Arrays.stream(visited).boxed().toArray(Integer[]::new);
        Arrays.sort(w, Collections.reverseOrder());
        int max = w[n];
        for(int i=0; i<n+1; i++) {
            if(w[i]==max){
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }

    void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=1;
        while(!q.isEmpty()) {
            int x = q.poll();
            for(int i: graph[x]){
                if(visited[i]==0){
                    q.add(i);
                    visited[i]=visited[x]+1;
                }
            }
        }
    }
}

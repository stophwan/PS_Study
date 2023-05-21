package programmers.highscorekit.bruteforce;

import java.util.LinkedList;
import java.util.Queue;

public class P86971 {
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];

        for(int[] wire: wires) {
            map[wire[0]][wire[1]] = 1;
            map[wire[1]][wire[0]] = 1;
        }

        for(int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            map[a][b] = 0;
            map[b][a] = 0;

            answer = Math.min(answer, bfs(n,a));

            map[a][b] = 1;
            map[b][a] = 1;
        }

        return answer;
    }

    public int bfs(int n, int a) {
        int cnt = 1;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i=1; i<=n; i++) {
                if(map[now][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return Math.abs(n-2*cnt);
    }
}

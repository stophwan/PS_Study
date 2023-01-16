package programmers;
import java.util.*;

// DFS/BFS 아이템줍기
public class P87694 {

    int[][] graph = new int[101][101];
    int[][] visited = new int[101][101];
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        draw_graph(rectangle);
        int answer = bfs(rectangle, characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }

    public int bfs(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        visited[characterX][characterY] = 1;
        int[] arr = {characterX, characterY,0};
        q.offer(arr);

        while(!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int cnt = q.peek()[2];
            if(x == itemX && y == itemY){
                System.out.println(cnt);
                return cnt/2;
            }
            q.poll();
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0<=nx && nx<=100 && 0<=ny && ny <=100 && graph[nx][ny] == 1 && visited[nx][ny] == 0) {
                    int[] brr = {nx, ny, cnt +1};
                    visited[nx][ny] = 1;
                    q.offer(brr);
                }
            }
        }
        return 0;
    }

    public void draw_graph(int[][] rectangle) {
        for(int[] data : rectangle) {
            for(int i=data[0]*2; i<=data[2]*2; i++) {
                for(int j=data[1]*2; j<=data[3]*2; j++) {
                    graph[i][j] = 1;
                }
            }
        }

        for(int[] data : rectangle) {
            for(int i=data[0]*2+1; i<data[2]*2; i++) {
                for(int j=data[1]*2+1; j<data[3]*2; j++) {
                    graph[i][j] = 0;
                }
            }
        }
    }

}
